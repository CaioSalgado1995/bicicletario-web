# Bicicletário UTFPR
Projeto de tecnologia para melhorar o atendimento no bicicletário da Universidade Tecnológica Federal do Paraná

## Funcionalidades
- Cadastro de aluno
- Cadastro de bicicleta de um aluno
- Registro de entrada de um aluno
- Registro de saída de um aluno
- Listagem de alunos já cadastrados
- Listagem de alunos com registro de entrada ativo
- Busca por nome
- Busca por número de registro
- Histórico de registros com status concluído (entrada + saída)
- Consulta período do aluno no bicicletário (entre um registro de entrada e antes do registro de saída) (dias/horas/minutos)

## Mapeamentos

- localhost:8080/bicicletario/aluno _GET_ **Exibe o formulário de cadastro do aluno**
- localhost:8080/bicicletario/aluno _POST_ **Envia o formulário de cadastro do aluno**
- localhost:8080/bicicletario/aluno/lista _GET_ **Exibe lista de alunos já cadastrados**
- localhost:8080/bicicletario/aluno/lista/ativos _GET_ **Exibe lista de alunos já cadastrados que tem registro de entrada**
- localhost:8080/bicicletario/bicicleta _GET_ **Exibe o formulário de cadastro de bicicleta**
- localhost:8080/bicicletario/bicicleta _POST_ **Envia o formulário de cadastro da bicicleta**
- localhost:8080/bicicletario/home _GET_ **Exibe a home, que contêm todas as demais opções presentes no software**
- localhost:8080/bicicletario/registro/{registroAluno} _GET_ **Exibe o formulário de registro de entrada de um aluno**
- localhost:8080/bicicletario/registro/saida/{registroAluno} _GET_ **Exibe o formulário de registro de saída de um aluno** 
- localhost:8080/bicicletario/registro _POST_ **Envia o formulário para registro de entrada de um aluno**
- localhost:8080/bicicletario/registro/saida _POST_ **Envia o formulário para registro de saída de um aluno**
- localhost:8080/bicicletario/registro/finalizados _GET_ **Exibe tela com listagem dos registros já finalizados**
- localhosT:8080/bicicletario/sobre _GET_ **Exibe tela explicativa sobre a aplicação e os desenvolvedores envolvidos**

## Tecnologias utilizadas

- jdk 1.8
- Maven - gerenciamento de dependências
- Spring MVC - framework web
- Hibernate/JPA - validações e persistência com o banco de dados
- Eclipse - ide para desenvolvimento
- Tomcat - servidor para testes de desenvolvimento
- Bootstrap - temas e layouts de tela
- Maria DB - banco de dados relacional sql

## Estrutura de pacotes java

- `br.com.utfpr.bicicletario.config` - pacote que contêm todas as classes de configuração para utilização do spring mvc e jpa
- `br.com.utfpr.bicicletario.controller` - pacote que contêm todas as controllers do projeto
- `br.com.utfpr.bicicletario.dao` - pacote que contêm todas as classes DAO que fazem acesso ao banco de dados
- `br.com.utfpr.bicicletario.models` - pacote que contêm todas as entidades que são geradas ao inicializar o projeto, bem como outras modelos necessárias

## Estrutura de views

- WEB-INF/views/cadastro - contêm os formulários de cadastro de aluno e bicicleta
- WEB-INF/views/home - contêm as telas de entrada e sobre
- WEB-INF/views/registro - contêm todas as telas relacionadas a fluxos de registro de entrada e saída

## Detalhes técnicos
- Utilizamos o cache do spring para poder guardar retornos de métodos e evitar acúmulo de consultar com o hibernate, para isso, utilizamos como `CacheManager` o `GuavaCacheManager`.

```java
@Bean
public CacheManager cacheManager() {
	CacheBuilder<Object, Object> cacheBuilder = 
			CacheBuilder
			.newBuilder()
			.maximumSize(300)
			.expireAfterAccess(10, TimeUnit.MINUTES);
	GuavaCacheManager manager = new GuavaCacheManager();
	manager.setCacheBuilder(cacheBuilder);
	return manager;
}
```
- Para validação dos campos de formulários, utilizamos as anotações de validação do hibernate, consequentemente utilizamos a interface `BindingResult` como interface de checagem do bing dos campos.

```java
// Exemplo de classe utilizando anotações de validação do hibernate @NotEmpty e @Size
@Entity
public class Aluno {

	@Id
	@NotEmpty(message = "O campo não pode ser vazio")
	@Size(min = 7, max = 7, message = "O campo deve conter 7 números")
	private String registro;
	
	@NotEmpty(message = "O campo não pode ser vazio")
	private String nome;

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

// Exemplo de controller utilizando a interface BindingResult, 
// podemos ver o uso também da anotação @CacheEvict, que invalida o cache em caso de inserção de um novo aluno.
// Entenda por invalidar o cache, que uma nova consulta será feita ao banco de dados, pois ocorreu uma atualização no mesmo
@RequestMapping(method=RequestMethod.POST)
@CacheEvict(value="listaAlunos" ,allEntries=true)
public ModelAndView registrarAluno(@Valid Aluno aluno, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
	ModelAndView modelAndView;

	if(bindingResult.hasErrors()) {
		return new ModelAndView(FORMULARIO_ALUNO);
	}

	if(alunoDAO.existe(aluno)) {
		modelAndView = new ModelAndView(FORMULARIO_ALUNO);
		modelAndView.addObject(MENSAGEM_ERRO, "Aluno já cadastrado");
	}else {
		alunoDAO.inserir(aluno);
		modelAndView = new ModelAndView("redirect:bicicleta");
		redirectAttributes.addFlashAttribute("registroAluno", aluno.getRegistro());
	}

	return modelAndView;
}
```

## Configuração local

- Detalhar configuração local

- Configuração da base de dados esperada pelo projeto

```java
DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setUsername("root");
dataSource.setPassword("root");
dataSource.setUrl("jdbc:mariadb://localhost:3306/utfpr_bicicletario");
dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
```

## Deploy no servidor tomcat

- Detalhar passo a passo de instalação no tomcat

## Desenvolvedor

- ***Caio Luiz Salgado*** - Bacharelado em Sistemas de Informação - Universidade Tecnológica Federal do Paraná

## Colaboradores
- ***Lucas Paulatti Kassar*** - Engenharia de controle a automação - Universidade Tecnológica Federal do Paraná

## Build e empacotamento

- `mvn compile`

- `mvn package` - Gera um arquivo .war
