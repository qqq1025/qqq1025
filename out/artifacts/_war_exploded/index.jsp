<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/21
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <style>
      * {
        margin: 0;
        padding: 0;
      }
      a {
        text-decoration: none;
      }
      ul {
        list-style: none;
      }
      body{
        display: flex;
        background: url("./images/123.jpg") no-repeat;
        background-size: 100% 100%;
        width: 100%;
        height: 100%;
        justify-content: center;
        align-items: center;
      }
      h1 {
        font-size: 15px;
        width: 80px;
        height: 60px;
        text-align: center;
        line-height: 60px;
        color: chartreuse;
        background-color: rgba(0,0,0,.5);
      }
    </style>
  </head>
  <body>
  <h1><a href="${pageContext.request.contextPath}/login.jsp">登录页面</a> </h1>
  </body>
</html>
