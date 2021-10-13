<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
     <div class="jumbotron">
        <h1>입력 페이지</h1>
    </div>
    <form action="insert.action" method="post">
  <div class="form-group">
    <label for="dname">dname</label>
    <input type="text" class="form-control" name="dname" id="dname" placeholder="부서명">
  </div>
  <div class="form-group">
    <label for="dname">loc</label>
    <select class="form-control" name="loc" id="loc">
      <option>서울</option>
      <option>대전</option>
      <option>대구</option>
      <option>부산</option>
      <option>광주</option>
    </select>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>