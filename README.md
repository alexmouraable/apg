<h1 align="center">
  <img src="./src/main/resources/static/img/logo.png" />
</h1>

<p align="center">
  <b>
    APG (Attendance Password Generator) - Gerador de Senha de Atendimento
  </b>
</p>

<div align="center">
  <a href="#description">Descrição</a> ❙
  <a href="#technologies">Tecnologias</a> ❙
  <a href="#installation">Instalação</a> ❙
  <a href="#license">Licença</a>
</div>

<br />

<div align="center">
  <img src="https://user-images.githubusercontent.com/38754458/108899330-108d4e00-75f7-11eb-9bdd-5c3ab716d9f7.png" />
</div>

<h2>
  <a name="description">
    &#128195; Descrição
  </a>
</h2>

<p align="justify">
O APG é um software Web que detém o propósito de organizar o <b>Atendimento</b> em estabelecimentos. À vista disso, o APG é responsável por <b>Gerar Senha de Atendimento</b> que contém: <b>Nome do Estabelecimento</b>, <b>Número da Senha</b>, <b>Tipo da Senha</b> e <b>Data de Geração da Senha</b>. Um ponto de atenção é que o APG não detém <b>Painel de Senha de Atendimento</b> e <b>Chamador de Senha de Atendimento</b>, por consequência, é necessário haver tais componentes para tornar o <b>Atendimento</b> 100% sistematizado. Então, como integrar o APG com o software que inclui os componentes citados anteriormente? Atualmente, tal integração é efetuada via <b>Banco de Dados</b>, para saber mais, vá para o tópico de <a href="#installation">Instalação</a>.
</p>

<h2>
  <a name="technologies">
    &#10084; Tecnologias
  </a>
</h2>

- Programming Languages
  - Java 
- Frameworks
  - Spring Boot
  - Spring Data JPA
  - JUnit 5
  - Mockito
- Libs
  - Lombok
  - ModelMapper 
  - JasperReports
- Template Engines
  - Thymeleaf
- Database
  - SQL Server 2000  
  
<h2>
  <a name="installation">
    &#128640; Instalação
  </a>
</h2>

<p align="justify">
O tópico de instalação contém 3 seções: Execução, Banco de Dados e Integração. Em Execução, será exposto o processo para executar o APG, já em Banco de Dados, será possível aprender a configurar o Banco de Dados do APG, por fim e não menos importante, em Integração será explanado o processo para integrar o APG com um software que detém Painel e Chamador de Senha de Atendimento.
</p>

**Execução**

<p align="justify">
É importante conferir a instalação do Java 8 e Git antes de continuar. A seguir é possível visualizar um diagrama que expõe as etapas que devem ser concretizadas para executar o APG:
</p>

<br />

<div align="center">
  <img src="https://user-images.githubusercontent.com/38754458/109642642-00fb9100-7b32-11eb-8b4b-15b9de790066.png" />
</div>

<br />

1. Clonar
    - Abrir o Prompt de Comando e executar `git clone https://github.com/alexmouraable/apg.git`
2. Importar
    - Abrir IDE e importar o APG (Poject Maven)
3. Configurar
    - Abrir [application.yml](./src/main/resources/application.yml) e configurar: **Conexão com Banco de Dados**, **Nome da Impressora** responsável por imprimir a Senha de Atendimento e **Nome do Estabelecimento** que aparecerá na Senha de Atendimento
4. Executar
    - Executar o APG e acessá-lo em `http://localhost:8080/password/print-password` 

**Banco de Dados**

**Integração**


<h2>
  <a name="license">
    &#128216; Licença
  </a>
</h2>

O APG está sob a [Licença MIT](LICENSE).
