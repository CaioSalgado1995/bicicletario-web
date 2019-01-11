<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> 
	<a class="navbar-brand" href="${s:mvcUrl('HC#exibeHome').build()}">Bicicletário</a>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav"> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirFormulario').build()}">Cadastrar aluno</a> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirListaAlunos').build()}">Registrar entrada</a> 
			<a class="nav-item nav-link" href="${s:mvcUrl('AC#exibirListaAlunosComRegistroAtivo').build()}">Registrar saída</a>
			<a class="nav-item nav-link" href="${s:mvcUrl('RC#consultarRegistrosFechados').build()}">Histórico</a>
			<a class="nav-item nav-link" href="${s:mvcUrl('SC#exibeSobre').build()}">Sobre</a>		
		</div>
	</div>
</nav>
<div class="container">