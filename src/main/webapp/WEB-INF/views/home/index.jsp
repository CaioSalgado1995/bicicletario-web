<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:template titulo="Home">
	<c:if test="${not empty mensagemErro}">
		<div class="alert alert-danger" style="margin-top: 20px;">
			<strong>Erro: </strong><c:out value="${mensagemErro}"/>
		</div>
	</c:if>
	
	<c:if test="${not empty mensagemSucesso}">
		<div class="alert alert-success" style="margin-top: 20px;">
			<c:out value="${mensagemSucesso}"/>
		</div>
	</c:if>

	<div class="alert alert-info" style="margin-top: 10px;">
		<strong>Bicicletário UTFPR!</strong><br/>
		Bem vindo ao bicicletário, aqui você pode ...
	</div>
</tags:template>