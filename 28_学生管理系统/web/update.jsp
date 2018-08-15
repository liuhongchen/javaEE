<%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2018/8/15
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<form action="update" method="post">
    <label for="stu_id">id：</label><input type="text" id="stu_id" name="stu_id" readonly="readonly" >
    <label for="stu_name">姓名 ： </label><input name="stu_name" id="stu_name" type="text" />
    <br>
    <label>性别：</label>
    <label for="stu_gender1"> 男</label><input type="radio" name="stu_gender" id="stu_gender1">
    <label for="stu_gender2"> 女</label><input type="radio" name="stu_gender" id="stu_gender2">
    <br>
    <label for="stu_phone">手机 ：</label><input type="text" name="stu_phone" id="stu_phone">
    <br>
    <label for="stu_birthday">生日 ：</label><input type="date" name="stu_birthday" id="stu_birthday">
    <br>
    <label for="stu_hobby">爱好 ：</label><input type="text" name="stu_hobby" id="stu_hobby">
    <br>
    <label for="stu_info">个人描述 ：</label><input type="text" name="stu_info" id="stu_info">
    <br>
    <button type="submit">更新</button>
</form>
</body>
</html>
