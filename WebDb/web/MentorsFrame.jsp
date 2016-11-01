<%--@elvariable id="mentors_form" type="students.web.forms.MentorsForm"--%>
<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 30.10.2016
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Mentors List</title>
</head>

<body>
<form action="<c:url value="/mentors"/>" method="POST">

    <b>List of mentors:</b>
    <br/>
    <table  <%--border="1"--%>>
        <tr>
            <th> </th>
            <th>FistName</th>
            <th>LastName</th>
            <th>Group</th>

        </tr>

        <c:forEach var="mentor" items="${mentors_form.mentors}">
            <tr>
                <td><label><input type="radio" name="mentorId" value="${mentor.id}"></label></td>
                <td><c:out value="${mentor.firstName}"/></td>
                <td><c:out value="${mentor.lastName}"/></td>
                <td><c:forEach var="group" items="${mentors_form.groups}">
                        <c:if test="${group.groupId==mentor.groupId}">
                            <c:out value="${group.title}"/>
                        </c:if>
                </c:forEach></td>
                <%--<td><c:out value="${mentor.groupId}"/></td>--%>
            </tr>
        </c:forEach>
    </>

    <table>
        <tr>
            <td><input type="submit" value="Add" name="Add"/></td>
            <td><input type="submit" value="Edit" name="Edit"/></td>
            <td><input type="submit" value="Delete" name="Delete"/></td>
        </tr>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</form>
</body>
</html>

