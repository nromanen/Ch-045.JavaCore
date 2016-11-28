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
    <title>${dep.title}</title>
    <page:css></page:css>
</head>
<body>

<page:header department="${data}"/>

<div class="container">

    <h1 style="text-align: center">${dep.title}</h1>
    <hr>
    <a href="/departmentUpdate?pk=${dep.depId}" class="btn btn-info btn-sm" methods="p">
        <span class="glyphicon glyphicon-pencil"></span> Edit department
    </a>
    <br><br>
    <form method="post" action="/department">
    <input type="number" hidden name="pk" value="${dep.depId}">

    <input type="submit" name="submit" value="Remove department" class="btn btn-danger btn-sm">



    </form>

    <%--<a href="/dep?action=delete&pk=${dep.depId}" class="btn btn-danger btn-sm">--%>
        <%--<span class="glyphicon glyphicon-remove"></span> Remove department--%>
    <%--</a>--%>
    <hr>
    <h3>Disposition</h3>
    <p> ${dep.disposition}</p>
    <h3>Description</h3>
    <p> ${dep.description}</p>
    <h3>Employees</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Position</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td> ${employee.firstName}</td>
                <td> ${employee.lastName}</td>
                <td> ${employee.position} </td>
                <td>

                    <a href="/employee?pk=${employee.emId}" class="btn btn-default btn-sm" role="button">Detail</a>
                </td>
                <td>
                    <a href="/employeeUpdate?pk=${employee.emId}" class="btn btn-info btn-sm">
                        <span class="glyphicon glyphicon-pencil"></span> Edit
                    </a>
                </td>
                <td>

                    <form method="post" action="/employee">
                        <input type="number" hidden name="pk" value="${employee.emId}">

                        <input type="submit" name="submit" value="Remove" class="btn btn-danger btn-sm">


                    </form>


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
