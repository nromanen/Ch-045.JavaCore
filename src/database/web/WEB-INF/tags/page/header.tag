<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="department" type="java.util.ArrayList<com.ariezz.model.Department>" %>


<!-- Header -->
<nav class="navbar navbar-default navbar-inverse" style="border-radius:0px !important; margin-bottom:0px;">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">THE BEST EVER COMPANY</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employees<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/employee?action=getAll">All employees</a></li>
                        <li><a href="/employee?action=new">Add new</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Departments<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="rr" items="${department}">
                            <li><a href="/dep?action=get&pk=${rr.depId}">${rr.title}</a></li>
                        </c:forEach>
                        <li role="separator" class="divider"></li>
                        <li><a href="/dep?action=new">Add new</a></li>

                    </ul>
                </li>
                <%--<li><a href="#">News</a></li>--%>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" role="search" method="get" action="/search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search employee" name="search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Account</a></li>--%>
                        <%--<li><a href="#">Cart</a></li>--%>
                        <%--<li><a href="#">Delivery</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">Exit</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="/admin/">Admin</a></li>--%>

                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- End Header -->
