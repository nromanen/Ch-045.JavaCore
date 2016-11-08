<%--
  User: Igor Gavrilyuk
  Date: 05.11.2016
  Time: 02:46

--%>
<%--@elvariable id="student" type="net.students.model.Student"--%>
<%--@elvariable id="errorString" type="java.lang.String"--%>
<%--@elvariable id="groups" type="java.util.List"--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<h3>Edit Student</h3>
<p style="color: red;">${errorString}</p>

<form action="<c:url value="/editStudent"/>" method="POST">

    <input type="hidden" name="studentId" value="${student.studentId}"/>
    <table>
        <tr>
            <td>First Name:</td><td><input type="text" name="firstName" value="${student.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name:</td><td><input type="text" name="lastName" value="${student.lastName}"/></td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
             <td>
                 <joda:format var="date" value="${student.dateOfBirth}" pattern="yyyy-MM-dd" />
                 <input type="text" name="dateOfBirth" value="${date}"/>
            </td>
        </tr>
        <tr>
                <td>Group:</td>
                <td>
                    <label>
                        <select name="groupId">
                            <c:forEach var="group" items="${groups}">
                                <c:choose>
                                    <c:when test="${group.groupId==student.groupId}">
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
        <tr>
            <td>Test Book Number:</td><td><input type="text" name="testBookNumber" value="${student.testBookNumber}"/></td>
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

