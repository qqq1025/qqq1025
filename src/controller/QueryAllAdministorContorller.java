package controller;

import entity.Administor;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "QueryAllAdministorContorller", value = "/queryAlladministor")
public class QueryAllAdministorContorller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Administor> alladministor= null;
        try {
            alladministor = dormitoryService.queryAlladiministor();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("alladministor",alladministor);
        request.getRequestDispatcher("/allAdministor.jsp").forward(request,response);
    }
}
