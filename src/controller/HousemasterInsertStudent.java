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

@WebServlet(name = "HousemasterInsertStudent", value = "/HousemasterInsertStudent")
public class HousemasterInsertStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String mfloor=request.getParameter("mfloor");
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
        request.setAttribute("mfloor",mfloor);
        try {
            Student result=dormitoryService.queryinsertstuexisit(id);
            Housemaster result1=dormitoryService.queryinsertapartmentexists(apartment);
            if (result!=null){
                System.out.println("账号存在");
                request.getRequestDispatcher("/housemasterinsertstudent.jsp?mfloor="+mfloor).forward(request,response);
            }else {
                if(result1!=null){
                    Integer count=dormitoryService.queryStuInSameDormitoryCount(apartment,floor,number);
                    if (count<6){
                        try {
                            dormitoryService.housemasterinsertstu(student);
                            System.out.println("插入数据成功");
                            response.sendRedirect(request.getContextPath()+"/querystudent2?mfloor="+mfloor);

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }else {
                        System.out.println("寝室满了，不用插了");
                        request.getRequestDispatcher("/housemasterinsertstudent.jsp?mfloor="+mfloor).forward(request,response);
                    }
                }else {
                    request.setAttribute("mfloor",mfloor);
                    request.getRequestDispatcher("/housemasterinsertstufailpage.jsp").forward(request,response);
                }
//                Integer count=dormitoryService.queryStuInSameDormitoryCount(apartment,floor,number);
//                if (count<=6){
//                    try {
//                        dormitoryService.housemasterinsertstu(student);
//                        System.out.println("插入数据成功");
//                        response.sendRedirect(request.getContextPath()+"/querystudent2?mfloor="+mfloor);
//
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                }else {
//                    System.out.println("寝室满了，不用插了");
//                    request.getRequestDispatcher("/housemasterinsertstudent.jsp?mfloor="+mfloor).forward(request,response);
//                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
