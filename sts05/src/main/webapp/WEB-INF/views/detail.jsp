<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<div class="page-header">
     <h3>상세페이지<small>${bean.deptno}</small></h3>
     <form class="form-horizontal" method="get" action="edit">
  <div class="form-group">
    <label for="deptno" class="col-sm-2 control-label">deptno</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="deptno" id="deptno" value=${bean.deptno } readonly >
    </div>
  </div>
  <div class="form-group">
    <label for="dname" class="col-sm-2 control-label">dname</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="dname" id="dname" value=${bean.dname } disabled="disabled">
    </div>
  </div>
   <div class="form-group">
    <label for="loc" class="col-sm-2 control-label">loc</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="loc" id="loc"  value=${bean.loc } disabled="disabled">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">수정</button>
     <button type="button" class="btn btn-primary  data-toggle="modal" data-target="#myModal">
 삭제
</button>
      <button type="button" class="btn btn-default" onclick="history.back">뒤로</button>
    </div>
  </div>
</form>
</div>
<%@ include file="template/footer.jspf" %>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">삭제하시겠습니까?</h4>
      </div>
       <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        <form action="delete" method="post">
        <input type="hidden" name="deptno" value="${bean.deptno}" />
        <button type="submit" class="btn btn-danger">삭제</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>