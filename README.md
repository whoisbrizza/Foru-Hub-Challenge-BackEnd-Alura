# Fórum Hub: Backend do Desafio

## Descrição do Projeto

Este projeto é o backend de uma aplicação de fórum, desenvolvido como parte do desafio da plataforma Alura. A aplicação permite que usuários criem tópicos de discussão.

## Funcionalidades

-   **CRUD de Tópicos:** Os usuários podem criar, ler, atualizar e excluir tópicos de discussão.
-  (doing) **Autenticação e Autorização:** Segurança garantida com autenticação via token JWT.
-  (doing) **Regras de Negócio:** Validações para garantir que não haja tópicos duplicados e que apenas o autor possa modificar seu próprio conteúdo.
-  (doing) **Relacionamento entre Entidades:** Associações entre usuários, tópicos e respostas, permitindo uma estrutura de dados robusta e eficiente.
-   **API RESTful:** Toda a comunicação é feita através de uma API REST, seguindo as melhores práticas do mercado.

## Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

### Backend
-   **Java 17:** Linguagem de programação principal.
-   **Spring Boot 3.x:** Framework para simplificar e acelerar o desenvolvimento do backend.
-   **Spring Security:** Para implementar a autenticação e autorização via JWT.
-   **Spring Data JPA:** Para a persistência de dados e a comunicação com o banco de dados.
-   **Maven:** Gerenciador de dependências do projeto.
-   **Flyway:** Ferramenta de migração de banco de dados para gerenciar o esquema de forma segura e incremental.

### Banco de Dados
-   **MySQL:** Sistema de gerenciamento de banco de dados relacional.

## Como Rodar a Aplicação

Para rodar este projeto, siga os passos abaixo:

### Pré-requisitos
Certifique-se de que você tem o seguinte software instalado:
-   **Java 17 JDK**
-   **Maven**
-   **MySQL** (ou Docker com MySQL)

### 1. Configurar o Banco de Dados

1.  Crie um novo banco de dados no MySQL com o nome de sua preferência.
2.  Abra o arquivo `src/main/resources/application.properties` e atualize as seguintes linhas com suas credenciais do MySQL:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/<nome_do_seu_banco>
    spring.datasource.username=<seu_usuario>
    spring.datasource.password=<sua_senha>
    ```

3.  O Flyway cuidará da criação das tabelas e do esquema do banco de dados automaticamente quando a aplicação for iniciada.

### 2. Rodar a Aplicação

Abra o terminal na pasta raiz do projeto e execute o seguinte comando Maven:

```bash
mvn spring-boot:run
```
### Este comando fará o download das dependências, compilará o código e iniciará a aplicação. O servidor estará disponível em http://localhost:8080.

3. Acessar a Documentação
A documentação da API, gerada pelo SpringDoc, estará disponível em:

Swagger UI: http://localhost:8080/swagger-ui.html
