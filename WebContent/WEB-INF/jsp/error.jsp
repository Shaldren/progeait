<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" isErrorPage="true"%>

<div class="alert alert-danger mt-5">
	${requestScope['javax.servlet.error.exception'].message}
</div>