<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
    <script type="text/javascript">
    window.location.href="list.action";
    </script>
  </head>
  <body>
    <h1>Welcome To Struts 2!</h1>
    <a href="ex01.action?msg=abc&su1=1234">go ex01</a>
    <form action="ex02.action">
        <div>
            <label>deptno</label>
            <input type="text" name="deptno" value="${ bean.deptno}">${validationAware.fieldErrors.deptno }
        </div>
        <div>
            <label>dname</label>
            <input type="text" name="dname" value="${ bean.dname}">${validationAware.fieldErrors.dname }
        </div>
        <div>
            <label>loc</label>
            <input type="text" name="loc" value="${bena.loc }">${validationAware.fieldErrors.loc }
        </div>
        <div>
            <button>go ex02</button>
        </div>
    </form>
    
  </body>
</html>