<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search teacher</title>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
 
    <h3>Search teacher</h3>
 
    <p style="color: red;">${errorString}</p>
  
    <table border="1" cellpadding="6" cellspacing="1" >
      	<tr>
       		<th>id</th>
          	<th>firstName</th>
          	<th>lastName</th>
          	<th>Edit</th>
          	<th>Delete</th>
       	</tr>
       	<c:forEach items="${teacherSearch}" var="teacher" >
        	<tr>
          		<td>${teacher.id}</td>
             	<td>${teacher.firstName}</td>
             	<td>${teacher.lastName}</td>
             	<td>
             		<a href="editTeacher?id=${teacher.id}">Edit</a> 
             	</td>
             	<td>
                	<a href="deleteTeacher?id=${teacher.id}">Delete</a>
            	</td>
          	</tr>
       </c:forEach>
    </table>

    <a href="createTeacher" >Create New Teacher</a>
 
    <jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>