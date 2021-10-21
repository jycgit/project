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
<%@ include file="template/menu.jspf" %>
<div class="table">
    <h3>리스트 페이지 </h3>
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
        <c:url value="detail" var="url">
               <c:param name="deptno" value="${bean.deptno }"/>
        </c:url>
     
        <tr>
           <td><a href="${bean.deptno }"></a></td>
           <td><a href="${bean.dname }"></a></td>
           <td><a href="${bean.loc }"></a></td>
        </tr>
     </c:forEach>
   </tbody>
</table>
<a href="add" class="btn btn-primary btn block" role="button"> 입력</a>
<%@ include file="template/footer.jspf" %>
</body>
</html>