package controller;

import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HouseMasterPassUpdateAbentMsg", value = "/HouseMasterPassUpdateAbentMsg")
public class HouseMasterPassUpdateAbentMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        String id=request.getParameter("id");
        String mfloor=request.getParameter("mfloor");
        request.setAttribute("mfloor",mfloor);
        request.getRequestDispatcher("/HousemasterUpdateAbsentTime.jsp").forward(request,response);
    }
}
