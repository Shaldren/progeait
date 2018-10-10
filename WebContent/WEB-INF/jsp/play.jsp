<%@ page language="java"  errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><fmt:message key = "title.welcome" /></title>

<jsp:include page="/WEB-INF/jsp/head.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>

</head>
<body>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>
	
	<div class="container">
		
		<h1 class="mt-5"><fmt:message key="title.welcome" /></h1>
		<div class="col-md-12">
			
			<c:if test="${requestScope['javax.servlet.error.message'] != null}">
				<div class="alert alert-danger mt-5">
				  ${requestScope['javax.servlet.error.message']}
				</div>
			</c:if>

			<form action="calculateResult" method="post" class="mt-5">
					<div class="form-group">
						<label for="choice">
							<fmt:message key = "label.choice" />
						</label> 
						<small id="choiceHelp" class="form-text text-muted">
							<fmt:message key = "label.choice.small" />
						</small>
					</div>

					<div class="custom-control custom-radio">
						<input type="radio" class="custom-control-input" id="choiceCHI"
							name="choice" value="CHI" checked> <label
							class="custom-control-label" for="choiceCHI">CHI</label>
					</div>

					<div class="custom-control custom-radio">
						<input type="radio" class="custom-control-input" id="choiceFOU"
							name="choice" value="FOU"> <label
							class="custom-control-label" for="choiceFOU">FOU</label>
					</div>

					<div class="custom-control custom-radio">
						<input type="radio" class="custom-control-input" id="choiceMI"
							name="choice" value="MI"> <label
							class="custom-control-label" for="choiceMI">MI</label>
					</div>
					
				<div class="row mt-5">
					<button type="submit" class="btn btn-success"><fmt:message key = "btn.validate" /></button>
				</div>


			</form>


		</div>
	</div>	
</body>
</html>