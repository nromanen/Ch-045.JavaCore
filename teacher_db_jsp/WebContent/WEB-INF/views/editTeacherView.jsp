<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
 </head>
 <body>
 
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
 
    <h3>Edit teacher</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <c:if test="${not empty teacher}">
       <form method="POST" action="doEditTeacher">
          <input type="hidden" name="id" value="${teacher.id}" />
          <table border="0">
             <tr>
                <td>Id</td>
                <td style="color:red;">${teacher.id}</td>
             </tr>
             <tr>
                <td>firstName</td>
                <td><input type="text" name="firstName" value="${teacher.firstName}" /></td>
             </tr>
             <tr>
                <td>lastName</td>
                <td><input type="text" name="lastName" value="${teacher.lastName}" /></td>
             </tr>
             <tr>
                <td>position</td>
                <td><input type="text" name="position" value="${teacher.position}" /></td>
             </tr>
             <tr>
                <td colspan = "2">
                    <input type="submit" value="Update" />
                    <a href="${pageContext.request.contextPath}/teacherList">Cancel</a>
                </td>
             </tr>
          </table>
       </form>
    </c:if>
 
    <jsp:include page="footer.jsp"></jsp:include>
 
 </body>
</html>