package controller;

import entity.Administor_login;
import entity.Housemaster;
import entity.Housemaster_login;
import entity.Student_login;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserLoginController", value = "/login")
public class UserLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String idn=request.getParameter("identify");
        UserService userService= new UserServiceImpl();
        if(idn.equals("student")){
            System.out.println("进入学生登录端口");
            //UserService userService= new UserServiceImpl();
            Student_login student_login=null;
            try {
                student_login=userService.login_stu(id,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(student_login!=null){
                request.setAttribute("id",id);
                HttpSession session=request.getSession();
                session.setAttribute("student_login",student_login);
                request.getRequestDispatcher("/stratPage.jsp").forward(request,response);
//                response.sendRedirect(request.getContextPath()+"/stratPage.jsp");
            }else {
                System.out.println("账号或者密码错误");
                response.sendRedirect(request
                .getContextPath()+"/login.jsp");
            }
        }else if(idn.equals("housermaster")){
            System.out.println("宿管端");
            Housemaster_login housemaster_login=null;
            try {
                housemaster_login=userService.login_hmt(id,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(housemaster_login!=null){
                Integer mfloor= null;
                try {
                    mfloor = userService.queryhousemaster(id);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                HttpSession session=request.getSession();
                session.setAttribute("housemaster_login",housemaster_login);
                response.sendRedirect(request.getContextPath()+"/querystudent2?mfloor="+mfloor);
            }else {
                System.out.println("账号或者密码错误");
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }

        }else if(idn.equals("administor")){
            System.out.println("管理端");
            Administor_login administor_login=null;
            try {
                administor_login=userService.login_adm(id,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(administor_login!=null){
                HttpSession session=request.getSession();
                session.setAttribute("administor_login",administor_login);
                response.sendRedirect(request.getContextPath()+"/administorStartPage.jsp");
            }else {
                System.out.println("账号或者密码错误");
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }else {
            System.out.println("由于单选框设置了默认选中的值，所以你看不到这句话，所以加油吧少年！");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}
