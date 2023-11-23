<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="email" path="email" placeholder="Email"/><form:errors path="email" />
        </div>
        <div class="form-group">
            <form:input path="password" placeholder="Hasło" minlength="4"/><form:errors path="password" />
        </div>
        <div class="form-group">
            <input id="password2" type="password" name="password2" placeholder="Powtórz hasło"/>
            ${msg}
        </div>
        <div class="form-group form-group--buttons">
            <a href="login.jsp" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<footer>
    <div id="contact" class="contact">
<jsp:include page="fragments/footer.jsp"/>



<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
