<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key = "title.result" /></title>

<jsp:include page="/WEB-INF/jsp/head.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>

</head>
<body>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>

	<div class="container">

		<h1 class="mt-5"><fmt:message key = "title.result" /></h1>
		
		<div class="col-md-12 mt-5">
		
			<h3><fmt:message key = "subtitle.result.playerChoice" />:</h3>
			${result.playerChoice}

			<h3 class="mt-5"><fmt:message key = "subtitle.result.serverChoice" />:</h3>
			${result.serverChoice}

			<h3 class="mt-5"><fmt:message key = "subtitle.result.result" />:</h3>
			<c:choose>
				<c:when test="${result.score eq 'WIN'}"><fmt:message key = "label.result.win" /></c:when>
				<c:when test="${result.score eq 'LOOSE'}"><fmt:message key = "label.result.loose" /></c:when>
				<c:when test="${result.score eq 'EQUALITY'}"><fmt:message key = "label.result.equality" /></c:when>
			</c:choose>
		</div>
		
		<div class="col-md-12 mt-5">
			<a href="play" class="btn btn-success"><fmt:message key = "btn.result.replay" /></a>
		</div>
	</div>
</body>
</html>