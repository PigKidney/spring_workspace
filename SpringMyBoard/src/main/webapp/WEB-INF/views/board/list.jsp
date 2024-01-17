<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<c:url value="/assets/board/css/list.css" var="listCSS"/> 
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<link rel="stylesheet" href="${listCSS}">
</head>
<body>
	
	<h1>목록</h1>
	
	<c:if test="${!empty boards}">
		<div class="board-list">
			<c:forEach items="${boards}" var="board">
				<c:set value="${board.board_id}" var="bid"></c:set>
				<div class="board-id">${board.board_id}</div>
				<div class="board_title">
					<a href="./detail?board_id=${bid}">${board.board_title}</a></div>
				<div class="board_writer">${board.board_writer}</div>
				<div class="write_date">${board.write_date}</div>
				<div class="view_count">${board.view_count}</div>
			</c:forEach>
		</div>
	</c:if>
	
	<a href="./write" style="color:white;">글쓰기</a>

</body>
</html>