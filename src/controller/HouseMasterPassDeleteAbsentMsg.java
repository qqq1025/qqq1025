package controller;

import entity.Absent;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HouseMasterPassDeleteAbsentMsg", value = "/HouseMasterPassDeleteAbsentMsg")
public class HouseMasterPassDeleteAbsentMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        Integer sign= null;
        try {
            sign = dormitoryService.housemasterqueryabsentstumsgsign(id);
            List<Absent> absentList= null;
            try {
                absentList = dormitoryService.HousemasterQueryDeleteAbsentMsg(sign);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("sign",sign);
            request.setAttribute("mfloor",mfloor);
            request.setAttribute("allabsent",absentList);
            request.getRequestDispatcher("HouseMasterDeleteAbsentMsg.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        List<Absent> absentList= null;
//        try {
//            absentList = dormitoryService.HousemasterQueryDeleteAbsentMsg(sign);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("mfloor",mfloor);
//        request.setAttribute("allabsent",absentList);
//        request.getRequestDispatcher("HouseMasterDeleteAbsentMsg.jsp").forward(request,response);
    }
}
