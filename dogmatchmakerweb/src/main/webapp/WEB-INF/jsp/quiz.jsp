<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matchmaker 3000</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/common/header.jsp" />
	<section id="main">

		<div id="question">


			<c:choose>
				<c:when test="${(question.questionKey).equals('hair')}">
					<h2> <c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="short" checked /> 
						<label for="choice1"><c:out value="${question.choice1}" /></label> 
						<input type="radio" name="response" id="choice2" value="medium" />
						 <label for="choice2"><c:out value="${question.choice2}" /></label> 
						 <input type="radio" name="response" id="choice3" value="long" /> 
						 <label for="choice3"><c:out value="${question.choice3}" /></label>
						<input class="form-submit-button zoom" type="submit"
							value="Next Question" />
					</form>
				</c:when>

				<c:when test="${(question.questionKey).equals('shedding') || (question.questionKey).equals('actlvl') }">
					<h2><c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="low" checked /> 
						<label for="choice1"><c:out value="${question.choice1}" /></label> 
						<input type="radio" name="response" id="choice2" value="medium" /> 
						<label for="choice2"><c:out value="${question.choice2}" /></label> 
						<input type="radio" name="response" id="choice3" value="high" /> 
						<label for="choice3"><c:out value="${question.choice3}" /></label> 
						<input class="form-submit-button zoom" type="submit" value="Next Question" />
					</form>
				</c:when>


				<c:when test="${(question.questionKey).equals('size')}">
					<h2><c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="small"
							checked /> <label for="choice1"><c:out
								value="${question.choice1}" /></label> <input type="radio"
							name="response" id="choice2" value="medium" /> <label
							for="choice2"><c:out value="${question.choice2}" /></label> <input
							type="radio" name="response" id="choice3" value="large" /> <label
							for="choice3"><c:out value="${question.choice3}" /></label> <br>
						<input type="submit" class="form-submit-button zoom"
							value="Next Question" />
					</form>
				</c:when>
				
				<c:when test="${(question.questionKey).equals('allergenic')}">
					<h2><c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="false" checked />
						 <label for="choice1"><c:out value="${question.choice1}" /></label>
						 <input type="radio" name="response" id="choice2" value="false" /> 
						 <label for="choice2"><c:out value="${question.choice2}" /></label>
						  <input type="radio" name="response" id="choice3" value="false" />
						   <label for="choice3"><c:out value="${question.choice3}" /></label> <br>
						<input type="submit" class="form-submit-button zoom" value="Next Question" />
					</form>
				</c:when>

				<c:otherwise>
					<h2> <c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="false"
							checked /> <label for="choice1"><c:out
								value="${question.choice1}" /></label> <input type="radio"
							name="response" id="choice2" value="true" /> <label for="choice2"><c:out
								value="${question.choice2}" /></label> <br>
						<c:choose>
							<c:when test="${questionNumber == 9 }">
								<input class="form-submit-button zoom" type="submit"
									value="Get Results" />
							</c:when>
							<c:otherwise>
								<input class="form-submit-button zoom" type="submit"
									value="Next Question" />
							</c:otherwise>
						</c:choose>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</body>
</html>

<c:import url="/WEB-INF/jsp/common/Footer.jsp"/>
