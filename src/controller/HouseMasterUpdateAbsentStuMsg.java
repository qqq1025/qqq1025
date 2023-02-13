package controller;

import entity.Absent;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HouseMasterUpdateAbsentStuMsg", value = "/HouseMasterUpdateAbsentStuMsg")
public class HouseMasterUpdateAbsentStuMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id= request.getParameter("id");
        String mfloor=request.getParameter("mfloor");
        String time=request.getParameter("time");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        Absent absent=new Absent(id,time);
        try {
            dormitoryService.houseMasterUpdateStuAbsentMsg(absent);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/HousemasterQueryAllabsentmsg?mfloor="+mfloor);
    }
}
