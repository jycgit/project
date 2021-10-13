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
        <h1>${title } 페이지</h1>
    </div>
    <form action="edit.action" method="post">
    <div class="form-group">
    <label for="dname">deptno</label>
    <input type="text" class="form-control" name="deptno" id="deptno" values=${bean.deptno } readonly>
  </div>
  <div class="form-group">
    <label for="dname">dname</label>
    <input type="text" class="form-control" name="dname" id="dname" values=${bean.dname } ${readonly}>
  </div>
  <div class="form-group">
    <label for="dname">loc</label>
    <select class="form-control" name="loc" id="loc" ${disabled}>
      <option ${bean.loc eq "서울" ? "selected:"null }>서울</option>
      <option ${bean.loc eq "대전" ? "selected:"null }>대전</option>
      <option ${bean.loc eq "대구" ? "selected:"null }>대구</option>
      <option ${bean.loc eq "부산" ? "selected:"null }>부산</option>
      <option ${bean.loc eq "광주" ? "selected:"null }>광주</option>
      <option ${bean.loc eq "광주" ? "selected:"null }>울산</option>
    </select>
  </div>
  <button type="submit" class="btn btn-default">수정</button>
</form>
</body>
</html>