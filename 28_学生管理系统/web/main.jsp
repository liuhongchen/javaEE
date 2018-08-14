<%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2018/8/14
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎您！</title>
</head>
<body>
<form method="post" action="query">
    <table border="1" width="800px">
        <caption>欢迎使用学生信息管理系统</caption>
        <tr>
            <td colspan="8">
                <label for="stu_name"> 按姓名查询：</label><input type="text" name="stu_name" id="stu_name">
                <label> 按性别查询：
                    <select name="select">
                        <option> -请选择- </option>
                        <option> 男 </option>
                        <option> 女 </option>
                    </select>
                </label>
                <button type="submit"> 查询 </button>
                <a href="add.jsp" target="_blank"> 添加 </a>
            </td>
        </tr>
        <tr>
            <td align="center">id</td>
            <td align="center">姓名</td>
            <td align="center">性别</td>
            <td align="center">电话</td>
            <td align="center">生日</td>
            <td align="center">爱好</td>
            <td align="center">简介</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach var="stu" items="${sessionScope.list}">
            <tr align="center">
                <td>${stu.getId()}</td>
                <td>${stu.getName()}</td>
                <td>${stu.getGender()}</td>
                <td>${stu.getPhone()}</td>
                <td>${stu.getBirthday()}</td>
                <td>${stu.getHobby()}</td>
                <td>${stu.getInfo()}</td>
                <td><a href="#">更新</a> <a href="#">删除</a> </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
