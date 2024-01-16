<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>삭제하려는 글의 비밀번호를 입력하는 곳</h3>
	
	<h5 id="out"></h5>
	<h5 id="out2"></h5>
	
	<input id="inputPassword" type="password" name="board_password"/>
	<button id="confirmBtn">확인</button>
	
	<script src="<%=request.getContextPath()%>/resources/board/js/sha256.js"></script>
	<script>
		const out = document.getElementById('out');
		const out2 = document.getElementById('out2');
		const inputPassword = document.getElementById('inputPassword');

		const hiddenPassword = opener.document.getElementById('hiddenPassword');
		const deleteForm = opener.document.getElementById('deleteForm');
		const confirmBtn = document.getElementById('confirmBtn');
		
		
		out.innerText = '삭제하려는 글의 번호: ' + deleteForm.elements.board_id.value;
		out2.innerText = '삭제하려는 글의 비번 해쉬값: ' + deleteForm.elements.check_password.value;
		
		const getHashedPassword = password => sha256(password).toUpperCase();
		
		confirmBtn.addEventListener('click', (e) => {
			const hashedPassword = getHashedPassword(inputPassword.value);
			if(hashedPassword === deleteForm.elements.check_password.value){
				hiddenPassword.value = hashedPassword;
				deleteForm.submit();
				window.close();
			} else {
				alert('비밀번호가 틀렸습니다!');
			}
		});
	</script>
</body>
</html>