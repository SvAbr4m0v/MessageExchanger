<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    <title>
        Please Login!
    </title>
</head>
<style>
    <%@include file='/css/styles.css' %>
    <%@include file='/css/bootstrap.min.css' %>
</style>
<div>
    <div>Hello, Please Sign In</div>
    <c:if test="${error}">
        <div class="alert alert-danger" role="alert">
            Login or Password are incorrect!
        </div>
    </c:if>
    <form class="form-inline" method="post" action="/login">
        <div class="form-group">
            <label class="sr-only" for="username">Email address</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Login">
        </div>
        <div class="form-group">
            <label class="sr-only" for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" id="remember-me" name="remember-me"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-default">Sign in</button>
        <a href="/signup">
            <button type="button" class="btn btn-default">Sign Up!</button>
        </a>
    </form>
</div>
</html>