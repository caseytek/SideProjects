<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/common/header.jsp" />
	<section id="main">

		<div id="question">


			<c:choose>
				<c:when test="${questionNumber == 0}">
					<h2> <c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="short"
							checked /> <label for="choice1"><c:out
								value="${question.choice1}" /></label> <input type="radio"
							name="response" id="choice2" value="medium" /> <label
							for="choice2"><c:out value="${question.choice2}" /></label> <input
							type="radio" name="response" id="choice3" value="long" /> <label
							for="choice3"><c:out value="${question.choice3}" /></label> <br>
						<input class="form-submit-button" type="submit"
							value="Next Question" />
					</form>
				</c:when>

				<c:when test="${questionNumber == 1 || questionNumber == 3 }">
					<h2><c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="low"
							checked /> <label for="choice1"><c:out
								value="${question.choice1}" /></label> <input type="radio"
							name="response" id="choice2" value="medium" /> <label
							for="choice2"><c:out value="${question.choice2}" /></label> <input
							type="radio" name="response" id="choice3" value="high" /> <label
							for="choice3"><c:out value="${question.choice3}" /></label> <br>
						<input class="form-submit-button" type="submit"
							value="Next Question" />
					</form>
				</c:when>


				<c:when test="${questionNumber == 2}">
					<h2><c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="small"
							checked /> <label for="choice1"><c:out
								value="${question.choice1}" /></label> <input type="radio"
							name="response" id="choice2" value="medium" /> <label
							for="choice2"><c:out value="${question.choice2}" /></label> <input
							type="radio" name="response" id="choice3" value="large" /> <label
							for="choice3"><c:out value="${question.choice3}" /></label> <br>
						<input type="submit" class="form-submit-button"
							value="Next Question" />
					</form>
				</c:when>

				<c:when test="${questionNumber > 3}">
					<h2> <c:out value="${question.question}" /> </h2>
					<form action="<c:url value="/processQuestion"/>" method="POST">
						<input type="radio" name="response" id="choice1" value="false"
							checked /> <label for="choice1"><c:out
								value="${question.choice1}" /></label> <input type="radio"
							name="response" id="choice2" value="true" /> <label for="choice2"><c:out
								value="${question.choice2}" /></label> <br>
						<c:choose>
							<c:when test="${questionNumber == 9 }">
								<input class="form-submit-button" type="submit"
									value="Get Results" />
							</c:when>
							<c:otherwise>
								<input class="form-submit-button" type="submit"
									value="Next Question" />
							</c:otherwise>
						</c:choose>
					</form>
				</c:when>
			</c:choose>
		</div>
	</section>
</body>
</html>