<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/nav.jspf" %>
<div class="page-header">
    <h2>입력페이지</h2>
</div>
<form action="insert.do" method="post">
    <div class="form-group">
        <label for="dname">dname</label>
        <input class="form-control" type="text" name="dname" id="dname"/>
    </div>
     <div class="form-group">
        <label for="loc">loc</label>
        <input class="form-control" type="text" name="loc" id="loc"/>
    </div>
     <div class="form-group">
        <button class="btn btn-primary">입력</button>
        <button class="btn btn-primary" type="reset">취소</button>
        <button class="btn btn-primary" type="button" onclick="history.back();">뒤로</button>
    </div>
</form>
</body>
</html>