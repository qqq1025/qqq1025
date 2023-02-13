package controller;

import entity.Housemaster;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorUpdateHouseMaster", value = "/update3")
public class AdministorUpdateHouseMaster extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String phnum=request.getParameter("phnum");
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
        Housemaster housemaster=new Housemaster(id,password,name,gender,age,phnum,mfloor);
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            dormitoryService.update3(housemaster);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/queryallhousermaster");
    }
}
