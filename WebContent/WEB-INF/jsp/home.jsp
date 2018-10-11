<%@ page language="java"  errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Accueil QCM</title>

<jsp:include page="head.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>

</head>
<body>

<jsp:include page="header.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>
	
	<div class="container">
		
		<h1 class="mt-5">Accueil QCM</h1>
		<div class="col-md-12">
		Bienvenue sur l'application QCM

		</div>
	</div>	
</body>
</html>