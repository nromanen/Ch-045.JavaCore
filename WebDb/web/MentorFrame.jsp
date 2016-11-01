<%--@elvariable id="mentor" type="students.web.forms.MentorForm"--%>
<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 31.10.2016
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Mentor</title>
    </head>

    <body>
        <form action="<c:url value="/edit_mentor"/>" method="POST">
            <input type="hidden" name="mentorId" value="${mentor.mentorId}"/>
            <table>
                <tr>
                    <td>First Name:</td><td><label><input type="text" name="firstName" value="${mentor.firstName}"/></label></td>
                </tr>
                <tr>
                    <td>Last Name:</td><td><label> <input type="text" name="lastName" value="${mentor.lastName}"/></label></td>
                </tr>
                <tr>
                    <td>Group:</td>
                    <td>
                        <label>
                            <select name="groupId">

                                <c:forEach var="group" items="${mentor.groups}">
                                    <c:choose>
                                        <c:when test="${group.groupId==mentor.groupId}">
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
    </body>
</html>