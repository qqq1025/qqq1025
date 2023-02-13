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

@WebServlet(name = "QueryDeletehousemasterController", value = "/querydeletehousemaster")
public class QueryDeletehousemasterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Housemaster> housemastersList= null;
        try {
            housemastersList = dormitoryService.querysomehousemaster(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("allhousemaster",housemastersList);
        request.getRequestDispatcher("/deletehousemaster.jsp").forward(request,response);
    }
}
