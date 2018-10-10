<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Technical Error</title>

<jsp:include page="/WEB-INF/jsp/head.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>

</head>
<body>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>
	
	<div class="container center">

		<div class="col-md-12">
		
			<h1 class="mt-5">
				<fmt:message key = "title.error.technical" />
			</h1>
			
			<c:if test="${requestScope['javax.servlet.error.message'] != null}">
				<div class="alert alert-danger mt-5">
				  ${requestScope['javax.servlet.error.message']}
				</div>
			</c:if>
			
			<a href="${pageContext.request.contextPath}/welcome" class="btn btn-primary mt-5">
				<fmt:message key = "btn.back"/>
			</a>
		</div>
	</div>	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>