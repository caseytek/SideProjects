<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
   <c:url value="/css/css.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="header">
<h1 id="header-title"> Doggo Matchmaker 3000</h1>

<div id = "header-photos">
<c:url value="/img/puppies.jpg" var="puppiesImg" />			
<a href="<c:url value = "/"/>"> <img src="${puppiesImg}" /> </a>
<c:url value="/img/puppy.jpg" var="puppyImg" />			
<a href="<c:url value = "/"/>"> <img src="${puppyImg}" /> </a>
<c:url value="/img/corgi.jpg" var="corgiImg" />			
<a href="<c:url value = "/"/>"> <img src="${corgiImg}" /> </a>
</div>

</div>


</body>
</html>