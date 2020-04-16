<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
	body { font-family: 굴림체; }
	input { width: 130px; padding: 4px; }
	button { padding: 0.4em 1em; margin-top: 10px; }
</style>
</head>
<body>
	<% 
	request.setCharacterEncoding("utf-8");
	String str = request.getParameter("number");
	int number;
	if (str == null) {
		number = 0;
	} else {
		number = Integer.parseInt(str);
		number++;
	}
	%>

	<div class="container">
		<form action="form1.jsp" method="get">
			<div>
				<input type="text" name="number" value="<%= number %>" /> <button type="submit" name="cmd" value="++"> ++ </button>
			</div>
		</form>
	</div>
</body>
</html>