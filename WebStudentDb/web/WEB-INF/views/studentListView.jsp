
<%--
  
  User: Igor Gavrilyuk
  Date: 04.11.2016
  Time: 02:46
  
--%>
<%--@elvariable id="infoString" type="java.lang.String"--%>
<%--@elvariable id="students" type="java.util.List"--%>
<%--@elvariable id="errorString" type="java.lang.String"--%>
<%--@elvariable id="groups" type="java.util.List"--%>
<%--@elvariable id="student" type="net.students.model.Student"--%>
<%--@elvariable id="filter_form" type="net.students.controller.StudentFilterForm"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/students.css">
    <title>List of Students</title>
</head>
<body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="menu.jsp"/>

    <h3>List of Students</h3>
    <p style="color: red;">${errorString}</p>
    <p style="color: green;">${infoString}</p>
    <form action="<c:url value="/editStudent"/>"  method="post">
        <input type="submit"  value="Add New" name="insert">
    </form>
    <br>
 <form action="<c:url value="/listStudent"/>" >
    <table>
        <tr>
            <td>First Name:<label><input type="text" name="firstName" value="${filter_form.firstName}"/></label><br/></td>
            <td>Last Name:<label><input type="text" name="lastName" value="${filter_form.lastName}"/></label><br/></td>
            <td>Book Number:<label><input type="text" name="testBookNumber" value="${filter_form.testBookNumber}"/></label><br/></td>
            <td>Select group:
                <label>
                    <select name="groupId">
                        <option value="" >All</option>
                        <c:forEach var="group" items="${groups}">
                            <c:choose>
                                <c:when test="${group.groupId==filter_form.groupId}">
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
            <td><input type="submit" name="filterList" value="Apply"/></td>
        </tr>
    </table>
    </form>
    <br>
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
                <td><c:forEach var="group" items="${groups}">
                    <c:if test="${group.groupId==student.groupId}">
                        <c:out value="${group.title}"/>
                    </c:if>
                    </c:forEach>
                </td>

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
        <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <td><a href="listStudent?page=${currentPage - 1}">Previous</a></td>
        </c:if>
        <%--For displaying Page numbers. --%>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <c:forEach begin="1" end="${numOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <td>${i}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="listStudent?page=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>
        <%--For displaying Next link --%>
        <c:if test="${currentPage lt numOfPages}">
            <td><a href="listStudent?page=${currentPage + 1}">Next</a></td>
        </c:if>

        <jsp:include page="footer.jsp"/>
</body>
</html>

