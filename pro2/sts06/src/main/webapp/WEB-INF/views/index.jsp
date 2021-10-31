<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/resources/css/bootstrap.min.css" />
<style type="text/css">
.carousel-inner img{
	margin: 0px auto;
}
</style>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${pageContext.servletContext.contextPath }/">
	        <div>더조은교육센터</div>
	      </a>
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    <ul class="nav navbar-nav">
		    	<li class="active"><a href="${pageContext.servletContext.contextPath }/">home</a></li>
		    	<li><a href="${pageContext.servletContext.contextPath }/dept/">dept</a></li>
		    	<li><a href="#">emp</a></li>
		    	<li><a href="#">login</a></li>
		    </ul>
	    </div>
	  </div>
	</nav>
	<ol class="breadcrumb">
	  <li class="active">Home</li>
	</ol>
	<!-- content start -->
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="resources/imgs/sm01.jpg" alt="..." />
	    </div>
	    <div class="item">
	      <img src="resources/imgs/sm02.jpg" alt="..." />
	    </div>
	    <div class="item">
	      <img src="resources/imgs/sm03.jpg" alt="..." />
	    </div>
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	<!-- content end -->
	<div>
		<address>
		  <strong>더조은컴퓨터아카데미</strong><br>
		  서울특별시 종로구 삼일대로 17길 51, 3,4,5층(관철동, 스타골드빌딩)<br>
		  <abbr title="Phone">P:</abbr> 1588.8748
		</address>
		&copy; THEJOEUN ACADEMY Corp.
	</div>
</div>
</body>
</html>








