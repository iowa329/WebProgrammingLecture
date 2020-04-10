<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<style>
		table { border-collapse: collapse; }
		td { padding: 3px; }
	</style>
	
	<head>
		<meta charset="UTF-8">
		<title>04week_jsp_hw_gugu1</title>
	</head>
	
	<body>
		<table border=1>
		<% for (int j=1; j <= 9; ++j) { 
		     out.println("  <tr>");
		     for (int i=2; i <= 9; ++i) {
		         out.println("    <td>" + i + " x " + j + " = " + (i * j) + "</td>");
		     }
		     out.println("  </tr>");
		   }
		%>
		</table>
	</body>
	
</html>