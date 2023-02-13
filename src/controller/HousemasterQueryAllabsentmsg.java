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

@WebServlet(name = "HousemasterQueryAllabsentmsg", value = "/HousemasterQueryAllabsentmsg")
public class HousemasterQueryAllabsentmsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer apartment= Integer.valueOf(request.getParameter("mfloor"));
        DormitoryService dormitoryService=new DormitoryServiceImpl();
//        这里是查询全部的缺寝信息 限制是栋号=apartment 也就是登陆的宿管管理的栋
        List<Absent> absentList= null;
        try {
            absentList = dormitoryService.queryAllAbsentStuMsg(apartment);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mfloor",apartment);
        request.setAttribute("allabsent",absentList);
        request.getRequestDispatcher("/HouseMasterQueryAllabsentMsg.jsp").forward(request,response);
    }
}
