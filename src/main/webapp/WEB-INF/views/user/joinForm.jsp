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
    <form action="/user/join"method="POST">
        <div class="form-group">
            <label for="username">username</label>
            <input type="username" class="form-control" placeholder="Enter Username" id="username">
        </div>


        <div class="form-group">
            <label for="password">password</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Enter Email" id="email">
        </div>





    </form>
    <button id="btn-save" class="btn btn-primary">회원가입 완료</button>

</div>

<script src="/js/user.js"></script>



<%@ include file="../layout/footer.jsp" %>


