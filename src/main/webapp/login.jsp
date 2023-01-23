<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="ServletLogin" method="post">
	<table>
		<tr>
			<td><label>Usuario:</label></td>
			<td><input name="inpUser" type="text"></td>
		</tr>
		<tr>
			<td><label>Contraseña:</label></td>
			<td><input name="inpPass" type="password"></td>
		</tr>
	</table>
	<c:if test="${mensaje != null}">
		<p style="color:red;">${mensaje}</p>
	</c:if>
	<div>
		<input name="btnLogin" type="submit" value="Login">
		<input name="btnReset" type="reset" value="Reset">
		<a href="registro.jsp">REGISTRARSE</a>
	</div>		
	</form>
</body>
</html>