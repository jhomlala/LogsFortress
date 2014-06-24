<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Anonymous+Pro' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logs Fortress</title>
</head>
<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        credits: {
            enabled: false
        },
        
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        exporting: {
            buttons: {
                contextButtons: {
                    enabled: false,
                    menuItems: null
                }
            },
            enabled: false
        },
        
        title: {
            text: 'Classes count '
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Class share',
            data: [
                ['Scout',   <c:out value="${ScoutPercent}"> </c:out>],
                ['Soldier',   <c:out value="${SoldierPercent}"> </c:out>],
                ['Pyro',   <c:out value="${PyroPercent}"> </c:out>],
                ['Demoman',   <c:out value="${DemoPercent}"> </c:out>],
                ['Heavy',   <c:out value="${HeavyPercent}"> </c:out>],
                ['Engineer',   <c:out value="${EngPercent}"> </c:out>],
                ['Medic',   <c:out value="${MedicPercent}"> </c:out>],
                ['Sniper',   <c:out value="${SniperPercent}"> </c:out>],
                ['Spy',   <c:out value="${SpyPercent}"> </c:out>]
            ]
        }]
    });
});
    

</script>




<body>
<c:if test="${empty sid2}">
    <c:redirect url="/"/>
</c:if>



	<center><h1>Logs Fortress</h1></center>
    <div class="main">

		<div id="container"  style=" width:50%; "></div>
		<div class="above">
			This player is listed in <b> <c:out value="${TotalCount}" ></c:out> </b>Logs.
		</div>
		<div id="container2" style="position:absolute; left:70%; top:15%;">
			<img src="<c:out value="${playerAvatar }"> </c:out>"><br>
			Name: <c:out value="${playerName}"> </c:out><br>
			Status: <c:out value="${playerState}"> </c:out><br>
			Steam Profile: <a href="<c:out value="${playerProfile}"> </c:out>">Link</a><br>
			ETF2L Profile:  <a href="http://www.etf2l.org/search/?q=<c:out value="${sid}"> </c:out>">Link</a><br>
			UGC Profile: <a href="http://www.ugcleague.com/players_page.cfm?player_id=<c:out value="${sid2}"> </c:out>">Link</a><br>
		</div>
		<div id="container3" style="position:absolute; left:50%; top:15%;">
		Listed in Logs: <c:out value="${TotalCount }"> </c:out> times.<br>
		Scout: <b><c:out value="${Scout }"> </c:out></b> times.<br>
		Soldier: <b><c:out value="${Soldier }"> </c:out></b> times.<br>
		Pyro: <b><c:out value="${pyro }"> </c:out></b> times.<br>
		Demoman: <b><c:out value="${Demoman }"> </c:out></b> times.<br>
		Heavy: <b><c:out value="${Heavy }"> </c:out></b> times.<br>
		Engineer: <b><c:out value="${Engineer }"> </c:out></b> times.<br>
		Medic: <b><c:out value="${Medic}"> </c:out></b> times.<br>
		Sniper: <b><c:out value="${Sniper}"> </c:out></b> times.<br>
		Spy: <b><c:out value="${Spy }"> </c:out></b> times.<br>
		
		<br><br>
		Total kills : <b><c:out value="${Kills }"> </c:out></b><br>
		Total deaths : <b><c:out value="${Deaths}"> </c:out></b><br>
		Total assists : <b><c:out value="${Assists}"> </c:out></b><br>
		</div>
	

	</div>
	
	
	
	
	
		<div class="stats">
		We have reach <b><c:out value="${PlayerCount}"></c:out></b> players in  <b><c:out value="${LastLogId}"></c:out></b> logs. ( <c:out value="${LastLogIdPercent}"></c:out> % overall Logs). 
	<br> Logs Fortress v.0.1 Copyright 2014 Jakub Homlala.
	</div>
	
	
	<script src="${pageContext.request.contextPath}/resources/js/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/modules/exporting.js"></script>
</body>
</html>