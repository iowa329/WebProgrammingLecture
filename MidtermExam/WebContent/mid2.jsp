<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
	body { font-family: 굴림체; }
	input { padding: 4px; }
	button { padding: 0.4em 1em; }
</style>
</head>
<body>
	<% 
	request.setCharacterEncoding("utf-8");
	String selectedRadio = request.getParameter("chk_info");
	if (selectedRadio == null) {
		selectedRadio = "one";
	}
	%>

	<div class="container">
		<form action="form2.jsp" method="get">
			<input type="radio" name="chk_info" value="one" checked="checked">one
			<input type="radio" name="chk_info" value="two">two
			<input type="radio" name="chk_info" value="three">three
			<div>
				<input type="text" name="selectedItem" value="<%= selectedRadio %>" />
			</div>	
			<div>
				<button type="submit" name="ok" value="Ok"> Ok </button>
			</div>
		</form>
	</div>
</body>
</html>