<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 阿权
  Date: 2022/11/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生首页展示</title>
</head>
<body>
<div class="container">
    <table collapse="1" spacing="1">
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
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
