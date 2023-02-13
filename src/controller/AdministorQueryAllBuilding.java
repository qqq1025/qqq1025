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

@WebServlet(name = "AdministorQueryAllBuilding", value = "/AdministorQueryAllBuilding")
public class AdministorQueryAllBuilding extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            List<Building> buildingList=dormitoryService.queryAllBuilding();
            request.setAttribute("allbuilding",buildingList);
            request.getRequestDispatcher("/administorcheckbuilding.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
