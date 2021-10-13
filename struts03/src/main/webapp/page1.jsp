<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>page 1</h1>
     <a href="ex02.action?msg=abcd">go1</a>
     <form action="ex02.action">
         <input type="text" name="msg"/>
         <button>전달</button>
     </form>
</body>
</html>