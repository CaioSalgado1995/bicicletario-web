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
		class="navbar-brand" href="${s:mvcUrl('HC#exibeHome').build()}">Bicicletário</a>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav"> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirFormulario').build()}">Cadastrar aluno</a> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirListaAlunos').build()}">Registrar entrada</a> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirListaAlunosComRegistroAtivo').build()}">Registrar saída</a>
			<a class="nav-item nav-link active" href="${s:mvcUrl('SC#exibeSobre').build()}">Sobre</a>
			
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="alert alert-info" style="margin-top: 10px;">
			<strong>Objetivo desse projeto:</strong><br/>
			<p> Esse projeto foi criado com o objetivo de, através do uso da tecnologia, facilitar a vida
			dos profissionais que monitoram o bicicletário da Universidade Tecnológica Federal do Paraná, 
			assim, através desse sistema, o funcionário responsável poderá fazer registros de entrada e saída de alunos,
			bem como consultar históricos.</p> <br/>
			<p> Futuramente poderemos melhorar esse projeto adicionando novas funcionalidades, de acordo com a necessidade
			 de quem utiliza-o.</p>
		</div>
		<div class="alert alert-warning" style="margin-top: 10px;">
			<strong>Esse projeto foi desenvolvido pelos alunos:</strong><br/>
			<p><strong>Caio Luiz Salgado </strong> - DAINF - Bacharelado em Sistemas de informação <br/>
			<strong>Lucas Paulatti Kassar </strong> - XXXXX - Engenharia de controle e automação</p>
		</div>
	</div>
</body>
</html>