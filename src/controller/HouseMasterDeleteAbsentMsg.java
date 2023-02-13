package controller;

import entity.Absent;
import entity.Keyword;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HouseMasterDeleteAbsentMsg", value = "/HouseMasterDeleteAbsentMsg")
public class HouseMasterDeleteAbsentMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        String id=request.getParameter("id");
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
        String key=request.getParameter("key");
        try {
            Keyword result=dormitoryService.querykeyword(key);
            Integer sign= null;
            try {
                sign = dormitoryService.housemasterqueryabsentstumsgsign(id);
                Absent absent=new Absent(sign);
                if(result!=null){
                    try {
                        dormitoryService.housemasterDeleteAbsentMsg(absent);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    response.sendRedirect(request.getContextPath()+"/HousemasterQueryAllabsentmsg?mfloor="+mfloor);
                }
                else {
                    request.setAttribute("mfloor",mfloor);
                    request.getRequestDispatcher("/housemasterdeleteabsentmsgfailpage.jsp").forward(request,response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        Integer sign= null;
//        try {
//            sign = dormitoryService.housemasterqueryabsentstumsgsign(id);
//            Absent absent=new Absent(sign);
//            if(key.equals("12344")){
//                try {
//                    dormitoryService.housemasterDeleteAbsentMsg(absent);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                response.sendRedirect(request.getContextPath()+"/HousemasterQueryAllabsentmsg?mfloor="+mfloor);
//            }
//            else {
//                request.setAttribute("mfloor",mfloor);
//                request.getRequestDispatcher("/housemasterdeleteabsentmsgfailpage.jsp").forward(request,response);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//            Absent absent=new Absent(sign);
//            if(key.equals("12344")){
//                try {
//                    dormitoryService.housemasterDeleteAbsentMsg(absent);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                response.sendRedirect("/HousemasterQueryAllabsentmsg?mfloor="+mfloor);
//            }
//            else {
//                request.setAttribute("mfloor",mfloor);
//                request.getRequestDispatcher("/housemasterdeleteabsentmsgfailpage.jsp").forward(request,response);
//            }
    }
}
