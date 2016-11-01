<%--@elvariable id="group_form" type="students.web.forms.GroupForm"--%>
<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 31.10.2016
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Academic Group</title>
    </head>

    <body>
        <form action="<c:url value="/edit_group"/>" method="POST">
            <input type="hidden" name="groupId" value="${group_form.groupId}"/>
            <table>
                <tr>
                    <td>Title:</td><td><label><input type="text" name="title" value="${group_form.title}"/></label></td>
                </tr>

                <tr>
                    <td>Mentor:</td>
                    <td>
                        <label>
                            <select name="mentorId">
                                <c:forEach var="mentor" items="${group_form.mentors}">
                                    <c:choose>
                                        <c:when test="${mentor.id == group_form.mentorId}">
                                            <option value="${mentor.id}" selected><c:out value="${mentor.firstName} ${mentor.lastName}"/>
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${mentor.id}"><c:out value="${mentor.firstName} ${mentor.lastName}"/></option>
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