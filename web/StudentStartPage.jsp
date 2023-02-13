<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/24
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生端首页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        div {
            box-sizing: border-box;
        }

        a {
            text-decoration: none;
            color: red;
        }

        ul {
            list-style: none;
        }

        body {
            width: 1000px;
            height:400px;
            background: url(./images/123.jpg) no-repeat;
            background-size: 100% 120%;
            margin: 100px auto;

        }

        section {
            width: 100%;
            height: 80px;
            background-color: rgba(107, 97, 97, 0.488);
            border-radius: 0 25px 0 0;
            text-align: center;
        }

        section h2 {
            padding-top: 20px;
        }

        header {
            width: 100%;
            height: 400px;
            background-color: rgba(204, 204, 204, 0.549);
        }

        header .right {
            width: 120px;
            height: 100%;
            background-color: rgba(204, 204, 204, 0.436);
        }

        header .right ul li {
            width: 100%;
            height: 60px;
            text-align: center;
            background-color: rgb(191, 229, 229);
            border-radius: 10px;
        }

        header .right ul li:nth-child(n+2) {
            margin-top: 20px;
        }

        li a {
            line-height: 60px;
            color: black;
        }
        header {
            display: flex;
        }
        .left {
            width: 880px;
            justify-content: space-around;
            background-color: rgba(118, 187, 155, 0.378);
            border-radius: 10px;
        }
        .container {
            width: 100%;
            height: 100%;
            overflow: auto;
        }
    </style>
</head>
<body>
<%
    String id=request.getParameter("id");
%>
<section>
    <h2>欢迎登录宿舍管理系统学生端</h2>
</section>
<header>
    <div class="right">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/stratPage.jsp?id=${id}">首页</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/queryallstudent?id=<%=id%>">学生查询</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/stratPage.jsp?id=${id}">返回</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <div class="container">
            <table align="center" border="1" cellspacing="0" cellpadding="2px" width="100%" heigth="100%">
                <thead>
                <tr>
                    <th>账号</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>专业</th>
                    <th>栋</th>
                    <th>层</th>
                    <th>寝室号</th>
                    <th>修改密码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="Student" items="${allstudent}">
                    <tr>
                        <td>${Student.id}</td>
                        <td>${Student.name}</td>
                        <td>${Student.age}</td>
                        <td>${Student.gender}</td>
                        <td>${Student.major}</td>
                        <td>${Student.apartment}</td>
                        <td>${Student.floor}</td>
                        <td>${Student.number}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/StudentModifyPassword.jsp?id=${Student.id}">修改密码</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</header>
</body>
</html>
