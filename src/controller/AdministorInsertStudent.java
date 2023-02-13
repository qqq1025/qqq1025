package controller;

import entity.Housemaster;
import entity.Student;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministorInsertStudent", value = "/AdministorInsertStudent")
public class AdministorInsertStudent extends HttpServlet {
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
        Integer apartment= Integer.valueOf(request.getParameter("apartment"));
        Integer floor= Integer.valueOf(request.getParameter("floor"));
        String number=request.getParameter("number");
        Integer age= Integer.valueOf(request.getParameter("age"));
        String major=request.getParameter("major");
        Student student=new Student(id,password,name,gender,age,major,apartment,floor,number);
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            Student result=dormitoryService.queryinsertstuexisit(id);
            if(result==null){
                System.out.println("学生账号不存在，可以插入数据");
                Integer count=dormitoryService.queryStuInSameDormitoryCount(apartment,floor,number);
                Housemaster result1=dormitoryService.queryinsertapartmentexists(apartment);
                if(result1!=null){
                    if(count<6){
                        try {
                            dormitoryService.administorinsertstu(student);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        response.sendRedirect(request.getContextPath()+"/querystudentadministor");
                    }else {
                        System.out.println("寝室已满 ，插入失败");
                        request.getRequestDispatcher("/administorinsertstudent.jsp").forward(request,response);
                    }
                }else {
                    System.out.println("楼栋未分配管理，操作失败");
                    response.sendRedirect(request.getContextPath()+"/administorinsertstufailpage.jsp");
                }
//                if(count<6){
//                    try {
//                        dormitoryService.administorinsertstu(student);
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                    response.sendRedirect(request.getContextPath()+"/querystudentadministor");
//                }else {
//                    System.out.println("寝室已满 ，插入失败");
//                    request.getRequestDispatcher("/administorinsertstudent.jsp").forward(request,response);
//                }
            }else {
                System.out.println("学生账号存在，请检查确认");
                request.getRequestDispatcher("/administorinsertstudent.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
