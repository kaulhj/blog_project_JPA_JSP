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
        <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
        <c:if test="${board.user.id == principal.user.id}">
            <button id="btn-delete" class="btn btn-danger">삭제</button>
            <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
        </c:if>
        <br /><br />
        <div>
            글번호 : <span id="id"><i>${board.id}</i></span>
            작성자 : <span><i>${board.user.username}</i></span>
        </div>
        <br />
            <h3>${board.title}</h3>
        <hr />
            <div>
                ${board.content}
            </div>
        <hr />

    <button id="btn-board-save" class="btn btn-primary"> 글쓰기완료</button>
</div>



<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>


