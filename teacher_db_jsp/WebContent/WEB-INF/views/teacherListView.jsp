<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Teacher List</title>
 </head>
 <body>
 
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="6" cellspacing="1" >
      	<tr>
       		<th>id</th>
          	<th>firstName</th>
          	<th>lastName</th>
          	<th>position</th>
          	<th>dateOfBirthday</th>
          	<th>department</th>
          	<th>qualifyingCategory</th>
          	<th>load</th>
          	<th>Edit</th>
          	<th>Delete</th>
       	</tr>
       	<c:forEach items="${teacherList}" var="teacher" >
        	<tr>
          		<td>${teacher.id}</td>
             	<td>${teacher.firstName}</td>
             	<td>${teacher.lastName}</td>
            	<td>${teacher.position}</td>
            	<td>${teacher.dateOfBirthday}</td>
             	<td>${teacher.departmentId}</td>
            	<td>${teacher.qualifyingCategory}</td>
            	<td>${teacher.load}</td>
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