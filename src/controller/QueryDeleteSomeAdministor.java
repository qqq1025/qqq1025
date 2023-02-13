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

@WebServlet(name = "QueryDeleteSomeAdministor", value = "/querydeleteadministor")
public class QueryDeleteSomeAdministor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Administor> administorList= null;
        try {
            administorList = dormitoryService.querysomedeleteadministor(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("alladministor",administorList);
        request.getRequestDispatcher("/deleteadministor.jsp").forward(request,response);
    }
}
