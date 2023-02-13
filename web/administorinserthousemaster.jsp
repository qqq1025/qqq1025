<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/12/3
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增宿管页面</title>
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
            position: relative;
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

        .left .submit {
            position: absolute;
            bottom: 50px;
            left: 540px;
        }

        .left .submit input {
            width: 60px;
            height: 35px;
            background-color: #eee;
            font-size: 16px;
            border-radius: 10px;
        }

        .left table td input {
            width: 200px;
            height: 25px;
            border-radius: 20px;
            text-indent: 1em;
            color: #000;
            border: 1px solid #000;
            background-color: transparent;
        }

        .left table .spl input {
            width: 100px;
            height: 20px;
        }

        .left table .spl input:nth-child(1) {
            font-size: 10px;
            color: #000;
        }

        .left table td select {
            background-color: transparent;
        }
    </style>
</head>

<body>
<section>
    <h2>请按照文字提示填写新增人员信息</h2>
</section>
<header>
    <div class="right">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/administorStartPage.jsp">首页</a>
            </li>
            <!-- <li>
                <a href="#">学生查询</a>
            </li> -->
            <li>
                <a href="${pageContext.request.contextPath}/queryallhousermaster">返回</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <form action="${pageContext.request.contextPath}/AdministorInsertHousemaster" method="post">
            <table align="center" border="0" cellpadding="0" cellspacing="40">
                <tr>
                    <td>
                        账号
                    </td>
                    <td>
                        <input type="text" name="id" required placeholder="请输入账号">
                    </td>
                </tr>
                <tr>
                    <td>
                        密码
                    </td>
                    <td>
                        <input type="password" name="password" required placeholder="请输入密码">
                    </td>
                </tr>
                <tr>
                    <td>
                        请选择管理栋楼
                    </td>
                    <td>
                        <select name="mfloor">
                            <option selected="">--请选择管理的栋号</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                        </select>
                        <!-- <select name="apartment">
                            <option selected="">--请选择你的栋号</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                        </select>
                        <select name="floor">
                            <option selected="">--请选择你的楼层</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                        <input type="text" name="number" placeholder="请输入你的寝室号"> -->
                    </td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td class="spl">
                        <input type="text" name="name" required="" placeholder="请输入你的姓名">
                        <input type="radio" name="gender" value="男" checked=""> 男
                        <input type="radio" name="gender" value="女"> 女
                    </td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td>
                        <input type="text" name="age" placeholder="请输入你的年龄">
                    </td>
                </tr>
                <tr>
                    <td>手机号</td>
                    <td>
                        <input type="text" name="phnum" required>
                    </td>
                </tr>
                <div class="submit">
                    <input type="submit" value="提交">
                </div>
            </table>
        </form>
    </div>
</header>
</body>
</html>
