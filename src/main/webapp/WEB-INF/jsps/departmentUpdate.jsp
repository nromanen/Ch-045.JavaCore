
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>


<html>
<head>
    <title>Add new Department</title>
    <page:css></page:css>
</head>
<body>
<page:header department="${data}"/>


<div class="container">
    <hr>
    <h2>${message} ${dep.title}</h2>
    <form method="post" action="/${link}">

        <input type="number" hidden name="pk" value="${dep.depId}">



        <div class="form-group col-md-7">
            <label for="title">Title:</label>
            <c:if test="${errors.titleError != null}"><page:error title="${errors.titleError}"/></c:if>
            <input type="text" class="form-control" name="title" value="${dep.title}" id="title">
            <span class="error text-danger" id="titleError"></span>

        </div>
        <div class="form-group col-md-7">
            <label for="disposition">Disposition:</label>
            <c:if test="${errors.dispositionError != null}"><page:error title="${errors.dispositionError}"/></c:if>
            <input type="text" class="form-control" name="disposition" value="${dep.disposition}" id="disposition">
            <span class="error text-danger" id="dispositionError"></span>
        </div>
        <div class="form-group col-md-7">
            <label for="description">Description:</label>
            <c:if test="${errors.descriptionError != null}"><page:error title="${errors.descriptionError}"/></c:if>
            <textarea  class="form-control" name="description" id="description">${dep.description}</textarea>
            <span class="error text-danger" id="descriptionError"></span>
        </div>

        <div class="form-group col-md-7">
            <label>Select employees:</label>
            <c:forEach var="e" items="${employeeList}">
                <p><input type="checkbox" <c:if test="${e.department.depId == dep.depId}">checked</c:if>  name="emp" value="${e.emId}"/> ${e.firstName} ${e.lastName} - ${e.position}</p>
            </c:forEach>
        </div>

        <div class="col-md-12">
            <input type="submit" name="submit" value="Submit" class="btn btn-info " id="submitDepartment" disabled="disabled">
        </div>

    </form>


    <page:footer/>
    <page:js/>
    <script src = "../../assets/js/departmentFormValidator.js"></script>



</body>
</html>
