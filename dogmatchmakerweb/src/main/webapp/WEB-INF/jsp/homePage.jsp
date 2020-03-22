<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<section id ="main">
<h1> Looking to add a new furry member to your family, but don't know where to start? Our Doggo Matchmaker 3000 is here to save the day! It's smart technology and state-of-the-art formula will pair you with your doggy soulmate. So, don't waste any more time and find the dog of your dreams today!   </h1>
<div id="quiz-button" class="zoom"><a href ="<c:url value="/quiz"/>"> START THE QUIZ </a></div>
</section>
</body>
</html>