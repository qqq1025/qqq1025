package controller;

import entity.Administor;
import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorSelfSearch", value = "/querysome5")
public class AdministorSelfSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String element=request.getParameter("search-elm");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Administor> alladministor= null;
        try {
            alladministor = dormitoryService.querysomeadministor(element);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("alladministor",alladministor);
        request.getRequestDispatcher("/allAdministor.jsp").forward(request,response);
    }
}
