<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>download page</h1>
<ul>
   <c:forEach items="${list }" var="down">
   <li><a href="down?fname=${down }">down</a></li>
   </c:forEach>
</ul>

<ol>
   <c:forEach items="${list }" var="down">
   <li><a href="download/${down }">down</a></li>
   </c:forEach>
</ol>
</body>
</html>