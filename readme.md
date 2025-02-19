# Marketplace API

A Marketplace API é um serviço RESTful desenvolvido em Kotlin utilizando Spring Boot.
O objetivo do projeto é gerenciar os elementos essenciais de um marketplace, como usuários, vendedores, produtos, pedidos e pagamentos. O projeto segue o padrão MVC e organiza as responsabilidades em camadas (controllers, services, repositories e models), garantindo um código modular, de fácil manutenção e testável.

## Funcionalidades

- **Gestão de Usuários:**
    - Criar, buscar (por email e por ID), atualizar e excluir usuários.

- **Gestão de Vendedores e Produtos:**
    - Cadastro de vendedores e seus produtos associados.

- **Pedidos e Pagamentos:**
    - Gerenciamento de pedidos (orders) e itens de pedido (order items).
    - Integração com o módulo de pagamentos.

- **Tratamento Global de Exceções:**
    - Exceções customizadas (como `UserNotFoundException`) e um `GlobalExceptionHandler` para converter erros em respostas HTTP padronizadas.

- **Testes Automatizados:**
    - Utilização de testes de integração com Spring Boot Test e MockMvc, com um banco de dados em memória (H2) para isolamento dos testes.

## Como Funciona

1. **Controller:**  
   Recebe as requisições HTTP e delega a lógica de negócio para os serviços. Exemplo de endpoints:
    - `POST /users`: Criação de um novo usuário.
    - `GET /users`: Consulta de todos os usuários.
    - `GET /users/{email}`: Consulta de um usuário pelo email.
    - `GET /users/{id}`: Consulta de um usuário pelo ID.
    - `PUT /users/{id}`: Atualização de um usuário.
    - `DELETE /users/{id}`: Exclusão de um usuário.

2. **Service:**  
   Contém a lógica de negócio e interage com os repositórios. Exemplo:
    - Atualiza o usuário mantendo o ID original utilizando o método `copy()` (disponível para data classes).

3. **Repository:**  
   Fornece as operações CRUD através do Spring Data JPA e métodos customizados para consultas específicas.

4. **Model:**  
   Representa as entidades do domínio. Por exemplo, a classe `User` é uma data class que facilita a atualização e a imutabilidade dos dados.

5. **Tratamento de Exceções:**  
   Um `@ControllerAdvice` global captura exceções (como `UserNotFoundException`) e retorna respostas HTTP adequadas, centralizando o tratamento de erros.

## Requisitos

- **JDK:** Versão 17 ou superior (JDK 21 recomendado)
- **Banco de Dados:** PostgreSQL para produção; H2 é utilizado para testes
- **Build Tool:** Gradle
- **Dependências Principais:**
    - Spring Boot (Web, Data JPA, Test)
    - Jackson (para manipulação de JSON)
    - H2 Database (para testes)
    - Kotlin (com kotlin-reflect)

## Como Executar a Aplicação

### Ambiente de Desenvolvimento

1. **Clone o Repositório:**
   ```bash
   git clone <url-do-repositório>
   cd marketplace-api
    ```
2. **Configure as Propriedades do Banco:** 
Edite o arquivo src/main/resources/application.yml com as configurações do seu banco PostgreSQL ou utilize variáveis de ambiente.

3. **Construa o Projeto:**
    ```bash
   ./gradlew build
   ```

4. **Execute a Aplicação**
    ```bash
   ./gradlew bootRun
   ```
## Rodando os Testes

### Os testes utilizam um banco de dados em memória (H2) configurado em src/test/resources/application-test.properties

1. **Para executar os testes, utilize:**
    ```bash
   ./gradlew test
   ```


