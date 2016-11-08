
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
    <title>Academic Groups</title>
</head>
<body>


    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>

    <h3>Academic Groups</h3>
    <p style="color: red;">${errorString}</p>
    <p style="color: green;">${infoString}</p>
    <form action="<c:url value="/editGroup"/>"  method="post">
        <input type="submit"  value="Add New" name="insert">
    </form>
    <br/>
    <table  border="1" cellpadding="5" cellspacing="1">
        <thead>
        <tr>
            <th> </th>
            <th>Title:</th>
            <th>Mentor:</th>
            <th>List of students:</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td><label><input type="radio" name="groupId" value="${group.groupId}"></label></td>
                <td><c:out value="${group.title}"/></td>
                <td><c:forEach var="mentor" items="${mentors}">
                    <c:if test="${group.mentorId == mentor.mentorId}">
                        <c:out value="${mentor.firstName} ${mentor.lastName}"/>
                    </c:if>
                    </c:forEach>
                </td>
                 <td><a href="editGroup?groupId=<c:out value="${group.groupId }"/>">Students</a></td>
                <td> <form action="<c:url value="/editGroup"/>"  method="get">
                    <input type="hidden" name="groupId"  value="${group.groupId }">
                    <input type="submit"  value="Edit" name="edit">
                </form>
                </td>
                <td> <form action="<c:url value="/deleteGroup"/>"  method="post">
                    <input type="hidden" name="groupId"  value="${group.groupId  }">
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

