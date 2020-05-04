<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
int num = 0;
int i = 1;
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
</style>
</head>
<body>
  <div class="container">
    <form action="mid1.jsp" method="post">
      <div>
        <label>text1:</label> 
        <input type="text" name="param1" value=<%= num%> />
      	<button>단</button>
      </div>
      <table>
      	<tr>
      		<td><%= num*i %></td>
      	</tr>
      </table>
      
      <button type="submit" name="cmd" value="ok">확인</button>
      <button type="reset">취소</button>
    </form>
  </div>
</body>
</html>