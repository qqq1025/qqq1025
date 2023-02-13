package controller;

import entity.Housemaster;
import entity.Housemaster_login;
import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorQueryAllHouseMaster", value = "/queryallhousermaster")
public class AdministorQueryAllHouseMaster extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Housemaster> allhousemaster= null;
        try {
            allhousemaster = dormitoryService.queryAllhousemaster();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("allhousemaster",allhousemaster);
        request.getRequestDispatcher("/administorcheckhousemaster.jsp").forward(request,response);
    }
}
