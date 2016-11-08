<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    List<Integer> num = new ArrayList<>();

    for (int i = 1; i <= 100; i++) {
        num.add(i*i);
    }
%>

<c:set var="listNum" value="<%=num%>"/>
<c:set var="text" value="sjflnsdljv jkvs;dkc; mxs jsdjlsk "/>


<html>
<head>
    <title>Test</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<h1>Test JSP</h1>

<%--<p>${param.parame}</p>--%>
<%--<p>${param.city}</p>--%>
<%--<p>${param.code}</p>--%>


<%--${requestScope.person}--%>

<%--<c:out value="${person.name}"/>--%>

<%--<p>${listNum}</p>--%>


<%--<c:forEach var="n" items="${listNum}">--%>
    <%--<c:if test="${n % 21 ==0}">--%>
        <%--${n}<br>--%>
    <%--</c:if>--%>
<%--</c:forEach>--%>


<%--<c:forEach var="n" items="${listNum}">--%>
    <%--<c:choose>--%>
        <%--<c:when test="${n%2 == 0}">--%>
            <%--${n}--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<hr>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
<%--</c:forEach>--%>

<%--${fn:length(listNum)}<br>--%>
<%--${fn:toUpperCase(text)}--%>


<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    <TR>
        <TH>ID</TH>
        <TH>Title</TH>
        <TH>Disposition</TH>
        <TH>Description</TH>
    </TR>
    <c:forEach var="rr" items="${data}">
        <TR>
            <TD>${rr.depId}</TD>
            <TD>${rr.title}</TD>
            <TD>${rr.disposition}</TD>
            <TD>${rr.description}</TD>
        </TR>
    </c:forEach>
</TABLE>

<hr>

</div>

</body>
</html>
