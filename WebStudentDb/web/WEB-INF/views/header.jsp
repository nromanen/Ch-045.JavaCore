<%--@elvariable id="loginedUser" type="net.students.model.UserAccount"--%>
<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 04.11.2016
  Time: 0:48
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h1>Student Personnel Department</h1>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">
        <!-- User store in session with attribute: loginedUser -->
        Hello <b>${loginedUser.userName}</b>
        <br/>
        Search <label><input type="search"  >  </label>


    </div>

</div>

