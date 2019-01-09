<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Bicicletário</a>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav"> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirFormulario').build()}">Cadastrar aluno</a> 
			<a class="nav-item nav-link" href="${s:mvcUrl('RC#exibirFormulario').build()}">Registrar entrada</a> 
			<a class="nav-item nav-link" href="#">Registrar saída</a>
			<a class="nav-item nav-link" href="#">Sobre</a>
			
		</div>
	</div>
	</nav>
	<div class="container">

		<div class="alert alert-info" style="margin-top: 20px;">
			<strong>Bicicletário UTFPR!</strong><br/>
			Bem vindo ao bicicletário, aqui você pode ...
		</div>


	</div>
</body>
</html>