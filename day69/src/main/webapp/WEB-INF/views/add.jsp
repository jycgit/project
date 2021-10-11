<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1>입력 페이지</h1>
       <form action="insert.do" method>
          <div>
              <label>deptno</label>
              <input type="text" name="post" />
          </div>
          <div>
              <label>dname</label>
              <input type="text" name="dname" />
          </div>
             <select name="loc">
                 <option>서울</option>
                 <option>대전</option>
                 <option>대구</option>
                 <option>부산</option>
                 <option>광주</option>
                 <option>제주</option>
             </select>
          <div>
              <button>submit</button>
              <button type="reset">reset</button>
              <button type="button" oneclick="history.back"> back/button>
          </div>
       </form>
</body>
</html>