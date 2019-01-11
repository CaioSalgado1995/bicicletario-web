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
<title>Cadastro - Form</title>
</head>
<body>
	<div class="container">
	
		<h1>Cadastro do aluno</h1>
		
		<!-- Mensagem de erro ao tentar cadastrar (campo vazio ou aluno já cadastrado) -->
		<c:if test="${not empty mensagemErro}">
			<div class="alert alert-danger" style="margin-top: 20px;">
				<c:out value="${mensagemErro}"></c:out> 
			</div>
		</c:if>
		
		<!-- Formulário de cadastro -->
		<form:form action="${s:mvcUrl('AC#registrarAluno').build()}" method="post" commandName="aluno">
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" class="form-control" id="nome" name="nome">
				<form:errors cssClass="text-danger" path="nome"></form:errors>
			</div>
			<div class="form-group">
				<label for="registro">Registro Acadêmico (RA):</label>
				<input type="text" class="form-control" id="registro" name="registro">	
				<form:errors cssClass="text-danger" path="registro"></form:errors>
			</div>
			
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
</body>
</html>