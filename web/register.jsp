<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/23
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册页面</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        div {
            box-sizing: border-box;
        }

        input {
            outline: none;
        }

        li {
            list-style: none;
        }

        a {
            text-decoration: none;
        }

        body {
            width: 100%;
            height: 100%;
            background-color: aliceblue;
            background: url(./images/darknight.jpg) no-repeat 0 0;
            background-size: 100% 100%;
            overflow: hidden;
        }

        .container {
            display: flex;
            width: 800px;
            height: 500px;
            margin: 150px auto;
            background-color: rgba(24, 43, 43, 0.203);
            border-radius: 30px;
            overflow: hidden;
            box-shadow: -1px 1px 3px #ccc;
        }

        .container .left {
            flex: 0.5;
            background-color: antiquewhite;
            /* background: url(./images/白山.jpg) no-repeat;
            background-size: 100% 100%; */
            overflow: hidden;
        }

        .container .left img {
            width: 100%;
            height: 100%;
            transition: all 1s ease;
            animation: ma 20s linear infinite;
        }

        @keyframes ma {
            0% {
                transform-origin: center;
                transform: scale(1);
            }

            20% {
                transform-origin: left top;
                transform: scale(1.5);
            }

            40% {
                transform-origin: right top;
                transform: scale(1.5);
            }

            60% {
                transform-origin: right bottom;
                transform: scale(1.5);
            }

            80% {
                transform-origin: left bottom;
                transform: scale(1.5);
            }

            100% {
                transform-origin: center;
                transform: scale(1);
            }
        }


        .container .right {
            flex: 0.5;
            /* display: flex;
            flex-direction: column;
            justify-content: center; */
            text-align: center;
        }

        .container .right .zh {
            width: 80%;
            height: 50px;
            /* background-color: beige; */
            margin-left: 10%;
        }

        .container .right .mm {
            margin-top: 20px;
            width: 80%;
            height: 50px;
            /* background-color: beige; */
            margin-left: 10%;
        }

        .container .right .key {
            margin-top: 20px;
            width: 80%;
            height: 50px;
            /* background-color: beige; */
            margin-left: 17%;
        }

        .container .right h1 {
            margin-top: 80px;
            margin-bottom: 30px;
            font-weight: 700;
            color: #fff;
            font-size: 48px;
            margin-left: 40px;
        }

        .container .right .zh span {
            vertical-align: middle;
            font-size: 20px;
            font-weight: 700;
            margin-left: -35px;
            margin-right: 10px;
            font-family: "楷书";
        }

        .container .right .mm span {
            vertical-align: middle;
            font-size: 20px;
            font-weight: 700;
            margin-left: -45px;
            margin-right: 10px;
            font-family: "楷书";
        }

        .container .right .key span {
            vertical-align: middle;
            font-size: 20px;
            font-weight: 700;
            margin-left: -45px;
            margin-right: 10px;
            font-family: "楷书";
        }

        .container .right .mm input {
            width: 50%;
            height: 60%;
            background-color: transparent;
            border-radius: 20px;
            text-indent: 1em;
            font-size: 20px;
            color: #fff;
        }

        .container .right .zh input {
            width: 50%;
            height: 60%;
            background-color: transparent;
            border-radius: 20px;
            text-indent: 1em;
            font-size: 20px;
            color: #fff;
        }

        .container .right .key input {
            width: 50%;
            height: 60%;
            background-color: transparent;
            border-radius: 20px;
            text-indent: 1em;
            font-size: 20px;
            color: #fff;
        }

        .container .right .register a {
            color: rgb(12, 127, 153);
        }

        .container .right .login {
            width: 100%;
            height: 50px;
            margin-top: 30px;

        }

        .container .right .login input {
            width: 100px;
            height: 40px;
            color: rgb(116, 134, 209);
            background-color: aquamarine;
            font-size: 20px;
            font-weight: 600;
            border-radius: 20px;
        }

        .container .right .login span {
            display: inline-block;
            width: 100px;
            height: 38px;
            color: rgb(116, 134, 209);
            background-color: aquamarine;
            font-size: 20px;
            font-weight: 600;
            border-radius: 20px;
            border: 1px solid #000;
            line-height: 40px;
        }

        .container .right .login input:first-child {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post" name="post">
    <div class="container">
        <div class="left">
            <img src="./images/darknight.jpg" alt="">
        </div>
        <div class="right">
            <h1>REGISTER</h1>
            <div class="zh">
                <span>account</span>
                <input type="text" name="id" maxlength="10" required>
            </div>
            <div class="mm">
                <span>password</span>
                <input type="password" name="password" maxlength="10" required>
            </div>
            <div class="key">
                <span>Key</span>
                <input type="password" name="key" required>
            </div>
            <div class="login">
                <input type="submit" value="提交">
                <span>
                        <a href="${pageContext.request.contextPath}/login.jsp">返回</a>
                </span>
            </div>
        </div>
    </div>
</form>
<%--<div class="register">--%>
<%--    <form action="${pageContext.request.contextPath}/register" method="post" name="post">--%>
<%--        账号：<input type="text" name="id" required/><br/>--%>
<%--        密码：<input type="password" name="password" required/><br/>--%>
<%--&lt;%&ndash;        确认密码：<input type="password" name="password2" required/><br/>&ndash;%&gt;--%>
<%--        输入密钥：<input type="text" name="key" required/><br/>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>
<%--</div>--%>
</body>
</html>
