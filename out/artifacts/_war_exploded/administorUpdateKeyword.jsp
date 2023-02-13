<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/12/12
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改页面</title>
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

        /* .title {
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
        } */

        /* .container {
            position: relative;
            width: 100%;
            height: 100%;
            overflow: hidden;
        } */
        .left .update {
            margin-top: 40px;
            overflow: hidden;
        }

        .left .post {
            margin-left: 300px;
            margin-bottom: 100px;
        }

        .left .post input {
            overflow: hidden;
            background-color: aqua;
            width: 80px;
            height: 40px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: 700;
            color: #000;
            cursor: pointer;
        }

        .left .update input {
            overflow: hidden;
            background-color: transparent;
            border: 2px solid #000;
            width: 200px;
            height: 20px;
            border-radius: 5px;
        }
    </style>
</head>

<body>
<section>
    <h2>请按照文字提示填写修改信息</h2>
</section>
<header>
    <div class="right">
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/administorStartPage.jsp">首页</a>
            </li>
<%--            <li>--%>
<%--                <a href="${pageContext.request.contextPath}/querystudent2?mfloor=${mfloor}">学生查询</a>--%>
<%--            </li>--%>
            <li>
                <a href="${pageContext.request.contextPath}/administorStartPage.jsp">返回</a>
            </li>
        </ul>
    </div>
    <div class="left">
        <form action="${pageContext.request.contextPath}/AdministonUpdateKeword" method="post">

            <div class="update">
                <label>旧密钥</label>
                <input type="password" name="key1" required="required">
            </div>
            <div class="update">
                <label>新密钥</label>
                <input type="password" name="key2" required="required">
            </div>
            <div class="update">
                <label>确认新密钥</label>
                <input type="password" name="key3" required="required">
            </div>
            <div class="post">
                <input type="submit" value="提交">
            </div>
        </form>
    </div>
</header>
<script>
    function GetQueryString(name) {
        var reg = new RegExp( "(^|&)" + name + "=([^&]*)(&|$)" , "i" );
        var r = window.location.search.substr(1).match(reg);
        if (r!= null ) return (r[2]); return null ;
    }

    // 获取到url后面拼接的参数并复制给了id
    var b = GetQueryString("id")
    document.getElementById('id').value=b;
</script>
</body>

</html>
