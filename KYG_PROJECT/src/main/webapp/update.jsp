<%@page import="dto.Member"%>
<%@page import="service.MemberMM"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table.type03 {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-left: 3px solid #369;
  margin : 20px 10px;
}
table.type03 th {
  width: 147px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #153d73;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;

}
table.type03 td {
  width: 349px;
  padding: 10px;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}
</style>
</head>
<body>
	<h1>홈쇼핑 회원 등록</h1>
		<form name="update" action="memberUpdate" method="post">
			<table border="1">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" name="num"></td>
				</tr>
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
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate"></td>
				</tr>
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