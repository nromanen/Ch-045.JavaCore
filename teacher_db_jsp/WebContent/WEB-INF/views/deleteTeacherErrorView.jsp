<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Delete Product</title>
 </head>
 
 <body>
 
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
    
    <h3>Delete Teacher</h3>
    
    <p style="color: red;">${errorString}</p>
    <a href="teacherList">Teacher List</a>
    
    <jsp:include page="footer.jsp"></jsp:include>
    
 </body>
</html>