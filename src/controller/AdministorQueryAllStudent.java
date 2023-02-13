package controller;

import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorQueryAllStudent", value = "/querystudentadministor")
public class AdministorQueryAllStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Student> allstudent= null;
        try {
            allstudent = dormitoryService.queryAllStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("allstudent",allstudent);
        request.getRequestDispatcher("/administorchakeStudent.jsp").forward(request,response);
    }
}
