<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container">
		  <a class="navbar-brand"  href='${param.contextPath}/play' >Chifoumi</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div  id="navbarSupportedContent">
		  		<a href="${param.contextPath}/play?langage=en" >
		    		<img src="${param.contextPath}/images/flag-en.png" height="48px" width="48px" style="float: right; margin-left: 5px"/>
		    	</a>
		    	
		    	<a href="${param.contextPath}/play?langage=fr" >
		    		<img src="${param.contextPath}/images/flag-fr.png" height="48px" width="48px" style="float: right"/>
		    	</a>
		    	
		  </div>
	  </div>
	</nav>
	
	<style>

	    img {
	    	cursor: pointer;
	    }
		.center {
			float: none; 
			margin-left: auto;
			margin-right: auto;
		}
		
		.text-center {
			text-align: center;
		}
		
		.page-footer {
			position: absolute;
			bottom: 0;
			text-align: center;
			width: 100%;
		}
	</style>