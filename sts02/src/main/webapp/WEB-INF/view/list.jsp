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
  <h2>리스트 페이지 <small>DEPT LIST</small></h2>
</div>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
	<c:fotEach items="${list }" var="bean">
	<c:url var="detail" value="detail.do">
	    <c:param name="deptno" value="${bean.deptno }"></c:param>
	</c:url>
	   <tr>
	       <td><a href="#">${bean.deptno}</a></td>
	       <td><a href="#">${bean.dname}</a></td>
	       <td><a href="#">${bean.loc}</a></td>
	   </tr>
	</c:fotEach>
	</tbody>
</table>
<p><a href="add.do" class="btn btn-primary" role="button">입력</a></p>
</body>
</html>
