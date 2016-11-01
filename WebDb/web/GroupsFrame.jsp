<%--@elvariable id="groups_form" type="students.web.forms.GroupsForm"--%>
<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 31.10.2016
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Mentors List</title>
</head>

<body>
<form action="<c:url value="/groups"/>" method="POST">

    <b>List of groups:</b>
    <br/>
    <table  <%--border="1"--%>>
        <tr>
            <th> </th>
            <th>Title</th>
            <th>Mentor</th>
        </tr>

        <c:forEach var="group" items="${groups_form.groups}">
            <tr>
                <td><label><input type="radio" name="groupId" value="${group.groupId}"></label></td>
                <td><c:out value="${group.title}"/></td>
                <td><c:forEach var="mentor" items="${groups_form.mentors}">
                        <c:if test="${group.mentor == mentor.id}">
                            <c:out value="${mentor.firstName} ${mentor.lastName}"/>
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

