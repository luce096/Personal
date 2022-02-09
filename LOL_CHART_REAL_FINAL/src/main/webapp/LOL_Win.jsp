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
					$('<option value="'+value+'">').text(value).appendTo(cham);
				});
			},
			error : function(err) {
				console.log(err);
			}
			
		}); //ajax End
	$('#btn1').click(function() {
		$.ajax({
			url : 'winrate',
			data: {'lane':$('#lane').val()},
			dataType : 'json',
			success : function(winRate) {
				showChart1(winRate);
			},
			error : function(err) {
				console.log(err);
			}
		}); //ajax End
	});//click End
	$('#btn2').click(function() {
		$.ajax({
			url : 'chamwin',
			data: {'cham':$('#cham').val()},
			dataType : 'json',
			success : function(chamwin) {
				console.log("2: ",chamwin);
				showChart2(chamwin);
			},
			error : function(err) {
				console.log(err);
			}
		}); //ajax End
		
	});//click End
}); //ready End	
//구글 챠트 라이브러리
function showChart1(winRate){
	google.charts.load('current', {'packages' : [ 'corechart' ]	});
	google.charts.setOnLoadCallback(drawVisualization);
	function drawVisualization() {
	         const color=['lightyellow','lightblue','lightgreen'];  //챠트 색깔
	         let arr=[];
	         arr.push(['챔피언이름', '승률',{ role: 'style'}, {role:'annotation'}]);
	          for(let elem of winRate){
	        	  elem[1]=parseFloat(elem[1]);  //"66.7"-->66.7
	        	  elem.push(color.pop(), elem[1]+'%'); //'66.7%''
	        	  arr.push(elem);
	        	  console.log(elem);
	           }
			let data = google.visualization.arrayToDataTable(arr);
			var options = {
				title : '승률이 높은 챔피언',
				vAxis : {
					title : '승률'
				},
				hAxis : {
					title : '챔피언이름'
				},
				seriesType : 'bars',
				//is3D: true,    //PieChart 일때
				//series: {5: {type: 'line'}}
			};
			var chart1 = new google.visualization.ComboChart(document.getElementById('chart_div'));
			chart1.draw(data, options);
	};  //drawVisualization End
};
function showChart2(chamwin){
	google.charts.load('current', {'packages' : [ 'corechart' ]	});
	google.charts.setOnLoadCallback(drawVisualization);
	function drawVisualization() {
	         const color=['gray','lightred','lightyellow','lightblue','lightgreen'];  //챠트 색깔
	         let arr=[];
	         arr.push(['라인','승률',{ role: 'style'}, {role:'annotation'}]);
	          for(let elem of chamwin){
	        	  elem[1]=parseFloat(elem[1]);  //"66.7"-->66.7
	        	  elem.push(color.pop(), elem[1]+'%'); //'66.7%''
	        	  arr.push(elem);
	        	  console.log(elem);
	           }
	          console.log("2: ", arr);
			let data = google.visualization.arrayToDataTable(arr);
			var options = {
				title : '챔피언 라인 승률',
				vAxis : {
					title : '승률'
				},
				hAxis : {
					title : '라인'
				},
				seriesType : 'bars',
				//is3D: true,    //PieChart 일때
				//series: {0: {targetAxisIndex:1,type: 'line'}}
			};
			var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
			chart.draw(data, options);
	}  //drawVisualization End
}; 

</script>

</head>
<body>
	<select id="lane" name="lane"></select>
	<button id="btn1" type="button">승률 탑3</button>
	<select id="cham" name="cham"></select>
	<button id="btn2" type="button">챔피언 승률</button>
	<div id="chart_div" style="width: 100%; height: 100%;"></div>
</body>
</html>