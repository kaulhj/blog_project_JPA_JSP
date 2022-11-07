<%--
  Created by IntelliJ IDEA.
  User: TFX5470H
  Date: 2022-10-25
  Time: 오전 6:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="username">username</label>
            <input type=test name="username" class="form-control" placeholder="Enter Username" id="username">
        </div>

        <div class="form-group">
            <label for="password">password</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <button id="btn-login" class="btn btn-primary">로그인 </button>
    </form>


</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>


