<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	
	<h3>자동 바인딩된 어트리뷰트는 클래스 이름 소문자</h3>
	
	<p>${department}</p>
	${department.department_id}
	${department.department_name}
	${department.manager_id}
	${department.location_id}
</body>
</html>