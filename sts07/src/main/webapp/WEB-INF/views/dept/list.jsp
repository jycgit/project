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
<script type="text/javascript">
var method='put';
$(function(){
	$('table+button').click(function(){
		$('.modal form>div>div').first().hide();
	});
	$('table a').click(function(){
		var deptno=$(this).parent().parent().children().first().text();
		$.get('${root}dept/'+deptno,function(data){
			$('#myModal').find('form').eq(1).find('input').eq(1).val(data.root[0].deptno);
			$('#myModal').find('form').eq(1).attr('action',data.root[0].deptno);
			$('#myModal').find('input').eq(0).val(data.root[0].deptno);
			$('#myModal').find('input').eq(1).val(data.root[0].dname);
			$('#myModal').find('input').eq(2).val(data.root[0].loc);
			$('#myModal').find('input').eq(1).prop('readonly',true);
			$('#myModal').find('input').eq(2).prop('readonly',true);
			$('#myModal').modal('show');
			$('#myModal form').eq(0).one('submit',function(){
				$(this).attr('action',deptno);
				$('<input type="hidden" name="_method" value="put"/>').appendTo(this);
				$('#myModal').find('input').eq(1).prop('readonly',false);
				$('#myModal').find('input').eq(2).prop('readonly',false);
				return false;
			});
		});
		return false;
	});
});
</script>
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
	<div class="page-header">
		<h2>리스트페이지<small>dept list</small></h2>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>deptno</th>
				<th>dname</th>
				<th>loc</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="bean">
			<c:url value="${bean.deptno }" var="row"></c:url>
			<tr>
				<td><a href="${row }">${bean.deptno }</a></td>
				<td><a href="${row }">${bean.dname }</a></td>
				<td><a href="${row }">${bean.loc }</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button class="btn btn-primary btn-block" data-toggle="modal" data-target="#myModal">입력</button>
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

<div class="modal fade" tabindex="-1" role="dialog" id="myModal" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">입력페이지</h4>
      </div>
        <form class="form-horizontal" method="post">
	      <div class="modal-body">
			  <div class="form-group">
			    <label for="deptno" class="col-sm-2 control-label">deptno</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="deptno" id="deptno" value="0" readonly/>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="dname" class="col-sm-2 control-label">dname</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="dname" id="dname" value="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="loc" class="col-sm-2 control-label">loc</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="loc" id="loc" value="">
			    </div>
			  </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">입력</button>
	      </div>
		</form action="" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="hidden" name="deptno" value="0"/>
		    <button>삭제</button>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>

