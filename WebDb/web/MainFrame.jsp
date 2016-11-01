<%--@elvariable id="form" type="students.web.forms.MainFrameForm"--%>
<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 31.10.2016
--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>


<html>
<head>
    <title>Students List</title>
</head>

<body>


<form action="<c:url value="/main"/>" method="POST">

    <table>
        <tr>
            <td>Test Book Number:<label><input type="text" name="bookNum" value="${form.bookNum}"/></label><br/></td>
            <td>Student Name:<label><input type="text" name="fullName" value="${form.name}"/></label><br/></td>
            <td>Select group:
                <label>
                    <select name="groupId">
                        <c:forEach var="group" items="${form.groups}">
                            <c:choose>
                                <c:when test="${group.groupId==form.groupId}">
                                    <option value="${group.groupId}" selected><c:out value="${group.title}"/></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${group.groupId}"><c:out value="${group.title}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </label>
            </td>
            <td><input type="submit" name="getList" value="Refresh"/></td>
        </tr>
    </table>

    <p></p>
    <b>List of students for the chosen parameters:</b>
        <br/>
        <table>
            <tr>
                <th> </th>
                <th>FistName</th>
                <th>LastName</th>
                <th>Date Of Birth</th>
                <th>Test Book Number</th>
                <th>Group</th>
            </tr>
            <c:forEach var="student" items="${form.students}">
                <tr>
                    <td><label><input type="radio" name="studentId" value="${student.studentId}"></label></td>
                    <td><c:out value="${student.firstName}"/></td>
                    <td><c:out value="${student.lastName}"/></td>
                    <td>
                        <%--http://joda-time.sourceforge.net/contrib/jsptags/userguide.html--%>
                        <joda:format value="${student.dateOfBirthdy}" pattern="yyyy-MM-dd" />
                    </td>
                    <%-- <td><fmt:formatDate  value="${student.dateOfBirthdy}" type="date"/></td>--%>
                    <td><c:out value="${student.testBookNumber}"/></td>
                    <%--<td><c:out value="${student.groupId}"/></td>--%>
                <td><c:forEach var="group" items="${form.groups}">
                        <c:if test="${group.groupId==student.groupId}">
                            <c:out value="${group.title}"/>
                        </c:if>
                    </c:forEach>
                <td>
                </tr>
            </c:forEach>
        </table>

        <table>
            <tr>
                <td><input type="submit" value="Add" name="Add"/></td>
                <td><input type="submit" value="Edit" name="Edit"/></td>
                <td><input type="submit" value="Delete" name="Delete"/></td>
            </tr>
        </table>

        <p></p>
        <b>Move students in the group</b>
            <br/>
            <table>
                <tr>
                    <td>Available groups:
                        <label>
                            <select name="newGroupId">
                                <c:forEach var="group" items="${form.groups}">
                                    <option value="${group.groupId}"><c:out value="${group.title}"/></option>
                                </c:forEach>
                            </select>
                        </label>
                    </td>
                    <td><input type="submit" name="MoveGroup" value="Move"/></td>
                    <td>
                        <c:if test="${not empty form.error}">
                            <%--<c:out value="${form.error}"/>--%>
                            <div style="color: #FF0000;">${form.error}</div>
                        </c:if>
                    </td>
                </tr>

            </table>

    </form>

    <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</body>
</html>

