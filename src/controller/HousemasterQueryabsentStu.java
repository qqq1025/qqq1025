package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HousemasterQueryabsentStu", value = "/HousemasterQueryabsentStu")
public class HousemasterQueryabsentStu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String id=request.getParameter("id");
//        这里可以得到选中学生的id做一些操作 看你想法，传mfloor过来是为了返回页面满足只显示宿管管理楼栋的学生
        String mfloor=request.getParameter("mfloor");
        request.setAttribute("mfloor",mfloor);
        request.getRequestDispatcher("/housemasterrecodeabsentstu.jsp").forward(request,response);
    }
}
