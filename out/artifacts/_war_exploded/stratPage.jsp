<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/26
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>首页</title>
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
            width: 1000px;
            background: url(./images/123.jpg) no-repeat;
            background-size: 100% 1000px;
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
            font-size: 32px;
            background: -webkit-linear-gradient(270deg, rgb(73, 38, 125), rgb(84, 237, 13));
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
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
            overflow: hidden;
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
        header .right ul li:last-child {
            margin-top: 100px;
        }

        li a {
            line-height: 60px;
            color: black;
        }

        header {
            display: flex;
        }

        .left {
            display: flex;
            width: 1280px;
            justify-content: space-around;
            align-items: center;
            background-color: rgba(118, 187, 155, 0.378);
            border-radius: 10px;
            text-align: center;
        }
        .left .gonggao {
            width: 85%;
            height: 80%;
            background-color: rgba(27, 128, 132, 0.521);
            border-radius: 30px;
            overflow: auto;
        }

        .left .gonggao .line {
            width: 100%;
            height: 20%;
            border-radius: 0 0 30px 30px;
            text-align: center;
            line-height: 75px;
            background-color: aqua;
        }

        .left .gonggao .line h1 {
            font-size: 32px;
            background: -webkit-linear-gradient(270deg, rgb(228, 28, 35), rgb(231, 227, 7));
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            text-shadow: 2px -3px 1px rgba(164, 107, 220, 0.352);
        }

        .left .text {
            position: relative;
            width: 95%;
            height: 75%;
            margin: 10px auto;
            background-color: #ccc;
            border-radius: 20px;
            overflow: auto;
        }

        .left .text ul li {
            width: 450px;
            text-indent: 2em;
            text-align: left;
            height: 36px;
        }

        .left .text ul li a {
            font-size: 16px;
            color: blue;
            text-decoration: underline;
        }

        .text .text-right {
            position: absolute;
            top: 14px;
            right: 10px;
            width: 250px;
            height: 90%;
            overflow: hidden;
            /* background:url(./images/123.jpg);
            background-size: 100% 100%; */
        }

        .text .text-right img {
            width: 100%;
            height: 100%;
            transition: all 3s ease;
        }

        .text .text-right img:hover {
            transform: scale(1.5) rotate(360deg);
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
                <a href="${pageContext.request.contextPath}/stratPage.jsp?id=<%=id%>">首页</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/queryallstudent?id=<%=id%>">个人查询</a>
            </li>
<%--            <li>--%>
<%--                <a href="${pageContext.request.contextPath}/stratPage.jsp">返回</a>--%>
<%--            </li>--%>
            <li>
                <a href="${pageContext.request.contextPath}/login.jsp">返回登录</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <div class="gonggao">
            <div class="line">
                <h1>公 告</h1>
            </div>
            <div class="text">
                <div class="text-left">
                    <ul>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                        <li><a href="#">软件学院正式改名元宇宙产业学院</a>
                        </li>
                    </ul>
                </div>
                <div class="text-right">
                    <img src="./images/125.jpg" alt="哈哈哈">
                </div>
            </div>
        </div>
    </div>
</header>
</body>
</html>
