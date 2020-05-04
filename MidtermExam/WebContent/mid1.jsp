<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
int num = 0;

request.setCharacterEncoding("UTF-8");
if (request.getMethod().equals("POST")) {
    String str = request.getParameter("param1");
    num = Integer.parseInt(str);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  body { font-family: 굴림체; }
  div.container { width: 600px; margin: 20px auto; }
  form div { margin-bottom: 10px; }
  input { width: 200px; padding: 4px; }
  button { padding: 0.4em 3em; margin-top: 10px; }
  table{ border-collapse: collapse; width: 200px; }
</style>
</head>
<body>
  <div class="container">
    <form action="mid1.jsp" method="post">
      <div>
        <input type="text" name="param1" value=<%= num%> />
      	<button>단</button>
      </div>
      <table border="1">
      	
			<% for (int i=1; i <= 9; ++i) { %>
			<tr>
			    <td><%= num%> x <%= i%> = <%= num*i%></td>
			</tr>
			<% } %>
	  	
      </table>
    </form>
  </div>
</body>
</html>