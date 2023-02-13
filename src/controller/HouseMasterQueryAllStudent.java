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

@WebServlet(name = "HouseMasterQueryAllStudent", value = "/querystudent2")
public class HouseMasterQueryAllStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
            List<Student> allhousemaster= null;
            try {
            allhousemaster = dormitoryService.queryAllStudent(mfloor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mfloor",mfloor);
        request.setAttribute("allstudent",allhousemaster);
        request.getRequestDispatcher("/HousemasterPage.jsp").forward(request,response);
    }
}
