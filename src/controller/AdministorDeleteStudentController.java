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

@WebServlet(name = "AdministorDeleteStudentController", value = "/delete2")
public class AdministorDeleteStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        Student student=new Student(id);
//        List<Student> studentList= null;
        try {
            dormitoryService.delete2(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/querystudentadministor");
//        try {
//            studentList = dormitoryService.querysomestudent4(id);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        request.setAttribute("allstudent",studentList);
//        request.getRequestDispatcher("/delete2.jsp").forward(request,response);
    }
}
