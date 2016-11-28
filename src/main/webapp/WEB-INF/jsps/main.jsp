<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.11.16
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>The best ever company</title>

    <page:css/>

</head>
<body>

<page:header department="${data}"/>
<div class="container">
    <p style="color: red">${message}</p>
</div>
<page:carousel/>
<hr>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?</p>
</div>

<page:footer/>
<page:js/>
</body>
</html>