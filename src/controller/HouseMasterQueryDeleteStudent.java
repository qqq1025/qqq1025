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

@WebServlet(name = "HouseMasterQueryDeleteStudent", value = "/querysome2")
public class HouseMasterQueryDeleteStudent extends HttpServlet {
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
        List<Student> studentList= null;
        try {
            studentList = dormitoryService.querysomestudent2(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //        if(studentList.size()>0){
//            request.setAttribute("allstudent",studentList);
//            request.getRequestDispatcher("/HousemasterPage.jsp").forward(request,response);
//        }else {
//            response.sendRedirect(request.getContextPath());
//        }
        request.setAttribute("mfloor",mfloor);
        request.setAttribute("allstudent",studentList);
        request.getRequestDispatcher("/housemasterdeletestu.jsp").forward(request,response);
    }
}
