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
  <p>
    <b>
      Figura 1. Página Principal - Imprimir Senha
    </b>
  </p>
</div>

<h2>
  <a name="description">
    &#128195; Descrição
  </a>
</h2>

APG é uma Aplicação Web responsável por <b>Gerar Senha de Atendimento</b>. Detém integração com o <b>SysLabMed (Aplicação Desktop de Gestão Clínica)</b>. Tal integração é via <b>BD (SQLServer 2000)</b>:

<div align="center">
  <img src="https://user-images.githubusercontent.com/38754458/108910581-d4f98080-7604-11eb-865e-9dc329e7c4cc.jpg" />
  <p>
    <b>
      Figura 2. Integração Entre APG e SysLabMed
    </b>
  </p>
</div>

O BD detém uma tabela que é responsável por armazenar senhas. Assim, APG gera a senha e salva no BD. Em seguida, SysLabMed poderá chamar e exibir no painel de atendimento a senha gerada.

<h2>
  <a name="technologies">
    &#10084; Tecnologias
  </a>
</h2>

- Linguagens de Programação
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
  
<h2>
  <a name="installation">
    &#128640; Instalação
  </a>
</h2>



<h2>
  <a name="license">
    &#128216; Licença
  </a>
</h2>

APG está sob a [Licença MIT](LICENSE).
