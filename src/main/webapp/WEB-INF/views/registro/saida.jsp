<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="<c:url value='/resources/css/bootstrap-grid.css'/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value='/resources/css/bootstrap-grid.min.css'/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value='/resources/css/bootstrap-reboot.css'/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value='/resources/css/bootstrap-reboot.min.css'/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
<link type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">
<title>Cadastro de registro - Form</title>
</head>
<body>
	<div class="container">

		<h1>Registro de saída do aluno:</h1>
		<form:form action="${s:mvcUrl('RC#atualizarRegistroComSaida').build()}"
			method="post" commandName="baseRegistro">

			<div class="alert alert-warning">
				<strong>Aviso: </strong> prencha o campo de horário.
			</div>

			<div class="form-group">
				<label>
					Data de saída: <fmt:formatDate value="${dataAtual}"></fmt:formatDate> 
				</label> 
			</div>
			
			<div class="form-group">
				<label for="horarioEntrada">Horário de saída:</label> 
				<input type="time" class="form-control" id="horario" name="horario">
				<form:errors cssClass="text-danger" path="horario"></form:errors>
			</div>

			<input type="hidden" id="registroAluno" name="registroAluno"
				value="${registroAluno}">

			<button type="submit" class="btn btn-primary">Registrar Saída</button>
		</form:form>
	</div>
</body>
</html>