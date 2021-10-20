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
   <h2>리스트페이지</h2>
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
   <c:forEach items="${list }" var="bean">
       <tr>
          <td><a href="${detail }">${bean.deptno }</a></td>
          <td><a href="${detail }">${bean.dname }</a></td>
          <td><a href="${detail }">${bean.loc }</a></td>
       </tr> 
   </c:forEach>
   </tbody>
</table>
<a href="add.do" class="btn btn-primary" role="button">입력</a>
</body>
</html>