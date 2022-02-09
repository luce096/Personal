<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
		width: 80%;
		text-align: center;
		margin: auto;
		height: 30%;
	}
	
</style>
</head>
<body>
<h1>홈쇼핑 회원 등록</h1>
		<form name="join" action="memberJoin" method="post">
			<table border="1">
				<tr>
					<td>회원성명</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address"></td>
				</tr>
			<!-- 	<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate"></td>
				</tr> -->
				<tr>
					<td>고객등급</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록"> 
				</tr>
			</table>
		</form>
</body>
</html>