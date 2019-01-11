# Bicicletário UTFPR
Projeto de tecnologia para melhorar o atendimento no bicicletário da Universidade Tecnológica Federal do Paraná

## Mapeamentos

- localhost:8080/bicicletario/aluno GET *Exibe o formulário de cadastro do aluno*
- localhost:8080/bicicletario/aluno POST *Envia o formulário de cadastro do aluno*
- localhost:8080/bicicletario/aluno/lista GET *Exibe lista de alunos já cadastrados*
- localhost:8080/bicicletario/aluno/lista/ativos GET *Exibe lista de alunos já cadastrados que tem registro de entrada*
- localhost:8080/bicicletario/bicicleta GET *Exibe o formulário de cadastro de bicicleta*
- localhost:8080/bicicletario/bicicleta POST *Envia o formulário de cadastro da bicicleta*
- localhost:8080/bicicletario/home GET *Exibe a home, que contêm todas as demais opções presentes no software*
- localhost:8080/bicicletario/registro/{registroAluno} GET *Exibe o formulário de registro de entrada de um aluno*
- localhost:8080/bicicletario/registro/saida/{registroAluno} GET *Exibe o formulário de registro de saída de um aluno* 
- localhost:8080/bicicletario/registro POST *Envia o formulário para registro de entrada de um aluno*
- localhost:8080/bicicletario/registro/saida POST *Envia o formulário para registro de saída de um aluno*
- localhost:8080/bicicletario/registro/finalizados GET *Exibe tela com listagem dos registros já finalizados*
- localhosT:8080/bicicletario/sobre GET *Exibe tela explicativa sobre a aplicação e os desenvolvedores envolvidos*

## Tecnologias utilizadas

- Maven - gerenciamento de dependências
- Spring MVC - framework web
- Hibernate/JPA - validações e persistência com o banco de dados
- Eclipse - ide para desenvolvimento
- Tomcat - servidor para testes de desenvolvimento
- Bootstrap - temas e layouts de tela
- Maria DB - banco de dados relacional sql

## Estruturas de pacotes java

- br.com.utfpr.bicicletario.config - pacote que contêm todas as classes de configuração para utilização do spring mvc e jpa
- br.com.utfpr.bicicletario.controller - pacote que contêm todas as controllers do projeto
- br.com.utfpr.bicicletario.dao - pacote que contêm todas as classes DAO que fazem acesso ao banco de dados
- br.com.utfpr.bicicletario.models - pacote que contêm todas as entidades que são geradas ao inicializar o projeto, bem como outras modelos necessárias

## Views

- WEB-INF/views/cadastro - contêm os formulários de cadastro de aluno e bicicleta
- WEB-INF/views/home - contêm as telas de entrada e sobre
- WEB-INF/views/registro - contêm todas as telas relacionadas a fluxos de registro de entrada e saída

## Configuração local

- Detalhar configuração local

## Deploy no servidor tomcat

- Detalhar passo a passo de instalação no tomcat

## Desenvolvedor

- Caio Luiz Salgado - Bacharelado em Sistemas de Informação - Universidade Tecnológica Federal do Paraná

## Colaboradores

- Caio Luiz Salgado - Bacharelado em Sistemas de Informação - Universidade Tecnológica Federal do Paraná
- Lucas Paulatti Kassar - Engenharia de controle a automação - Universidade Tecnológica Federal do Paraná