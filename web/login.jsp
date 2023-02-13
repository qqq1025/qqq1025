<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/23
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>登录页面</title>
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
            background: url(images/whitemountain.jpg) no-repeat 0 0;
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
            /* background: url(./images/whitemountain.jpg) no-repeat;
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
            margin-top: 40px;
            width: 80%;
            height: 50px;
            /* background-color: beige; */
            margin-left: 10%;
        }
        .container .right .choose {
            color: #ffffff;
        }

        .container .right h1 {
            margin-top: 80px;
            margin-bottom: 30px;
            font-weight: 700;
            color: #fff;
            font-size: 48px;
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

        .container .right .register {
            width: 140px;
            height: 30px;
            background-color: #fff;
            text-align: center;
            border-radius: 10px;
            line-height: 30px;
            margin-left: 125px;
            margin-top: 20px;
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

        .container .right .login input:first-child {
            margin-right: 10px;
        }

        .container .right .login input:last-child {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="container">
        <div class="left">
            <img src="images/whitemountain.jpg" alt="">
        </div>
        <div class="right">
            <h1>LOGIN</h1>
            <div class="zh">
                <span>account</span>
                <input type="text" name="id" maxlength="10" placeholder="请输入账号" required>
            </div>
            <div class="mm">
                <span>password</span>
                <input type="password" name="password" maxlength="10" placeholder="请输入密码" required>
            </div>
            <div class="choose">
                <input type="radio" name="identify" value="student" checked="checked">学生
                <input type="radio" name="identify" value="housermaster">宿管
                <input type="radio" name="identify" value="administor">管理员
            </div>
            <div class="register">
                <span><a href="${pageContext.request.contextPath}/register.jsp">管理员账号注册</a></span>
            </div>
            <div class="login">
                <input type="submit" value="登录">
                <input type="reset" value="取消">
            </div>
        </div>
    </div>
</form>
</body>
</html>
