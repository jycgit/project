<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${root }webjars/bootstrap/3.4.1/css/bootstrap.min.css'/>
<script type="text/javascript" src="${root }webjars/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="${root }webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
	    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		</button>
      <a class="navbar-brand" href="${root }">
        <div>더조은교육센터</div>
      </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    	<ul class="nav navbar-nav">
    		<li><a href="${root }">home</a></li>
    		<li><a href="${root }dept/">dept</a></li>
    		<li><a href="${root }emp/">emp</a></li>
    		<li><a href="${root }login/">login</a></li>
    	</ul>
    </div>
  </div>
</nav>
<!-- nav end -->
<div class="container">
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>...</p>
	  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	</div>
	<div class="row">
		<div class="col-md-12">
			<address>
			  <strong>더조은컴퓨터아카데미</strong><br>
			   서울특별시 서초구 강남대로 279, 5층(서초동, 백향빌딩)<br>
			  <abbr title="Phone">P:</abbr> 1588.8748
			</address>
			&copy; THEJOEUN ACADEMY Corp.
		</div>
	</div>
</div>
</body>
</html>

