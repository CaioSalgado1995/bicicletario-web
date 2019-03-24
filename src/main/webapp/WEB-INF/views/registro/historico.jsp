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
<title>Histórico de registros</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="Histórico de registros:"/></h1>
		
		<c:if test="${listaVazia}">
			<h2><c:out value="${mensagemErro}"/></h2>
		</c:if>
		
		<c:if test="${!listaVazia}">
			<div class="row" style="margin-top:20px;">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Registro</th>
							<th scope="col">Data de Entrada</th>
							<th scope="col">Horário de Entrada</th>
							<th scope="col">Data de Saída</th>
							<th scope="col">Horário de Saída</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaRegistros}" var="registro">
							<tr>
								<th scope="row"></th>
								<th>${registro.aluno.registroAluno}</th>
								<th><fmt:formatDate value="${registro.dataEntradaFormatada}" pattern="dd/MM/yyyy"/></th>
								<th>${registro.horarioEntrada}</th>
								<th><fmt:formatDate value="${registro.dataSaidaFormatada}" pattern="dd/MM/yyyy"/></th>
								<th>${registro.horarioSaida}</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>			
		</c:if>
	</div>
</body>
</html>