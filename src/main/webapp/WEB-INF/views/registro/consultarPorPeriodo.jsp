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
<link type="text/css" href="<c:url value='/resources/css/bootstrap-grid.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-grid.min.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-reboot.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap-reboot.min.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
<link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<title>Consulta período de uso do aluno</title>
</head>
<body>
	<div class="container">
		<h1>Consulta período de uso do aluno:</h1>
		<c:if test="${avisoTermino}">
			<div class="alert alert-danger">
				<strong>Aviso: </strong> esse aluno está próximo de expirar seu prazo de três dias. <br/>
				Favor solicitar que aluno registre sua saída do bicicletário.
			</div>
		</c:if>
		<div class="row">
			<label>
				Registro Aluno: <c:out value="${registroAluno}"></c:out> 
			</label>
		</div>
		<div class="row">
			<label>
				Dias: <c:out value="${dias}"></c:out> 
			</label>
		</div>
		<div class="row">
			<label>
				Horas: <c:out value="${horas}"></c:out>
			</label>
		</div>
		<div class="row">
			<label>
				Minutos: <c:out value="${minutos}"></c:out>
			</label>
		</div>
	</div>
</body>
</html>