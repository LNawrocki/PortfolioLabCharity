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
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="fragments/admin-header.jsp"/>

<section class="login-page">
    <h2>Edytuj instytucję</h2>
    <form:form method="post">
            <div class="edit">
                <input type="text" name="name" value="${institution.name}" width="150" />
            </div>
            <div class="edit">
                <input name="description" value="${institution.description}"/>
                <input type="text" name="id" value="${institution.id}" hidden="hidden">
            </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zatwierdź</button>
        </div>
    </form:form>
</section>
<footer>
    <div id="contact" class="contact">
<jsp:include page="fragments/footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
