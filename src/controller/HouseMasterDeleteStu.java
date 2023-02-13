package controller;

import entity.Keyword;
import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HouseMasterDeleteStu", value = "/delete")
public class HouseMasterDeleteStu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String key=request.getParameter("key");
        String mfloor=request.getParameter("mfloor");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            Keyword result=dormitoryService.querykeyword(key);
            Student student=new Student(id);
            if(result!=null){
                try {
                    dormitoryService.delete(student);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                response.sendRedirect(request.getContextPath()+"/querystudent2?mfloor="+mfloor);
            }else {
                request.setAttribute("mfloor",mfloor);
                request.getRequestDispatcher("/housemasterdeletestufailpage.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
