
<%--
  
  User: Igor Gavrilyuk
  Date: 02.11.2016
  Time: 12:46
  
--%>
<%--@elvariable id="mentors" type="java.util.List"--%>
<%--@elvariable id="mentor" type="net.students.model.Mentor"--%>
<%--@elvariable id="errorString" type="java.lang.String"--%>
<%--@elvariable id="groups" type="java.util.List"--%>
<%--@elvariable id="infoString" type="java.lang.String"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Mentors</title>
</head>
<body>

    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>

    <h3>List of Mentors</h3>
    <p style="color: red;">${errorString}</p>
    <p style="color: green;">${infoString}</p>
    <form action="<c:url value="/editMentor"/>"  method="post">
        <input type="submit"  value="Add New" name="insert">
    </form>
    <br>

    <table border="1" cellpadding="5" cellspacing="1" >
    <thead>
    <tr>
        <th> </th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Group</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach items="${mentors}" var="mentor">
        <tr>
            <td><label><input type="radio" name="mentorId" value="${mentor.mentorId}"></label></td>
            <td><c:out value="${mentor.firstName}" /></td>
            <td><c:out value="${mentor.lastName}" /></td>
            <td><c:forEach var="group" items="${groups}">
                <c:if test="${group.mentorId==mentor.mentorId}">
                    <c:out value="${group.title}"/>
                </c:if>
                </c:forEach>
            </td>
            <td> <form action="<c:url value="/editMentor"/>"  method="get">
                <input type="hidden" name="mentorId"  value="${mentor.mentorId }">
                <input type="submit"  value="Edit" name="edit">
            </form>
            </td>
            <td> <form action="<c:url value="/deleteMentor"/>"  method="post">
                <input type="hidden" name="mentorId"  value="${mentor.mentorId }">
                <input type="submit"  value="Delete" name="delete">
            </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

    <jsp:include page="_footer.jsp"/>

</body>
</html>

