<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Locale Example</title>
<link href="${pageContext.request.contextPath }/assets/css/index.css" type="text/css" rel="stylesheet">
<script>
window.addEventListener("load", function(){
	console.log(document.body);
	anchors = document.querySelectorAll('#languages a');
	
	anchors.forEach(function(el){
		el.addEventListener("click", function(event){
			event.preventDefault();
			document.cookie = 
				"lang=" + this.getAttribute('data-lang') + ";" +
				"path=" + "${pageContext.request.contextPath }" + ";" + 
				"max-age=" + (30*24*60*60);
				
			location.reload();
		})
	});
});
</script>
</head>
<body>
	<h1><spring:message code="index.title"/></h1>
	<div id="languages">
		<c:choose>
			<c:when test="${lang == 'en' }">
				<a href="" data-lang="ko">KO</a><a href="" class="active" data-lang="en">EN</a>
			</c:when>
			<c:otherwise>
				<a href="" data-lang="ko" class="active">KO</a><a href="" data-lang="en">EN</a>
			</c:otherwise>
			</c:choose>
	</div>
</body>
</html>
