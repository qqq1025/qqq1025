package controller;

import entity.Administor;
import entity.Housemaster;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorSearchSomeHousemaster", value = "/AdministorSearchSomeHousemaster")
public class AdministorSearchSomeHousemaster extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String element=request.getParameter("search-elm");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Housemaster> allhousemaster= null;
        try {
            allhousemaster = dormitoryService.querysomehousemasterBy(element);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("allhousemaster",allhousemaster);
        request.getRequestDispatcher("/administorcheckhousemaster.jsp").forward(request,response);
    }
}
