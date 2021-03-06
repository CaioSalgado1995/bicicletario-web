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
	
		<h1>Cadastro de bicicleta</h1>
		<form:form action="${s:mvcUrl('BC#inserirBicicleta').build()}" method="post" commandName="bicicleta">
			<div class="form-group">
				<label for="marca">Marca:</label>
				<input class="form-control" name="marca" id="marca"/>
				<form:errors cssClass="text-danger" path="marca"/>
			</div>
			<div class="form-group">
				<label for="cor">Cor:</label>
				<input class="form-control" name="cor" id="cor" />	
				<form:errors cssClass="text-danger" path="cor"/>
			</div>

			<input type="hidden" name="registroAluno" id="registroAluno" value="${registroAluno}" />

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
</body>
</html>