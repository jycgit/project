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
    <h2>상세페이지 <small>부서번호 : ${bean.deptno }</small></h2>    
</div>
<form action="edit.do" method="post">
    <input type="hidden" name="deptno" value="${bean.dname}">
    <div class="form-group">
        <label for="dname">dname</label>
        <input class="form-control" type="text" name="dname" id="dname" value="${bean.dname }" readonly/>
    </div>
     <div class="form-group">
        <label for="loc">loc</label>
        <input class="form-control" type="text" name="loc" id="loc" value="${bean.dname }" readonly/>
    </div>
     <div class="form-group">
        <button class="btn btn-primary">수정</button>
        <a class="btn btn-danger" href="delete.do?deptno="${bean.dpetno }" role="button">삭제</a>
        <button class="btn btn-primary" type="button" onclick="history.back();">뒤로</button>
    </div>
</form>
</body>
</html>