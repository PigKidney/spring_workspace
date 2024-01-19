<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/js/emp.js" var="empJS"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz</title>
</head>
<body>
	<div id="chosen1"></div>
	
	<button id="btn1">선택된 용사</button>
	
	<script src="${empJS}"></script>
</body>
</html>