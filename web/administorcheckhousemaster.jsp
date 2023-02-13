<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/12/1
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理端--宿管查询</title>
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
            background: url(./images/123.jpg) no-repeat;
            background-size: 100% 120%;
            margin: 100px auto;

        }
        input {
            outline: none;
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
            overflow: hidden;
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
            overflow:scroll;
        }
        .title {
            position: relative;
            top: 0;
            left: 0;
            overflow: hidden;
            height: 40px
        }

        .left .title .search {
            position: absolute;
            top: 5px;
            left: 420px;
            width: 300px;
            height: 30px;
            background-color: red;
            border-radius: 30px;
            overflow: hidden;
        }

        .left .title .search input {
            width: 100%;
            height: 100%;
            text-align: center;
            font-size: 14px;
            font-weight: 700;
            color: #000;
            outline: none;
            border: 1px solid #fff;
        }

        .left .title .search-btn {
            position: absolute;
            top: 5px;
            left: 721px;
            width: 75px;
            height: 30px;
            background-color:transparent;
            border-radius: 20px;
            overflow: hidden;
        }
        .left .top {
            position: relative;
        }

        .left .top .insert {
            position: absolute;
            top: 5px;
            right: 2px;
            width: 77px;
            height: 30px;
            background-color: #efefef;
            border: 2px solid #000;
            font-size: 16px;
            text-align: center;
            border-radius: 20px;
        }

        .left .top .insert a {
            position: absolute;
            top: 3px;
            left: 21px;
            color: #000;
            font-weight: 700;
        }
        .left .title .search-btn input {
            width: 100%;
            height: 100%;
            font-size: 16px;
            font-weight: 600;
            border-radius: 20px;
        }

        .left .container tbody .modify {
            text-align: center;
            color: #000;
        }
    </style>
</head>
<body>
<section>
    <h2>欢迎登录宿舍管理系统管理端</h2>
</section>
<header>
    <div class="right">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/administorStartPage.jsp">首页</a>
            </li>
            <%--            <li>--%>
            <%--                <a href="${pageContext.request.contextPath}administorchakeStudent.jsp">学生查询</a>--%>
            <%--            </li>--%>
            <li>
                <a href="${pageContext.request.contextPath}/queryallhousermaster">返回</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <div class="top">
            <form action="${pageContext.request.contextPath}/AdministorSearchSomeHousemaster" method="post">
                <div class="title">
                    <div class="search">
                        <input type="text" placeholder="请输入你要查询的宿管的 id/姓名/电话号码" name="search-elm">
                    </div>
                    <div class="search-btn">
                        <input type="submit" value="查询">
                    </div>
                </div>
            </form>
            <div class="insert">
                <a href="${pageContext.request.contextPath}/administorinserthousemaster.jsp">新增</a>
            </div>
        </div>

        <div class="container">
            <table align="center" border="1" cellspacing="0" cellpadding="2px" width="100%" heigth="100%">
                <thead>
                <tr>
                    <th>账号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>电话号码</th>
                    <th>管理楼栋</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="Housemaster" items="${allhousemaster}">
                    <td>${Housemaster.id}</td>
                    <td>${Housemaster.password}</td>
                    <td>${Housemaster.name}</td>
                    <td>${Housemaster.gender}</td>
                    <td>${Housemaster.age}</td>
                    <td>${Housemaster.phnum}</td>
                    <td>${Housemaster.mfloor}</td>
                    <td class="modify">
                        <a href="${pageContext.request.contextPath}/update3.jsp?id=${Housemaster.id}">修改</a>
                        &nbsp;| &nbsp;
                        <a href="${pageContext.request.contextPath}/querydeletehousemaster?id=${Housemaster.id}">删除</a>
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
