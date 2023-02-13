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

@WebServlet(name = "AdministorSearchStudent", value = "/querysome3")
public class AdministorSearchStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String element=request.getParameter("search-elm");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Student> studentList= null;
        try {
            studentList = dormitoryService.querysomestudent3(element);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("allstudent",studentList);
        request.getRequestDispatcher("/administorchakeStudent.jsp").forward(request,response);
    }
}
