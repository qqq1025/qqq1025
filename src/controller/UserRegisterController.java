package controller;

import entity.Keyword;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserRegisterController", value = "/register")
public class UserRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        String password = request.getParameter("password");
        String key = request.getParameter("key");
        UserService userService=new UserServiceImpl();
//        int result = userService.register(id,password);
        try {
            Keyword result1=userService.querykeyword(key);
            if(result1!=null){
                int result = userService.register(id,password);
                if (result>0){
                    System.out.println("注册成功");
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                }
//            int result = userService.register(id,password);
//            System.out.println("注册成功");
//            response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
            else {
                System.out.println("注册失败");
                response.sendRedirect(request.getContextPath()+"/register.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        if(key.equals("12344")){
//            int result = userService.register(id,password);
//            if (result>0){
//                System.out.println("注册成功");
//                response.sendRedirect(request.getContextPath()+"/login.jsp");
//            }
////            int result = userService.register(id,password);
////            System.out.println("注册成功");
////            response.sendRedirect(request.getContextPath()+"/login.jsp");
//        }
//        else {
//            System.out.println("注册失败");
//            response.sendRedirect(request.getContextPath()+"/register.jsp");
//        }
    }
}
