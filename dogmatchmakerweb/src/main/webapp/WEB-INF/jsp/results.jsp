<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matchmaker 3000</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<section id="main">
<div id="dream-dog">
<h1 id="title"> You got a <c:out value="${dreamDog.name}"/></h1>
<c:url value="/img/${dreamDog.dogType}.jpg" var="dreamDogImg" />			
<a href="<c:url value = "/"/>"> <img src="${dreamDogImg}" /> </a>
</div>
</section>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/Footer.jsp"/>
