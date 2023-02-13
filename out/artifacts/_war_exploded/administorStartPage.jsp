<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/29
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理端首页面</title>
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
            height: 50px;
            text-align: center;
            background-color: rgb(191, 229, 229);
            border-radius: 10px;
        }

        header .right ul li:nth-child(n+2) {
            margin-top: 10px;
        }

        li a {
            line-height: 50px;
            color: black;
        }

        header {
            display: flex;
        }

        .left {
            /* display: flex; */
            width: 1280px;
            justify-content: space-around;
            background-color: rgba(118, 187, 155, 0.378);
            border-radius: 10px;
        }

        .left .container .hd {
            position: relative;
            width: 100%;
            height: 80px;
            background-color: rgba(0, 0, 0, 0.086);
        }

        .left .container .hd .hd-left {
            position: absolute;
            bottom: 0;
            width: 100px;
            height: 80%;
            line-height: 70px;
            text-align: center;
            border-radius: 5px;
            font-size: 25px;
            font-weight: 700;
            font-family: '隶书';
        }

        .left .container .hd h2 {
            position: absolute;
            bottom: 20px;
            left: 600px;
            font-size: 40px;
            background: -webkit-linear-gradient(left,#fff, red, #fff,red);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .left .container .hd .hd-right {
            position: absolute;
            bottom: 0;
            right: 0;
            width: 100px;
            height: 80%;
            line-height: 70px;
            text-align: center;
            border-radius: 5px;
            font-size: 25px;
            font-weight: 700;
            font-family: '隶书';
        }

        .left .container .hd .hd-right a {
            font-size: 25px;
            font-weight: 700;
            font-family: '隶书';
        }

        .left .container .bd {
            position: relative;
            width: 100%;
            height: 380px;
        }

        .left .container .bd .photo {
            float: left;
            width: 200px;
            height: 200px;
            background: url(./images/127.jpg) no-repeat;
            background-size: 200px 200px;
        }

        .left .container .bd .photo img {
            width: 200px;
            height: 200px;
            border-radius: 10px 0 0 0;
        }

        .left .container .bd .text {
            font-size: 23px;
            color: #000;
            font-family: '微软雅黑';
        }

        .left .container .bd .text::first-letter {
            font-size: 3em;
            vertical-align: middle;
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

        /* .container {
            position: relative;
            width: 100%;
            height: 100%;
            overflow: hidden;
        } */
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
            <li>
                <a href="${pageContext.request.contextPath}/querystudentadministor">学生管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/queryAlladministor">管理操作</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/queryallhousermaster">宿管管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/AdministorQueryAllBuilding">楼栋管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/administorUpdateKeyword.jsp">密钥修改</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/administorStartPage.jsp">返回</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/login.jsp">返回登陆</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <!-- <form action="#" method="post">
            <div class="title">
                <div class="search">
                    <input type="text" placeholder="请输入你要查询的账号/寝室/姓名">
                </div>
                <div class="search-btn">
                    <input type="submit" value="查询">
                </div>
            </div>
        </form> -->
        <div class="container">

            <!-- <table align="center" border="1" cellspacing="0" cellpadding="2px" width="100%" heigth="100%">
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
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
<%--                        <c:forEach var="Student" items="${allstudent}">--%>
                            <tr>
                                <td>123</td>
                                <td>123</td>
                                <td>123</td>
                                <td>123</td>
                                <td>123</td>
                                <td>123</td>
                                <td>123</td>
                                <td>123</td>
                                <td class="modify">
                                    <a href="#">修改</a>
                                    &nbsp;| &nbsp;
                                    <a href="#">删除</a>
                                </td>
                            </tr>
<%--                        </c:forEach>--%>
                    </tbody>
                </table> -->
            <div class="hd">
                <div class="hd-left">
                    学校介绍
                </div>
                <h2>明德敬业</h2>
                <div class="hd-right">
                    <a href="https://www.jxstnu.edu.cn/">了解更多</a>
                </div>
            </div>
            <div class="bd">
                <div class="photo">
                </div>
                <div class="text">
                    江西科技师范大学（Jiangxi Science and Technology Normal
                    University），位于江西省南昌市，是公办多科性本科院校，入选教育部"卓越教师培养计划"，为全国重点建设职业教育师资培训基地、江西省一流学科建设高校、江西省职教师资培养培训中心、江西省教师资格面试直属考点管理办公室，是江西省政府奖学金和孔子学院奖学金来华留学生接收院校。
                    学校以原江西科技师范学院为主体，南昌高等专科学校并入组成。南昌高等专科学校办学起始于1952年；江西科技师范学院的前身为1977年创建的江西师范学院南昌分院，1984年更名为南昌师范专科学校，1987年升格为南昌职业技术师范学院，2002年更名为江西科技师范学院。2004年南昌高等专科学校并入江西科技师范学院，2012年学校更名为江西科技师范大学。
                    截至2022年6月，学校主要有枫林校区和红角洲校区，占地面积2159.18亩，校舍建筑面积70.75万平方米，教学科研仪器设备总值32262.52万元，纸质图书274.6万册；建有校内教学实验及实训场所336个，校外实习实训基地469个；拥有硕士学位授权一级学科15个，硕士专业学位授权类别13个；有教职工1736人，在校生规模2.8万余人，其中本科生26156人、研究生2118人
                </div>
            </div>
        </div>
    </div>
</header>
</body>

</html>