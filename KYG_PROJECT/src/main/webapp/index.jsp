<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	html, body {
		height: 95%;
	}

	div {
		margin: 0px;
		overflow: hidden;	
	}

	#header {
		width: 100%;
		height: 20%;
		background: #7C83FD;
	}
	
 	#nav {
		width: 100%;
		height: 5%;
		background: #96BAFF;
		overflow: auto; /* 상품이 많으면 스크롤 생성 */
		/* display:flex; */
	}
	
	#main {
		width: 100%;
		height: 80%;
		background: #7DEDFF;
		overflow: auto; /* 상품이 많으면 스크롤 생성 */
		/* display:flex; */
	}

	#footer {
		width: 100%;
		height: 10%;
		text-align: center;
		float: left;
		overflow: auto;
		background: #7C83FD;
	}
</style>
</head>
<body>
<div id="header"><jsp:include page="header.jsp" /></div>
<div id="menu"><jsp:include page="menu.jsp" /></div>
<div id="main"></div>
<div id="footer"><jsp:include page="footer.jsp" /></div>
<script type="text/javascript">
let severData;
$(function(){

	$('#footer').load('footer.jsp'); 
	Aj('menu','#menu');
	if(${page==null}){
		Aj('main', '#main');
	}else{
		Aj('${page}','#main');
	}
}); //ready
	
	
function Aj(url, position){
	$.ajax({
		url : url,
		type : 'get',
		dataType : 'html' //json
	}).done((data)=>{console.log(data);$(position).html(data);})
	.fail((err)=>console.log(err))
} //Aj End
</script>
</body>
</html>