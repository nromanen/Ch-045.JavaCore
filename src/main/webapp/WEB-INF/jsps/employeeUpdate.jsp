
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
    <h2>${message} <c:if test="${link != 'newEmployee'}"> ${employee.firstName} ${employee.lastName}</c:if></h2>
    <form method="post" action="/${link}">

        <input type="number" hidden name="pk" value="${employee.emId}">
        <div class="form-group col-md-8">
            <label for="firstName">Firstname:</label>
            <c:if test="${errors.fNameError != null}"><page:error title="${errors.fNameError}"/></c:if>
            <input type="text" class="form-control" name="firstName" value="${employee.firstName}" id="firstName">
            <span class="error text-danger" id="firstNameError"></span>
        </div>
        <div class="form-group col-md-8">
            <label for="lastName">Lastname:</label>
            <c:if test="${errors.lNameError != null}"><page:error title="${errors.lNameError}"/></c:if>
            <input type="text" class="form-control" name="lastName" value="${employee.lastName}" id="lastName">
            <span class="error text-danger" id="lastNameError"></span>

        </div>
        <div class="form-group col-md-8">
            <label for="bDay">B-day:</label>
            <c:if test="${errors.bDayError != null}"><page:error title="${errors.bDayError}"/></c:if>
            <input type="date" class="form-control" name="bDay" value="${employee.bDay}" id="bDay">
            <span class="error text-danger" id="bDayError"></span>
        </div>
        <div class="form-group col-md-8">
            <label for="ssn">SSN:</label>
            <c:if test="${errors.ssnError != null}"><page:error title="${errors.ssnError}"/></c:if>
            <input type="number" class="form-control" name="ssn" value="${employee.SSN}" id="ssn">
            <span class="error text-danger" id="ssnError"></span>
        </div>
        <div class="form-group col-md-8">
            <label for="email">E-mail:</label>
            <c:if test="${errors.emailError != null}"><page:error title="${errors.emailError}"/></c:if>
            <input type="email" class="form-control" name="email" value="${employee.email}" id="email">
            <span class="error text-danger" id="emailError"></span>
        </div>
        <div class="form-group col-md-8">
            <label for="rate">Rate:</label>
            <c:if test="${errors.rateError != null}"><page:error title="${errors.rateError}"/></c:if>
            <input type="number" class="form-control" name="rate" value="${employee.rate}" id="rate">
            <span class="error text-danger" id="rateError"></span>
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
        <div class="form-group col-md-8">
            <label for="characteristic">Characteristic:</label>
            <c:if test="${errors.charactError != null}"><page:error title="${errors.charactError}"/></c:if>
            <textarea  class="form-control" name="char" id="characteristic">${employee.characteristic}</textarea>
            <span class="error text-danger" id="characteristicError"></span>
        </div>
        <div class="col-md-12">
            <input type="submit" name="submit" value="Submit" class="btn btn-info " disabled="disabled">
        </div>
    </form>

    <page:footer/>
    <page:js/>
    <script src = "../../assets/js/employeeFormValidator.js"></script>


</body>
</html>
