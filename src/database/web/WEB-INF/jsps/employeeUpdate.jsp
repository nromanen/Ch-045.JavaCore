
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>


<html>
<head>
    <title>Edit ${employee.firstName} ${employee.lastName}</title>
    <page:css></page:css>
</head>
<body>
<page:header department="${data}"/>


<div class="container">
    <hr>
    <h2>${message}${employee.firstName} ${employee.lastName}</h2>
    <form method="post" action="/${link}">

        <input type="number" hidden name="pk" value="${employee.emId}">
        <div class="form-group col-md-8">
            <label for="firstName">Firstname:</label>
            <input type="text" class="form-control" name="firstName" value="${employee.firstName}" id="firstName">
        </div>
        <div class="form-group col-md-8">
            <label for="lastName">Lastname:</label>
            <input type="text" class="form-control" name="lastName" value="${employee.lastName}" id="lastName">
        </div>
        <div class="form-group col-md-8">
            <label for="bDay">B-day:</label>
            <input type="date" class="form-control" name="bDay" value="${employee.bDay}" id="bDay">
        </div>
        <div class="form-group col-md-8">
            <label for="ssn">SSN:</label>
            <input type="number" class="form-control" name="ssn" value="${employee.SSN}" id="ssn">
        </div>
        <div class="form-group col-md-8">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" name="email" value="${employee.email}" id="email">
        </div>
        <div class="form-group col-md-8">
            <label for="char">Characteristic:</label>
            <textarea  class="form-control" name="char" id="char">${employee.characteristic}</textarea>
        </div>
        <div class="form-group col-md-8">
            <label for="rate">Rate:</label>
            <input type="number" class="form-control" name="rate" value="${employee.rate}" id="rate">
        </div>
        <div class="form-group col-md-8">
            <label for="position" class="control-label">Position</label>
            <select class="form-control" name="position" id="position">
                <c:forEach var="pos" items="${positions}">
                    <option <c:if test="${employee.position == pos}">selected</c:if>  >${pos}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-8">
            <label for="department" class="control-label">Department</label>
            <select class="form-control" name="department" id="department">
                <option selected>No department</option>
                <c:forEach var="dep" items="${data}">
                    <option <c:if test="${employee.department.depId == dep.depId}">selected</c:if> >${dep.title}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-12">
            <input type="submit" name="submit" value="Submit" class="btn btn-info ">
        </div>
    </form>




    <%--<form method="POST" action='UserController' name="frmAddUser">--%>
    <%--User ID : <input type="text" readonly="readonly" name="userid"--%>
    <%--value="<c:out value="${user.userid}" />" /> <br />--%>
    <%--First Name : <input--%>
    <%--type="text" name="firstName"--%>
    <%--value="<c:out value="${user.firstName}" />" /> <br />--%>
    <%--Last Name : <input--%>
    <%--type="text" name="lastName"--%>
    <%--value="<c:out value="${user.lastName}" />" /> <br />--%>
    <%--DOB : <input--%>
    <%--type="text" name="dob"--%>
    <%--value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br />--%>
    <%--Email : <input type="text" name="email"--%>
    <%--value="<c:out value="${user.email}" />" /> <br /> <input--%>
    <%--type="submit" value="Submit" />--%>
    <%--</form>--%>
    <%--</div>--%>

    <page:footer/>
    <page:js/>


</body>
</html>
