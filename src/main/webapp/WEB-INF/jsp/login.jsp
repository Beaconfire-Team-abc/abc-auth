<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/api/auth/css/login.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
    <div class="wrapper">
        <div class="signin">
            <form class="form-signin" method="POST" action="/auth/login?redirect=${param.redirect}">
                <h2 class="form-signin-heading">Please login</h2>
                <div style="color: red">${error}</div>
                <div class="group">
                    <label calss="label" for="exampleInputEmail1">Email address</label>
                    <input name="username" type="email" class="input" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"><br>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="group">
                    <label calss="label" for="exampleInputPassword1">Password</label>
                    <input name="password" type="password" class="input" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="group">
                <button type="submit" class="button">Sign In</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
