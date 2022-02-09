<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

$(function(){
	
		$.ajax({
			url : "chartfrm",
			dataType : 'json',
			//type: 'get',
			success : function(data) {
				//console.log(data);
				let laneData=data.laneList;
				let chamData=data.chamList;
				let lane=$('#lane');
				$(laneData).each(function(idx,value) {
					$('<option value='+value+'>').text(value).appendTo(lane);
				});
				let cham=$('#cham');
				$(chamData).each(function(idx,value) {
					$('<option value='+value+'>').text(value).appendTo(cham);
				});
			},
			error : function(err) {
				console.log(err);
			}
		}); //ajax End

	$('#btn').click(function() {
		$.ajax({
			url : 'damagedealt',
			data: {'lane':$('#lane').val()},
			dataType : 'json',
			success : function(damagedealt) {
				showChart(damagedealt);
			},
			error : function(err) {
				console.log(err);
			}
		}); //ajax End
		
	});//click End
}); //ready End	
//구글 챠트 라이브러리
function showChart(damagedealt){
	google.charts.load('current', {'packages' : [ 'corechart' ]	});
	
	google.charts.setOnLoadCallback(drawVisualization);
		
	function drawVisualization() {
	         
	         const color=['lightyellow','lightblue','lightgreen'];  //챠트 색깔
	         let arr=[];
	         arr.push(['챔피언이름', '데미지량',{ role: 'style'}, {role:'annotation'}]);
	          for(let elem of damagedealt){
	        	  elem[1]=parseFloat(elem[1]);  //"66.7"-->66.7
	        	  elem.push(color.pop(), elem[1]); //'66.7%''
	        	  arr.push(elem);
	        	  console.log(elem);
	           }
			let data = google.visualization.arrayToDataTable(arr);
			var options = {
				title : '데미량이 높은 챔피언',
				vAxis : {
					title : '데미지량'
				},
				hAxis : {
					title : '챔피언이름'
				},
				seriesType : 'bars',
				//is3D: true,    //PieChart 일때
				//series: {5: {type: 'line'}}
			};
			var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));

			chart.draw(data, options);
	}  //drawVisualization End
}


</script>

</head>
<body>
	
	<select id="lane" name="lane"></select>
	<select id="cham" name="cham"></select>
	<button id="btn" type="button">전송</button>
	<div id="chart_div" style="width: 100%; height: 100%;"></div>
</body>
</html>