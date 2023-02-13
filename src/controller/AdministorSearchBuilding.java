package controller;

import entity.Building;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorSearchBuilding", value = "/AdministorSearchBuilding")
public class AdministorSearchBuilding extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryServic=new DormitoryServiceImpl();
        Integer apartment= Integer.valueOf(request.getParameter("search-elm"));
        try {
            List<Building> buildingList=dormitoryServic.querysomebuilding(apartment);
            request.setAttribute("allbuilding",buildingList);
//            request.setAttribute("apartment",apartment);
            request.getRequestDispatcher("/administorsearchbuilding.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
