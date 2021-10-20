<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/nav.jspf" %>
<div class="page-header">
   <h2>입력페이지</h2>
</div>
<form action="insert.do" method="post">
   <div class="form-group">
      <label for="">dname</label>
      <input type="test" name="dname" id="dname"  class="form-control" value=""/>
   </div>
   <div class="form-group">
      <label for="">loc</label>
      <input type="test" name="loc" id="loc"  class="form-control" value=""/>
   </div>
   <div class="form-group">
       <button class="btn btn-primary">입력</button>
       <button type="reset">취소</button>
       <button type="button" onclick="history.back();">뒤로</button>
   </div> 
</form>
</body>
</html>