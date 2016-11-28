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
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${employee.firstName} ${employee.lastName}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://waysandhow.com/wp-content/uploads/2015/11/avatar-300x300.png" class="img-circle img-responsive"> </div>

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Department:</td>
                                    <td>${employee.department}</td>
                                </tr>
                                <tr>
                                    <td>Position</td>
                                    <td>${employee.position}</td>
                                </tr>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td>${employee.bDay}</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>E-mail</td>
                                    <td><a href="mailto:${employee.email}">${employee.email}</a></td>
                                </tr>
                                <tr>
                                    <td>Rate</td>
                                    <td>$ ${employee.rate}</td>
                                </tr>
                                <tr>
                                    <td>SSN</td>
                                    <td>${employee.SSN}</td>
                                </tr>
                                <td>Characteristic</td>
                                <td>${employee.characteristic}
                                </td>

                                </tr>

                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a href="/employeeUpdate?pk=${employee.emId}" class="btn btn-info btn-sm">
                        <span class="glyphicon glyphicon-pencil"></span> Edit
                    </a>
                    <span class="pull-right">

                        <form method="post" action="/employee">
                            <input type="number" hidden name="pk" value="${employee.emId}">

                            <input type="submit" name="submit" value="Remove" class="btn btn-danger btn-sm">

                        </form>

                    </span>
                </div>

            </div>
        </div>
    </div>
</div>

<page:footer/>
<page:js/>

</body>
</html>
