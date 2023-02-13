package controller;

import entity.Absent;
import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HouseMasterInsertAbsentmsg", value = "/absent")
public class HouseMasterInsertAbsentmsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        String mfloor=request.getParameter("mfloor");
        String id=request.getParameter("id");
        String name= null;
        Integer apartment=null;
        String number=null;
        String major=null;
        try {
            name = dormitoryService.queryAbsentStuName(id);
            apartment=dormitoryService.queryAbsentStuApartment(id);
            number=dormitoryService.queryAbsentStuNum(id);
            major=dormitoryService.queryAbsentStuMajor(id);
            String time=request.getParameter("time");
            Student result =dormitoryService.queryAbsentStuexists(id);
            if(result!=null){
                Absent absent=new Absent(id,name,major,apartment,number,time);
                try {
                    dormitoryService.housemasterinsertabsent(absent);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("mfloor",mfloor);
                request.getRequestDispatcher("/housemasterrecodeabsentstu.jsp").forward(request,response);
            }else {
                request.setAttribute("mfloor",mfloor);
                request.getRequestDispatcher("/housemasterinsertabsentmsgfailpage.jsp").forward(request,response);
            }
//            Absent absent=new Absent(id,name,major,apartment,number,time);
//            try {
//                dormitoryService.housemasterinsertabsent(absent);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            request.setAttribute("mfloor",mfloor);
//            request.getRequestDispatcher("/housemasterrecodeabsentstu.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        Integer apartment=dormitoryService.queryAbsentStuApartment(id);
//        String number=dormitoryService.queryAbsentStuNum(id);
//        String major=dormitoryService.queryAbsentStuMajor(id);
//        String name=request.getParameter("name");
//        Integer apartment= Integer.valueOf(request.getParameter("apartment"));
//        String number=request.getParameter("number");
//        String time=request.getParameter("time");
//        String major=request.getParameter("major");
//        Absent absent=new Absent(id,name,major,apartment,number,time);
//        try {
//            dormitoryService.housemasterinsertabsent(absent);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("mfloor",mfloor);
//        request.getRequestDispatcher("/housemasterrecodeabsentstu.jsp").forward(request,response);
    }
}
