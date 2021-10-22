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
	  <li><a href="${pageContext.servletContext.contextPath }/">Home</a></li>
	  <li><a href="${pageContext.servletContext.contextPath }/dept/">dept</a></li>
	  <li class="active">${title }</li>
	</ol>
	<!-- content start -->
	<div class="page-header">
		<h2>dept ${title }</h2>
	</div>
	<form class="form-horizontal" action="${url }" method="post">
	  <c:if test="${bean ne null }">
		  <c:if test="${title eq 'update' }">
		  <input type="hidden" name="_method" value="put"/>
		  </c:if>	  
	  <div class="form-group">
	    <label for="deptno" class="col-sm-2 control-label">deptno</label>
	    <div class="col-sm-10">
	      <input type="text" name="deptno" class="form-control" id="deptno" value="${bean.deptno}" readonly/>
	    </div>
	  </div>
	  </c:if>
	  <div class="form-group">
	    <label for="dname" class="col-sm-2 control-label">dname</label>
	    <div class="col-sm-10">
	      <input type="text" name="dname" class="form-control" id="dname" value="${bean.dname}" ${disabled }/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="loc" class="col-sm-2 control-label">loc</label>
	    <div class="col-sm-10">
	      <input type="text" name="loc" class="form-control" id="loc" value="${bean.loc}" ${disabled } />
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	    	<div class="btn-group btn-group-justified" role="group" aria-label="...">
		      <div class="btn-group" role="group">
		      <button type="submit" class="btn btn-primary btn-block">${title }</button>
		      </div>
		      <div class="btn-group" role="group">
		      <button type="${title eq 'detail' ? 'button' : 'reset'}" class="btn btn-block btn-${title eq 'detail' ? 'danger" onclick="$(\'#myModal\').modal(\'toggle\');"' : 'default'}">${title eq 'detail' ? 'delete' : 'reset'}</button>
		      </div>
		      <div class="btn-group" role="group">
		      <button type="button" class="btn btn-block btn-default" onclick="history.back();">back</button>
	    	  </div>
	    	</div>
	    </div>
	  </div>
	</form>
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

<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">확인</h4>
      </div>
      <div class="modal-body">
        <p>${bean.dname } 부서를 삭제하시겠습니까?</p>
      </div>
      <form method="post">
      	<input type="hidden" name="_method" value="delete"/>
      	<input type="hidden" name="deptno" value="${bean.deptno }">
      	
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-danger">delete</button>
      </div>
      </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>





