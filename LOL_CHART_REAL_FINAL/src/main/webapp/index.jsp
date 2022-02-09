<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
h1 {
	text-align: center;
	color: blue;
}

html, body {
	height: 95%;
	background: #64AAFF;
}

div {
	margin: 5px;
	overflow: hidden;
}

#header {
	width: 98%;
	height: 20%;
}

#menu {
	width: 100%;
	height: 10%;
	text-align: center;
	/* overflow: auto; */
	
} 


#main {
	width: 100%;
	height: 80%;
	text-align: center;
	/* float:left; */
	overflow: auto; /* 상품이 많으면 스크롤 생성 */
	/* display:flex; */
}

#footer {
	width: 98%;
	height: 10%;
	text-align: center;
	float: left;
	overflow: auto;
}

</style>
</head>
<body>
<div id="img">
</div>
	<div id="header"><jsp:include page="header.jsp" /></div>
	<div id="menu"></div>
	<div id="main"> </div>
	<div id="footer"></div>
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