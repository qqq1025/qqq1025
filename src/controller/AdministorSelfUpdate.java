package controller;

import entity.Administor;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorSelfUpdate", value = "/update4")
public class AdministorSelfUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String phnum1=request.getParameter("phnum1");
        Administor administor=new Administor(id,password,name,gender,age,phnum1);
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            dormitoryService.update4(administor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/queryAlladministor");
    }
}
