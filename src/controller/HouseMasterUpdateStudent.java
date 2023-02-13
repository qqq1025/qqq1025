package controller;

import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HouseMasterUpdateStudent", value = "/update")
public class HouseMasterUpdateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
        String id=request.getParameter("id");
        String number=request.getParameter("number");
        Integer apartment= Integer.valueOf(request.getParameter("apartment"));
        Integer floor= Integer.valueOf(request.getParameter("floor"));
        Student student=new Student(id,number,floor,apartment);
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            dormitoryService.update(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/querystudent2?mfloor="+mfloor);
    }
}
