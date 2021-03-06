<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#goInput').click(function(){
				location.href='insertBoardPage.do';
			});
		});
	</script>
</head>
<body>
	총 게시글: ${countList}개
	<table border="1">
		<tr>
			<td>순번</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="4">게시물이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty list}">
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.bidx}</td>
					<td>${board.bwriter}</td>
					<td><a href="selectBoardByIdx.do?bidx=${board.bidx}">${board.btitle}</a></td>
					<td>${board.bdate}</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="4"><button id="goInput">새글 작성</button></td>
		</tr>
	</table>
</body>
</html>