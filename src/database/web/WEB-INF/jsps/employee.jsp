<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.11.16
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>

<html>
<head>
    <title>${employee.firstName} ${employee.lastName}</title>
    <page:css/>
</head>
<body>

<page:header department="${data}"/>

<div class="container">

    <h1 style="text-align: center">${employee.firstName} ${employee.lastName}</h1>
    <hr>
    <h3>Position:</h3>
    <p> ${employee.position}</p>
    <h3>Department:</h3>
    <p> ${employee.department}</p>
    <h3>Rate: </h3>
    <p>$ ${employee.rate}</p>
    <h3>E-mail:</h3>
    <p>${employee.email}</p>
    <h3>Birth Day: </h3>
    <p>${employee.bDay}</p>
    <h3>Characteristic</h3>
    <p>${employee.characteristic}</p>
    <h3>SSN: </h3>
    <p>${employee.SSN}</p>


    <p>
        <a href="/employee?action=edit&pk=${employee.emId}" class="btn btn-info btn-sm">
            <span class="glyphicon glyphicon-pencil"></span> Edit
            </a>
            <a href="/employee?action=delete&pk=${employee.emId}" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-remove"></span> Remove
            </a>

    </p>
</div>


<page:footer/>
<page:js/>

</body>
</html>
