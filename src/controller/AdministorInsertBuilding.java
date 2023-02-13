package controller;

import entity.Building;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorInsertBuilding", value = "/AdministorInsertBuilding")
public class AdministorInsertBuilding extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer apartment= Integer.valueOf(request.getParameter("apartment"));
        String induc=request.getParameter("introduction");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            Building result=dormitoryService.querybuildingexisits(apartment);
            if(result==null){
                Building building=new Building(apartment,induc);
                dormitoryService.administorinsertbuilding(building);
                response.sendRedirect(request.getContextPath()+"/AdministorQueryAllBuilding");
            }
            else {
                System.out.println("宿舍楼在使用中");
                response.sendRedirect(request.getContextPath()+"/administorinsertbuildingfailpage.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
