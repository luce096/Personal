<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
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
		height: 10%;
	}
	
	h2{
		text-align: center;
	
	}
</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<h2>회원목록조회수정</h2>
<table border=1>
  <tr>
  <th>회원번호</th>
  <th>회원이름</th>
  <th>전화번호</th>
  <th>주소</th>
  <th>가입날짜</th>
  <th>등급</th>
  <th>도시번호</th>
  </tr>
  <c:forEach items="${mList}" var="item">
  <tr>
  <td><a href="update.jsp">${item.custno}</a></td>
  <td>${item.custname}</td>
  <td>${item.phone}</td>
  <td>${item.address}</td>
  <td>${item.joindate}</td>
  <td>${item.grade}</td>
  <td>${item.city}</td>
  </tr>
  </c:forEach>
  </table>
</body>
</html>