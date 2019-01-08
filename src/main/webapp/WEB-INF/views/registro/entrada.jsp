<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-grid.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-grid.min.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-reboot.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-reboot.min.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<title>Cadastro de registro - Form</title>
</head>
<body>
	<div class="container">
		
		<h1>Registro de entrada do aluno:</h1>
		<form:form action="${s:mvcUrl('RC#inserirRegistro').build()}" method="post" commandName="registroEntrada">
			<div class="form-group">
				<label for="dataEntrada">Data de entrada:</label>
				<input type="date" class="form-control" id="dataEntrada" name="data">
			</div>
			<div class="form-group">
				<label for="horas">Horas:</label>
				<input type="text" class="form-control" id="horas" name="number" pattern="\d*" maxlength="2" max="24">
			</div>
			<div class="form-group">
				<label for="minutos">Minutos:</label>
				<input type="text" class="form-control" id="minutos" name="data" pattern="\d*" maxlength="2">
			</div>
			
			<input type="hidden" id="registroAluno" name="registroAluno" value="${registroAluno}">
			
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form:form>
	</div>
</body>
</html>