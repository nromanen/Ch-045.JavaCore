<%--@elvariable id="student_form" type="students.model.Student"--%>
<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 30.10.2016
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Students list</title>
    </head>

    <body>
        <form action="<c:url value="/edit"/>" method="POST">
            <input type="hidden" name="studentId" value="${student_form.studentId}"/>
            <table>
                <tr>
                    <td>Last Name:</td><td><input type="text" name="lastName" value="${student_form.lastName}"/></td>
                </tr>
                <tr>
                    <td>First Name:</td><td><input type="text" name="firstName" value="${student_form.firstName}"/></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td><td><input type="text" name="dateOfBirthdy" value="${student_form.dateOfBirthdy}"/></td>
                </tr>
                <tr>
                    <td>Group:</td>
                    <td>
                        <select name="groupId">
                        <c:forEach var="group" items="${student_form.groups}">
                            <c:choose>
                                <c:when test="${group.groupId==student_form.groupId}">
                                    <option value="${group.groupId}" selected><c:out value="${group.title}"/></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${group.groupId}"><c:out value="${group.title}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Test Book Number:</td><td><input type="text" name="testBookNumber" value="${student_form.testBookNumber}"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><input type="submit" value="OK" name="OK"/></td>
                    <td><input type="submit" value="Cancel" name="Cancel"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>