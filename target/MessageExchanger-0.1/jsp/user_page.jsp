<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<form method="post" action="/logout" style="float:right">
    <button type="submit" class="btn btn-default">Logout</button>
</form>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript">
        var jq = jQuery.noConflict();
    </script>
</head>
<style>
    <%@include file='/css/styles.css' %>
    <%@include file='/css/bootstrap.min.css'%>
</style>
<div style="font-size: 32px" style="font-family: Impact">
    Welcome ${user.name} ${user.lastName}!
</div>

<body onload="hideOrDisplay('toHide', ${cookie['userCookie'].value})">
<form id="formPost" action="/user_page/${user.id}" method="post" class="toHide">
    <textarea class="form-control" id="doPost" name="post" rows="3"></textarea>
    <input type="submit" value="Post It"/>
</form>
<div id="postDiv">
    <c:forEach items="${posts}" var="post">
            <span>
                <div class="roundedForTime">${post.postHeader}</div>
                <div class="rounded">${post.message}</div>
                <form action="/user_page/${user.id}/doLike" method="post">
                    <input id="postId" type="hidden" name="postId" value="${post.id}">
                    <input id="userId" type="hidden" name="userId" value="${user.id}">
                    <input id="likeButton${post.id}" type="submit" value="${post.amountOfLikes}">
                </form>
                <form action="/user_page/${user.id}/delete" method="post" class="toHide">
                    <input id="id" type="hidden" name="id" value="${post.id}">
                    <input id="delete${post.id}" type="submit" value="delete">
                </form>
            </span>
    </c:forEach>
</div>
<script>
    function hideOrDisplay(classId, guestId) {
        let name = "." + classId;
        if (guestId !== ${user.id}) {
            jq(name).hide();
            jq(name).attr("disabled", true);
        } else {
            jq(name).show();
            jq(name).attr("disabled", false);
        }
    }
</script>
</body>
<%--<script type="text/javascript">--%>
<%--var id = jq("#postId").val();--%>
<%--function add() {--%>
<%--jq(document).ready(function() {--%>
<%--jq.post("/user_page/${user.id}/doLike",--%>
<%--{--%>
<%--postId:  jq("#postId").val(),--%>
<%--userId:  jq("#userId").val()--%>
<%--},--%>
<%--function(data){--%>
<%--jq("#likeButton" + id).--%>
<%--});--%>
<%--});--%>
<%--}--%>
<%--</script>--%>
</html>