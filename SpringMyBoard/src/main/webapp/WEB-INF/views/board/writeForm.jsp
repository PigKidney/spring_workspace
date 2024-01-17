<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 	<form action="./write" method="post" id="writeForm">
		글 제목 : <input type="text" name="board_title" /> <br> 
		글쓴이 : <input type="text" name="board_writer" /> <br> 
		글 비밀번호 : <input type="password" name="board_password" /> <br>
		<textarea name="board_content" rows="10" cols="30"></textarea>
	</form>

	<button type="submit" form="writeForm">글쓰기</button>
	<button>글목록</button> -->
	<form action="./write" method="post">
	<table border="3">
		<tr>
			<th>글 제목</th>
			<td><input type="text" name="board_title" /></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input type="text" name="board_writer" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="board_password" /></td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td><textarea name="board_content" rows="10" cols="22"></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit" form="writeForm">글쓰기</button></td>
		</tr>
	</table>
	</form>
</body>
</html>