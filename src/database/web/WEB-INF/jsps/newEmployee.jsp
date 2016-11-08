
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>


<html>
<head>
    <title>Add new Employee</title>
    <page:css></page:css>
</head>
<body>
<page:header department="${data}"/>


<div class="container">
    <hr>
    <h2>Add new Employee</h2>
    <form method="post" action="/employee?action=new">

        <div class="form-group col-md-8">
            <label for="firstName">Firstname:</label>
            <input type="text" class="form-control" name="firstName" placeholder="First Name" id="firstName">
        </div>
        <div class="form-group col-md-8">
            <label for="lastName">Lastname:</label>
            <input type="text" class="form-control" name="lastName" placeholder="Last Name" id="lastName">
        </div>
        <div class="form-group col-md-8">
            <label for="bDay">B-day:</label>
            <input type="date" class="form-control" name="bDay" placeholder="yyyy-mm-dd" id="bDay">
        </div>
        <div class="form-group col-md-8">
            <label for="ssn">SSN:</label>
            <input type="number" class="form-control" name="ssn" placeholder="SSN" id="ssn">
        </div>
        <div class="form-group col-md-8">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" name="email" placeholder="E-maile" id="email">
        </div>
        <div class="form-group col-md-8">
            <label for="char">Characteristic:</label>
            <textarea  class="form-control" name="char" id="char" placeholder="Characteristic of new employee"></textarea>
        </div>
        <div class="form-group col-md-8">
            <label for="rate">Rate:</label>
            <input type="number" class="form-control" name="rate" placeholder="Rate" id="rate">
        </div>
        <div class="form-group col-md-8">
            <label for="position" class="control-label">Position</label>
            <select class="form-control" name="position" id="position">
                <c:forEach var="pos" items="${positions}">
                    <option>${pos}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-8">
            <label for="department" class="control-label">Department</label>
            <select class="form-control" name="department" id="department">
                <c:forEach var="dep" items="${data}">
                    <option>${dep.title}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-12">
            <input type="submit" name="submit" value="Submit" class="btn btn-info ">
        </div>

    </form>


    <page:footer/>
    <page:js/>


</body>
</html>
