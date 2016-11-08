
<%--

  User: Igor Gavrilyuk
  Date: 02.11.2016
  Time: 12:46

--%>
<%--@elvariable id="group" type="net.students.model.AcademicGroup"--%>
<%--@elvariable id="errorString" type="java.lang.String"--%>
<%--@elvariable id="mentors" type="java.util.List"--%>
<%--@elvariable id="students" type="java.util.List"--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<html>
<head>
    <title>Edit Academic Group</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<h3>Edit Academic Group</h3>
<p style="color: red;">${errorString}</p>

<form action="<c:url value="/editGroup"/>" method="POST">
    <input type="hidden" name="groupId" value="${group.groupId}"/>
    <table>
        <tr>
            <td>Title:</td>
            <td><label><input type="text" name="title" value="${group.title}"/></label></td>
        </tr>
        <tr>
            <td>Mentor:</td>
            <td>
                <label>
                    <select name="mentorId">
                        <c:forEach var="mentor" items="${mentors}">
                            <c:choose>
                                <c:when test="${mentor.mentorId == group.mentorId}">
                                    <option value="${mentor.mentorId}" selected><c:out value="${mentor.firstName} ${mentor.lastName}"/>
                                    </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${mentor.mentorId}"><c:out value="${mentor.firstName} ${mentor.lastName}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td><input type="submit" value="OK" name="OK"/></td>
            <td><input type="submit" value="Cancel" name="Cancel"/></td>
        </tr>
    </table>
</form>
<h4>List of Students</h4>
<table border="1" cellpadding="5" cellspacing="1" >
    <thead>
    <tr>
        <th> </th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date Of Birth</th>
        <th>Test Book Number</th>
        <th>Group</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${students}" var="student">
        <tr>
            <td><label><input type="radio" name="studentId" value="${student.studentId}"></label></td>
            <td><c:out value="${student.firstName}" /></td>
            <td><c:out value="${student.lastName}" /></td>
            <td><joda:format value="${student.dateOfBirth}" pattern="yyyy-MM-dd" /></td>
            <td><c:out value="${student.testBookNumber}" /></td>
            <td><c:out value="${group.title}" /> </td>
            <td> <form action="<c:url value="/editStudent"/>"  method="get">
                <input type="hidden" name="studentId"  value="${student.studentId }">
                <input type="submit"  value="Edit" name="edit">
            </form>
            </td>

            <td> <form action="<c:url value="/deleteStudent"/>"  method="post">
                <input type="hidden" name="studentId"  value="${student.studentId }">
                <input type="submit"  value="Delete" name="delete">
            </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>

