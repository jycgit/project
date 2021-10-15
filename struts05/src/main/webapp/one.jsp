<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>detail Page</h1>
     <form action="update.do" method="post">
         <div>
             <label for="deptno">deptno</label>
             <input type="text" name="deptno" id="deptno" value="${bean.deptno }"/>
         </div>
        <div>
             <label for="dname">dname</label>
             <input type="text" name="dname" id="dname" value="${bean.dname }"/>
         </div>
         <div>
             <label for="loc">loc</label>
             <input type="text" name="loc" id="loc" value="${bean.loc }"/>
         </div>
         <div>
             <button>수정</button>
             <a hraf="detail.do?deptno=${bean.deptno }"></a>
         </div>
     </form>
</body>
</html>