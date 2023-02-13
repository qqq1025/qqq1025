package controller;

import entity.Building;
import entity.Housemaster;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdministorInsertHousemaster", value = "/AdministorInsertHousemaster")
public class AdministorInsertHousemaster extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String phnum=request.getParameter("phnum");
        Integer mfloor= Integer.valueOf(request.getParameter("mfloor"));
        Housemaster housemaster=new Housemaster(id,password,name,gender,age,phnum,mfloor);
        Building result2= null;
        try {
            result2 = dormitoryService.querybuildingexisits(mfloor);
            if (result2!=null){
                try {
                    Housemaster result=dormitoryService.checkhousemasterbyfloor(mfloor);
                    if (result!=null){
                        System.out.println("楼栋已有宿管分配");
                        response.sendRedirect(request.getContextPath()+"/administorinserthousemasterfailpage.jsp");
                    }else{
                        Housemaster result1=dormitoryService.checkhousemasterbyId(id);
                        if(result1!=null){
                            System.out.println("账号存在");
                            request.getRequestDispatcher("/administorinserthousemaster.jsp").forward(request,response);
                        }else {
                            try {
                                dormitoryService.administorinserthms(housemaster);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            response.sendRedirect(request.getContextPath()+"/queryallhousermaster");
                        }

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else {
                System.out.println("楼栋还未安排使用，请先添加使用");
                response.sendRedirect(request.getContextPath()+"/AdminsitorInsertHouseMasterBuildingExisitsPage.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        try {
//            Housemaster result=dormitoryService.checkhousemasterbyfloor(mfloor);
//            if (result!=null){
//                System.out.println("楼栋已有宿管分配");
//                response.sendRedirect(request.getContextPath()+"/administorinserthousemasterfailpage.jsp");
//            }else{
//                Housemaster result1=dormitoryService.checkhousemasterbyId(id);
//                if(result1!=null){
//                    System.out.println("账号存在");
//                    request.getRequestDispatcher("/administorinserthousemaster.jsp").forward(request,response);
//                }else {
//                    try {
//                        dormitoryService.administorinserthms(housemaster);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                    response.sendRedirect(request.getContextPath()+"/queryallhousermaster");
//                }
//
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
