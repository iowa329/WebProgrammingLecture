<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
	body { font-family: 굴림체; }
	select { width: 60px; padding: 4px; margin-bottom: 10px; }
	input { width: 130px; padding: 4px; margin-bottom: 10px; }
	button { padding: 0.4em 1em; }
</style>
</head>
<body>
	<% 
	request.setCharacterEncoding("utf-8");
	String selectedItem = request.getParameter("select");
	if (selectedItem == null) {
		selectedItem = "one";
	}
	%>

	<div class="container">
		<form action="form2.jsp" method="get">
			<select name="select">
				<option value="one" <%= "one".equals(selectedItem) ? "selected" : "" %>> one </option>
				<option value="two" <%= "two".equals(selectedItem) ? "selected" : "" %>> two </option>
				<option value="three" <%= "three".equals(selectedItem) ? "selected" : "" %>> three </option>
			</select>
			<div>
				<input type="text" name="selectedItem" value="<%= selectedItem %>" />
			</div>	
			<div>
				<button type="submit" name="ok" value="Ok"> Ok </button>
			</div>
		</form>
	</div>
</body>
</html>