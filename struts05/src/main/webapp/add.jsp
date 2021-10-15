<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>Insert Page</h1>
     <form action="insert.do" method="post">
        <div>
            <label for="dname">dname</label>
            <input type="text" name="dname" id="dname" value=""/>
        </div>
        <div>
            <label for="loc">loc</label>
            <input type="text" name="loc" id="loc" value=""/>
        </div>
        <div>
            <button>Insert</button>
            <button type="reset">Reset</button>
        </div>
     </form>
</body>
</html>