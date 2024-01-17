<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${replies[1].board_id}번 게시글 댓글창</h3>
		
	<c:forEach items="${replies}" var="reply">
		<div>
			[${reply.reply_writer.trim()}]
			${reply.reply_content}
			<span>${reply.reply_date}</span>
		</div>
	</c:forEach>
	
</body>
</html>