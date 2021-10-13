<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<style type="text/css">
   table tr>th:first-child {
	  width: 80px;
  }
   table td>a{
      diaplay: block;
   }
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
    <div class="jumbotron">
        <h1>List Page</h1>
        <a href="add.action" class="btn-default" role="button">입 력</a>
    </div>
      <h1>List Page</h1>
      
      <table class="table">
         <thead>
               <tr>
                   <th>deptno</th>
                   <th>dname</th>
                   <th>loc</th>
               </tr>
         </thead>
         <tbody>
         <c:forEach items='${list }' var="bean">
             <tr>
                 <td><a href="detail.action?deptno=${bean.deptno}">${bean.deptno }</td>
                  <td><a href="detail.action?deptno=${bean.deptno}">${bean.dname }</td>
                   <td><a href="detail.action?deptno=${bean.deptno}">${bean.loc }</td>
             </tr>
         </c:forEach>
         </tbody>
      </table>
</body>
</html>
