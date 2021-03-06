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
			$('#insertBtn').click(function(){
				if($('#writer').val() == ''){
					alert('작성자 입력칸을 채워주세요.');
					event.preventDefault();
					return false;
				}else if($('#title').val() == ''){
					alert('제목 입력칸을 채워주세요.');
					event.preventDefault();
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<form action="insertBoard.do" id="f">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" id="writer" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="content" name="content"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="insertBtn">등록</button>
					<input type="button" id="listBtn" value="목록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>