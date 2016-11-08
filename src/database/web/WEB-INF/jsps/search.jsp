<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>

<html>
<head>
    <title>Result of search</title>
    <page:css></page:css>
</head>
<body>

<page:header department="${data}"/>

<div class="container">

    <h1 style="text-align: center">Result of search by "${search}"</h1>
    <hr>


    <table class="table table-striped">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Position</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td> ${employee.firstName}</td>
                <td> ${employee.lastName}</td>
                <td> ${employee.position} </td>
                <td> <a <c:if test="${employee.department.depId == 1}">style="color: black; pointer-events: none; cursor: default;" </c:if> href="/dep?action=get&pk=${employee.department.depId}" >${employee.department}</a></td>
                <td>
                    <a href="/employee?action=get&pk=${employee.emId}" class="btn btn-default btn-sm" role="button">Detail</a>
                    <a href="/employee?action=edit&pk=${employee.emId}" class="btn btn-info btn-sm">
                        <span class="glyphicon glyphicon-pencil"></span> Edit
                    </a>
                    <a href="/employee?action=delete&pk=${employee.emId}" class="btn btn-danger btn-sm">
                        <span class="glyphicon glyphicon-remove"></span> Remove
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</div>

<page:footer/>
<page:js/>

</body>
</html>
