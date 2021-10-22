<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
		    	<li><a href="${pageContext.servletContext.contextPath }/">home</a></li>
		    	<li class="active"><a href="${pageContext.servletContext.contextPath }/dept/">dept</a></li>
		    	<li><a href="#">emp</a></li>
		    	<li><a href="#">login</a></li>
		    </ul>
	    </div>
	  </div>
	</nav>
	<ol class="breadcrumb">
	  <li><a href="${pageContext.servletContext.contextPath }/">home</a></li>
	  <li class="active">dept</li>
	</ol>
	<!-- content start -->
    <div class="page-header">
       <h2>dept list</h2>
    </div>
    <table class="table table-bordered">
      <thead>
          <tr>
             <th>deptno</th>
             <th>dname</th>
             <th>loc</th>  
          </tr>
      </thead>
      <tbody>
      <c:forEach items="${list }" var="bean">
		<c:url value="${bean.deptno }" var="detail"></c:url>
			<tr>
				<td><a href="${detail }">${bean.deptno }</a></td>
				<td><a href="${detail }">${bean.dname }</a></td>
				<td><a href="${detail }">${bean.loc }</a></td>
			</tr>
		</c:forEach>
      </tbody>
    </table>
    <a href="add" class="btn btn-primary btn-block" role="button">입력</a>
	<!-- 필터에서 처리 -->
	<!-- content end -->
	<div>
	<address>
  <strong>더조은</strong><br>
  서울시 종로구 삼일대로 17길 51<br>
  <abbr title="Phone">P:</abbr> (123) 1588.8748
</address>
   &copy; THEJOEUN ACADEMY Corp.
</div>