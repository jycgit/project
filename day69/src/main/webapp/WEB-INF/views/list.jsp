<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  %>    
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
          <c:forEach item="${list}" var="bean">
          <tr>
             <td>${bean.deptno}</td>
             <td>${bean.dname}</td>
             <td>${bean.loc}</td>
          </tr>
     </c:forEach>
     </tbody>
     </table>

</body>
</html>