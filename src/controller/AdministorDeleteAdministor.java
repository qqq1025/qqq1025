package controller;

import entity.Administor;
import entity.Keyword;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorDeleteAdministor", value = "/AdministorDeleteAdministor")
public class AdministorDeleteAdministor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String key=request.getParameter("key");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            Keyword result=dormitoryService.querykeyword(key);
            Administor administor=new Administor(id);
            if(result!=null){
                try {
                    dormitoryService.deleteadministor(administor);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                response.sendRedirect(request.getContextPath()+"/queryAlladministor");
            }else {
                response.sendRedirect(request.getContextPath()+"/administorselfdeletefailpage.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
