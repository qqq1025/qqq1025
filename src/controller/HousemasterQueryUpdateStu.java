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

@WebServlet(name = "HousemasterQueryUpdateStu", value = "/housemasterqueryupdatestu")
public class HousemasterQueryUpdateStu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
//        DormitoryService dormitoryService=new DormitoryServiceImpl();
//        List<Student> studentList= null;
//        try {
//            studentList = dormitoryService.queryupdatestu(id);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        request.setAttribute("mfloor",mfloor);
//        request.setAttribute("allstudent",studentList);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
