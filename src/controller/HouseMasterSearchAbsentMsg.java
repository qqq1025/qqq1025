package controller;

import entity.Absent;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HouseMasterSearchAbsentMsg", value = "/HouseMasterSearchAbsentMsg")
public class HouseMasterSearchAbsentMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String element=request.getParameter("search-elm");
        String mfloor=request.getParameter("mfloor");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        List<Absent> absentList = null;
        try {
            absentList = dormitoryService.housemastersearchabsentmsg(element,mfloor);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mfloor",mfloor);
        request.setAttribute("allabsent",absentList);
        request.getRequestDispatcher("HouseMasterQueryAllabsentMsg.jsp").forward(request,response);
    }
}
