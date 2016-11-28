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


    <h2>The best ever company</h2>
    <h3>221B Baker Street</h3>
    <h3>London</h3>
    <h3>UK</h3>
</div>

<page:footer/>
<page:js/>

</body>
</html>
