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
			$('#listBtn').click(function(){
				location.href='selectBoardList.do';
			});
			$('#updateBtn').click(function(){
				$('#f').attr('action', 'updateBoard.do');
			});
			$('#deleteBtn').click(function(){
				if(confirm('정말 삭제하시겠습니까?')){
					$('#f').attr('action', 'deleteBoard.do');
				}
			});
		});
	</script>
</head>
<body>
	<form id="f">
		<table border="1">
			<tr>
				<td>순번</td>
				<td><input type="text" name="bidx" value="${board.bidx}" readonly></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.bwriter}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" value="${board.btitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="content" name="content" value="${board.bcontent}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="updateBtn">수정</button>
					<input type="button" id="listBtn" value="목록">
					<button id="deleteBtn">삭제</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>