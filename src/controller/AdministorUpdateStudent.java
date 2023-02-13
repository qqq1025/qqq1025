package controller;

import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorUpdateStudent", value = "/update2")
public class AdministorUpdateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String major=request.getParameter("major");
        String number=request.getParameter("number");
        Integer apartment= Integer.valueOf(request.getParameter("apartment"));
        Integer floor= Integer.valueOf(request.getParameter("floor"));
        Student student=new Student(id,password,name,gender,age,major,floor,apartment,number);
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            dormitoryService.update2(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/querystudentadministor");
    }
}
