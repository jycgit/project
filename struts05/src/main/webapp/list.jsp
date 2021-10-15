<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>List page</h1>
    <table>
       <thead>
          <tr>
              <th>deptno</th>
              <th>dname</th>
              <th>loc</th>  
          </tr>
       </thead>
       <tbody>
       <c:forEach items="${list }" var="bean">
          <c:url var="detail" value="detail.do?">
               <c:param name="deptno">${bean.deptno }</c:param>
          </c:url>
          <tr>
              <td><a href="${detail }">${bean.deptno }</a></td>
              <td><a href="${detail }">${bean.dname }</a></td>
              <td><a href="${detail }">${bean.loc }</a></td>
          </tr>
       </c:forEach>
       </tbody>
    </table>
    <a href="add.do">Add</a>
</body>
</html>