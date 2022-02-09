<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #64AAFF;
}
ul:after{
    content:'';
    display: block;
    clear:both;
}
li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
</style>
</head>
<body>
<div id="nav_menu">
	<ul style="list-style-type:none">
		<li><a href="javascript:Aj('./join','#main')">회원등록</a></li>
		<li><a href="javascript:Aj('./memberList','#main')">회원목록조회</a></li>
		<li><a href="javascript:Aj('./plist','#main')">회원매출조회</a></li>
		<li><a href="javascript:Aj('./main','#main')">메인 페이지</a></li>
	</ul>
</div>
</body>
</html>