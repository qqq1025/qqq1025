package controller;

import entity.Housemaster;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorDeleteHousemasterController", value = "/AdministorDeleteHousemasterController")
public class AdministorDeleteHousemasterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        Housemaster housemaster=new Housemaster(id);
        try {
            dormitoryService.deletehousemaster(housemaster);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/queryallhousermaster");
    }
}
