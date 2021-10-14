<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/head.jspf" %>
<style type="text/css">
    input::placeholder{
    color:#ff0000 !important;}
</style>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<h2>입력페이지</h2>
<form action="insert.action" method="post">
    <div class="form=group">
        <label for="">dname</label>
        <input type="text" name="dname"  id="dname" class="form-control" placeholder="${ fieldErrors}"/>  
    </div>
    <div class="form=group">
        <label for="">loc</label>
        <input type="text" name="loc"  id="loc" class="form-control" placeholder="${ fieldErrors}"/>
    </div>   
       <button class="btn btn-primary" >입력</button>
       <button class="btn btn-default" type="reset" >취소</button>  
</form>
<%@ include file="template/footer.jspf" %>
</body>
</html>