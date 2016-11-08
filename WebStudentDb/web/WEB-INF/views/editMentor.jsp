
<%--

  User: Igor Gavrilyuk
  Date: 02.11.2016
  Time: 12:46

--%>
<%--@elvariable id="mentor" type="net.students.model.Mentor"--%>
<%--@elvariable id="errorString" type="java.lang.String"--%>
<%--@elvariable id="groups" type="java.util.List"--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<html>
<head>

    <title>Edit Mentor</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<h3>Edit Student</h3>
<p style="color: red;">${errorString}</p>

<form action="<c:url value="/editMentor"/>" method="POST">
    <input type="hidden" name="mentorId" value="${mentor.mentorId}"/>
    <table>
        <tr>
            <td>First Name:</td>
            <td><label><input type="text" name="firstName" value="${mentor.firstName}"/></label></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><label> <input type="text" name="lastName" value="${mentor.lastName}"/></label></td>
        </tr>
        <tr>
                <td>Group:</td>
                <td>
                    <label>
                        <select name="groupId">
                            <c:forEach var="group" items="${groups}">
                                <c:choose>
                                    <c:when test="${group.mentorId==mentor.mentorId}">
                                        <option value="${group.groupId}" selected><c:out value="${group.title}"/>
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${group.groupId}"><c:out value="${group.title}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </label>
                </td>
        </tr>
    </table>
    <table>
        <tr>
            <td><input type="submit" value="OK" name="OK"/></td>
            <td><input type="submit" value="Cancel" name="Cancel"/></td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>

