<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
int id = 0;
String studentNumber = "";
String name = "";
int departmentId = 1;
int year = 0;
String 에러메시지 = null;
request.setCharacterEncoding("UTF-8");
if (request.getMethod().equals("POST")) {
    String str = "";
	str = request.getParameter("id");
    id = Integer.parseInt(str);
    studentNumber = request.getParameter("studentNumber");
    name =  request.getParameter("name");
    str = request.getParameter("departmentId");
    departmentId = Integer.parseInt(str);
    str = request.getParameter("year");
    year = Integer.parseInt(str);
    
    if (name == null || name.length() == 0) 
        에러메시지 = "이름을 입력하세요";
    else if (year == 0) 
        에러메시지 = "학년을 입력하세요";
    else {
        Student student = new Student(id, studentNumber, name, departmentId, year);
        session.setAttribute("student", student);
        response.sendRedirect("studentCreate_success.jsp");
        return;
    }    
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://kit.fontawesome.com/68abb170e0.js" crossorigin="anonymous"></script>
<style>
  body { font-family: 굴림체; font-size: 10pt; }
  div.container { width: 400px; margin: 20px auto; }
  form, form div { margin-bottom: 20px; }
  label { display: block; }   
  input.text { width: 200px; padding: 5px; }
  select { width: 150px; padding: 5px; }
  .btn { padding: 0.7em 2em; border: 1px solid #aaa; border-radius: 4px; 
         background: linear-gradient(#fff, #ddd); color: black;       
         font-family: 굴림체; font-size: 10pt; line-height: 1em;   
         text-decoration: none; cursor: pointer; display: inline-block; }
  .btn:active {
      -ms-transform: translateY(2px);
      -webkit-transform: translateY(2px);
      transform: translateY(2px);
      background: #ccc;  }
   hr { margin-top: 80px; }
   div.info { margin: 10px; padding: 10px 20px; background-color: #dff; border: 1px solid #8ff; }
   div.error { margin: 10px; padding: 10px 20px; background-color: #fdd; border: 1px solid #faa; }
   table{ border-collapse: collapse; width: 200px; }
</style>
</head>
<body>

<div class="container">

<form method="post">
  <h1>회원 등록</h1>
  <div>
    <label>이름</label>
    <input type="text" class="text" name="name" value="<%= name %>" />
  </div>
  <div>
    <label>성별</label>
		<input type="radio" name="chk_info" value="male">남자<br />
		<input type="radio" name="chk_info" value="female">여자<br />
  <button type="submit" class="btn">회원 등록</button>
</form>
<table border="1">
	<tr>
	    <td>이름</td>
	    <td></td>
	</tr>
	<tr>
	    <td>성별</td>
	    <td></td>
	</tr>
</table>

<% if (에러메시지 != null) { %>
  <div class="error">
    회원등록 실패: <%= 에러메시지 %>
  </div>
<% } %>
</div>
</body>
</html>