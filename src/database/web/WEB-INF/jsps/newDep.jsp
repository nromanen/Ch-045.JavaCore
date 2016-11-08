
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
    <h2>Add new Department</h2>
    <form method="post" action="/dep?action=new">

        <div class="form-group col-md-8">
            <label for="title">Title:</label>
            <input type="text" class="form-control" name="title" placeholder="Title" id="title">
        </div>
        <div class="form-group col-md-8">
            <label for="disposition">Disposition:</label>
            <input type="text" class="form-control" name="disposition" placeholder="Disposition" id="disposition">
        </div>
        <div class="form-group col-md-8">
            <label for="description">Description:</label>
            <textarea  class="form-control" name="description" id="description" placeholder="Description"></textarea>
        </div>

        <div class="form-group col-md-8">
            <label>Select employees:</label>
            <c:forEach var="e" items="${employeeList}">
                <p><input type="checkbox" name="emp" value="${e.emId}" /> ${e.firstName} ${e.lastName} - ${e.position}</p>
            </c:forEach>
        </div>

        <div class="col-md-12">
            <input type="submit" name="submit" value="Submit" class="btn btn-info ">
        </div>

    </form>


    <page:footer/>
    <page:js/>


</body>
</html>
