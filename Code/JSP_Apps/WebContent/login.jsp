<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<%
String message = "";
String userid = request.getParameter("userid");
String password =request.getParameter("pwd");
if((userid!=null && userid.trim().length()>0) 
		&& (password!=null && password.length()>0)){
if(userid.equals(password)){
	response.sendRedirect("welcome.jsp");
}
else
{
	message = "Invalid Userid or Password ";
	//out.println("Invalid Userid or Password ");
%>	
	
<%
}
}
else{
	message= "";
%>

<%
}
%>
<h1 style="color: red"><%=message %></h1>
<form action="login.jsp" method="post">
<table>
<tr>
<td>Userid</td>
<td><input type="text" name="userid" placeholder="Type Userid Here"/>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pwd" placeholder="Type Password Here"/>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Login"/>
</td>
</tr>
</table>
</form>
</body>
</html>