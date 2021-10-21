<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>param 전달</h1>
     <a href="ex07.do?msg=abcd">ex07</a>
     <form action="ex08.do" method="get">
        <input type="text" name="get">
        <button>ex08</button>
     </form>
</body>
</html>