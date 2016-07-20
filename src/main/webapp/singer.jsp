<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>添加歌手</head>
<body>
<form:form enctype="multipart/form-data"  method="post" action="/pk/addSinger">
    昵称:<input id="nickname" name="nickname" type="text"/><br/>
    头像:<input id="image" name="head" type="file" multiple=""/><br/>
    <input type="submit" value="完成" name="完成"/>
</form:form>
</body>
<html>