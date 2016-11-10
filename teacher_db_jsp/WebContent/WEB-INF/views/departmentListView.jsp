<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Department List</title>
 </head>
 <body>
 
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
 
    <h3>Department List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="1" cellspacing="1" >
      	<tr>
       		<th>id</th>
          	<th>title</th>
          	
          	<th>Edit</th>
          	<th>Delete</th>
       	</tr>
       	<c:forEach items="${departmentList}" var="department" >
        	<tr>
          		<td>${department.id}</td>
             	<td>${department.title}</td>
             	
             	<td>
             		<a href="editDepartment?id=${department.id}">Edit</a> 
             	</td>
             	<td>
                	<a href="deleteDepartment?id=${department.id}">Delete</a>
            	</td>
          	</tr>
       </c:forEach>
    </table>

    <a href="createTeacher" >Create New Department</a>
 
    <jsp:include page="footer.jsp"></jsp:include>
 
 </body>
</html>