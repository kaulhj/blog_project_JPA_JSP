<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<%--
  Created by IntelliJ IDEA.
  User: TFX5470H
  Date: 2022-10-25
  Time: 오전 6:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body style="background-color: #e5eada;">

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/">게시판</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">


        <c:choose>
            <c:when test="${empty principal}">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
                    <li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a></li>
                    <li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
                    <li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
                </ul>
            </c:otherwise>
        </c:choose>

    </div>
</nav>
<br>