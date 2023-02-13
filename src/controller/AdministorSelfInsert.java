package controller;

import entity.Administor;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorSelfInsert", value = "/AdministorSelfInsert")
public class AdministorSelfInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String phnum1=request.getParameter("phnum1");
        Administor administor=new Administor(id,password,name,gender,age,phnum1);
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        String key=request.getParameter("key");
        if(!key.equals("12344")){
            System.out.println("插入失败，密钥错误");
            request.getRequestDispatcher("/administorselfinsert.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/administorselfinsert.jsp");
        }else {
            try {
                Administor result=dormitoryService.queryadministorById(id);
                if (result==null){
                    System.out.println("账号不存在，可以注册");
                    try {
                        dormitoryService.administorselfinsert(administor);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    response.sendRedirect(request.getContextPath()+"/queryAlladministor");
                }else {
                    System.out.println("账号存在，重新输入");
                    request.getRequestDispatcher("/administorselfinsert.jsp").forward(request,response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
