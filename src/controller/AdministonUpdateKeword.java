package controller;

import entity.Keyword;
import service.DormitoryService;
import service.impl.DormitoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdministonUpdateKeword", value = "/AdministonUpdateKeword")
public class AdministonUpdateKeword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String key1=request.getParameter("key1");
        String key2=request.getParameter("key2");
        String key3=request.getParameter("key3");
        DormitoryService dormitoryService=new DormitoryServiceImpl();
        try {
            Keyword result=dormitoryService.querykeyword(key1);
            if(result!=null){
                if(key2.equals(key3)){
                    Keyword keyword=new Keyword(key1,key2);
                    dormitoryService.administorupdatekeyword(keyword);
                    response.sendRedirect(request.getContextPath()+"/administorupdatekeywordsuccessfulpage.jsp");
                }else {
                    System.out.println("两次输入结果不同 请重新操作");
                    response.sendRedirect(request.getContextPath()+"/administorupdatekeywordfalilpage1.jsp");
                }
            }else {
                System.out.println("旧密钥错误");
                response.sendRedirect(request.getContextPath()+"/administorupdatekeywordfailpage2.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
