<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
		<link href='http://fonts.googleapis.com/css?family=Anonymous+Pro' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" >
        <title>Logs Fortress </title>
    </head>
    <body>
    <center><h1>Logs Fortress</h1></center>
    <div class="main">
    	<center>
    	Check your logs!<br> Paste your Steam ID here:
    	<form action="player" method="post">
 			Steam ID: <input type="text" name="steamid"><br>
 		 	<input type="submit" value="Check">
		</form>
		</center>
	</div> <br>
	<div class="stats">
		We have reach <b><c:out value="${PlayerCount}"></c:out></b> players in  <b><c:out value="${LastLogId}"></c:out></b> logs. ( <c:out value="${LastLogIdPercent}"></c:out> % overall Logs). 
	<br> Logs Fortress v.0.1 Copyright 2014 Jakub Homlala.
	</div>
	
    	
    </body>
    
    
    
    
</html>
