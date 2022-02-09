<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a:link {
  color : lightgray;
  text-decoration: none;
  fontsize: 20px;
}
a:visited {
  color : black;
  text-decoration: none;
}
a:hover {
  color : white;
  text-decoration: underline;
}
a:active {
  color : green;
  text-decoration: none;
}
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
li a:hover:not(.active) {
    background-color: #6496FF;
}
</style>
</head>
<body>
<div id="nav_menu">
	<ul style="list-style-type:none">
		<li><a href="javascript:Aj('./main','#main')">메인 페이지</a></li>
		<li><a href="javascript:Aj('./LoL_Gold','#main')">골드 획득</a></li>
		<li><a href="javascript:Aj('./LOL_Kda','#main')">평균 KDA</a></li>
		<li><a href="javascript:Aj('./LOL_Win','#main')">높은 승률의 챔피언</a></li>
		<li><a href="javascript:Aj('./LOL_Dam','#main')">높은 데미지량의 챔피언</a><li>
		<li><a href="javascript:Aj('./LOL_Tak','#main')">높은 피해량의 챔피언</a></li>
		<li><a href="javascript:Aj('./championinfo','#main')">챔피언 분석</a></li>
	</ul>
</div>
</body>
</html>