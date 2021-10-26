<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<script type="text/javascript" src="webjars/jquery/1.12.4/dist/jquery.min.js"></script>
    <script type="text/javascript">
    var cnt=1;
    $(function(){
    	$('button[type="button"]').click(function(){
    		cnt++;
    		$('<li>input type="file" name="file'+cnt+'" /></li>').appendTo('ul');
    	});
    });
    </script>
</head>

<body>
<h1>
	Hello world!  
</h1>

<form action="upload" method="post" enctype="multipart/form-data">
	<ul>
	   <li>msg:<input type="text" name="msg"/></li>
	   <li><input type="file" name="file1" /></li>
	</ul>
	<button type="button">첨부추가</button><br/>
	<button>전송</button>
	
</form>
</body>
</html>
