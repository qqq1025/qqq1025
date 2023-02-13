package controller;

import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentModifyPassword", value = "/StudentModifyPassword")
public class StudentModifyPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String pwd=request.getParameter("password");
        String pwd1=request.getParameter("password1");
        String pwd2=request.getParameter("password2");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        request.setAttribute("id",id);
        try {
            String result=dormitoryService.queryStuPassword(id);
            if(result.equals(pwd)){
                if(pwd1.equals(pwd2)){
                    Student student=new Student(id,pwd1);
                    dormitoryService.studentmodifypassword(student);
//                    request.setAttribute("id",id);
                    response.sendRedirect(request.getContextPath()+"/queryallstudent?id="+id);
                }else {
                    System.out.println("两次输入密码不一致，请重新进行操作");
                    request.getRequestDispatcher("/StudentModifyPasswordfailpage1.jsp").forward(request,response);
                }
            }
            else{
                System.out.println("旧密码不一致，请检查后重新输入");
                request.getRequestDispatcher("/StudentModifyPasswordfailPage2.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
