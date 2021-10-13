<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>page 2</h1>
     <p>msg: ${msg }</p>
     <p>msg: <%=request.getAttribute("msg") %></p>
     <a href="test1/ex03.action">go3</a>
</body>
</html>