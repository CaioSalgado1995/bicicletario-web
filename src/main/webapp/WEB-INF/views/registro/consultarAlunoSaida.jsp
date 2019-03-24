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
<title>Lista de alunos</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${tituloPagina}"/></h1>
		
		<c:if test="${listaAlunos.isEmpty()}">
			<h2><c:out value="${mensagemErro}"/></h2>
		</c:if>
		
		<c:if test="${!listaAlunos.isEmpty()}">
			<!-- Formulário para pesquisa -->
			<form:form action="${s:mvcUrl('AC#buscarAlunos').build()}" method="post"
				commandName="pesquisa" cssStyle="margin-top: 15px;">
				<div class="row">
					<div class="col">
						<input class="form-control mb-3" type="text" id="nome" name="nome">
					</div>
					<div class="col">
						<input type="submit" class="btn btn-primary mb-3" value="Pesquisar">
					</div>
					
					<input type="hidden" id="status" name="status" value="1">
				</div>
			</form:form>
			
			<div class="row" style="margin-top:20px;">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th scope="col">Registro</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaAlunos}" var="aluno">
							<tr>
								<th scope="row"></th>
								<th>${aluno.nome}</th>
								<th>${aluno.registroAluno}</th>
								<th>
									<a class="btn btn-primary" 
									   href="${s:mvcUrl('RC#registroSaidaAluno').arg(0,aluno.registroAluno).build()}">
										Selecionar
									</a>	
								</th>
								<th>
									<a class="btn btn-primary"
									   href="${s:mvcUrl('RC#consultarPeriodoUso').arg(0,aluno.registroAluno).build()}">
										Consultar período
									</a>
								</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>			
		</c:if>
	</div>
</body>
</html>