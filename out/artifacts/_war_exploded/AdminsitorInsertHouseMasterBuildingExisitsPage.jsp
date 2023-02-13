<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/12/11
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员插入宿管失败页面</title>
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
            color: black;
            font-size: 20px;
            font-weight: 500;
        }

        ul {
            list-style: none;
        }

        input {
            text-decoration: none;
            list-style: none;
            border-color: transparent;
            outline: none;
        }

        body {
            width: 1400px;
            background: url(./images/123.jpg) no-repeat;
            background: size 100% calc(100%+200px);
            margin: 100px auto;
            overflow: hidden;
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
            font-size: 32px;
            background: -webkit-linear-gradient(270deg, rgb(73, 38, 125), rgb(84, 237, 13));
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        header {
            width: 100%;
            height: 500px;
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
            width: 1280px;
            justify-content: space-around;
            background-color: rgba(118, 187, 155, 0.378);
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            overflow: hidden;
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
        }

        .left .title .search-btn {
            position: absolute;
            top: 5px;
            left: 725px;
            width: 80px;
            height: 30px;
            background-color: red;
            border-radius: 20px;
            overflow: hidden;
        }

        .left .title .search-btn input {
            width: 100%;
            height: 100%;
            font-size: 16px;
            font-weight: 600;
        }

        .left .container tbody .modify {
            text-align: center;
            color: #000;
        }

        .container {
            position: relative;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        .table {
            margin-top: 4px;
        }

        .left .delete input {
            width: 100px;
            height: 40px;
            margin-bottom: 350px;
            background-color: aqua;
            border-radius: 10px;
            cursor: pointer;
        }

        .qqq {
            height: 100px;
            text-align: center;
            margin-top: 20px;
        }

        .delete {
            margin-top: 50px;
        }

        .left .container .qqq .delete .key {
            width: 120px;
            height: 25px;
            font-size: 20px;
            text-indent: .3em;
            border: 2px solid black;
            background-color: transparent;
            color: #000;
        }

        .left h2 {
            padding-top: 100px;
            padding-right: 100px;
        }

        .left .back {
            padding-bottom: 300px;
            padding-right: 50px;
        }
        .left .back a {
            border: 2px solid #000;
            border-radius: 10px;
            background-color: aliceblue;
            font-size: 16px;
        }
    </style>
</head>

<body>
<section>
    <h2>请确认楼栋使用状况</h2>
</section>
<header>
    <div class="right">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/administorStartPage.jsp">首页</a>
            </li>
            <%--            <li>--%>
            <%--                <a href="${pageContext.request.contextPath}">学生查询</a>--%>
            <%--            </li>--%>
            <li>
                <a href="${pageContext.request.contextPath}/queryallhousermaster">返回</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <h2>插入失败，请确认楼栋是否分配使用</h2>
        <div class="back">
            <a href="${pageContext.request.contextPath}/AdministorQueryAllBuilding">前往楼栋管理</a>
        </div>
    </div>
</header>
</body>
</html>
