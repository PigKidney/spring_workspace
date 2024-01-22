<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/js/list.js" var="listJS"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 재고 목록</title>
<link rel="stylesheet" href="">
</head>
<body>
	<h1>과일 재고</h1>
	<table border="1">
		<tr>
			<th>FRUIT_ID</th>
			<th>FRUIT_NAME</th>
			<th>FRUIT_PRICE</th>
			<th>FRUIT_GRADE</th>
			<th>COUNTRY_ID</th>
		</tr>
		<c:forEach items="${fruits}" var="fruit">
			<tr>
				<td>${fruit.fruit_id}</td>
				<td>${fruit.fruit_name}</td>
				<td>${fruit.fruit_price}</td>
				<td>${fruit.fruit_grade}</td>
				<td>${fruit.country_id}</td>
				<td><button
						onclick="location.href='./update?fruit_id=${fruit.fruit_id}'">수정</button></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
		<table border="3">
			<tr>
				<th>과일이름</th>
				<td><input type="text" id="fruit_name" /></td>
			</tr>
			<tr>
				<th>과일가격</th>
				<td><input type="number" id="fruit_price"
					value="${fruit.fruit_price}" step="100" /></td>
			</tr>
			<tr>
				<th>과일등급</th>
				<td>
				<c:set value="A+/A/B/C/D" var="grades"/>
				<select id="fruit_grade">
					<c:forTokens items="${grades}" delims="/" var="grade">
						<c:choose>
							<c:when test="${grade == fruit.fruit_grade}">
								<option value="${grade}" selected="selected">${grade}</option>
							</c:when>
							<c:otherwise>
								<option value="${grade}">${grade}</option>
							</c:otherwise>
						</c:choose>
					</c:forTokens>
				</select>
				</td>
			</tr>
			<tr>
				<th>국가코드</th>
				<td>
				<select id="country_id">
						<c:forEach items="${countries}" var="countrie">
							<option value="${countrie.country_id}">${countrie.country_id}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><button id="insert">INSERT</button> <button id="update">UPDATE</button> <button id="delete">DELETE</button></td>
			</tr>
		</table>

	<script src="${listJS}"></script>

</body>
</html>