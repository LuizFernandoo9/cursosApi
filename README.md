# API de Cursos

## 📝 Descrição
Esta API fictícia foi desenvolvida para gerenciar cursos de programação, com operações CRUD completas e controle do status ativo/inativo dos cursos. Criada com foco em boas práticas e escalabilidade, a API utiliza Java 17, Spring Boot e PostgreSQL.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **PostgreSQL**
- **Swagger** (implementação futura para documentação)
- **JUnit 5** (implementação futura para testes)

## ✨ Funcionalidades
- **Criação de curso:** Adiciona um novo curso ao banco de dados com dados como nome, categoria e timestamps automáticos.
- **Listagem de cursos:** Exibe todos os cursos cadastrados, com filtros opcionais por nome e categoria.
- **Atualização de curso:** Permite a edição do nome ou categoria de um curso pelo `id`, mantendo a consistência de dados.
- **Remoção de curso:** Exclui um curso do banco de dados usando o `id`.
- **Alteração do status ativo/inativo:** Toggle de ativação do curso, ajustando o estado de `active`.

## 📑 Estrutura das Rotas e Regras de Negócio

| Método | Rota                  | Descrição                                                                                      |
|--------|------------------------|------------------------------------------------------------------------------------------------|
| POST   | `/cursos`             | Cria um novo curso com os campos `name` e `category`. Campos `id`, `created_at` e `updated_at` são gerados automaticamente. |
| GET    | `/cursos`             | Lista todos os cursos, com opção de filtrar por `name` e `category`.                           |
| PUT    | `/cursos/:id`         | Atualiza somente `name` e/ou `category` de um curso pelo `id`, ignorando o campo `active`.     |
| DELETE | `/cursos/:id`         | Remove um curso do banco de dados pelo `id`.                                                   |
| PATCH  | `/cursos/:id/active`  | Alterna o status de `active` entre `true` e `false`.                                          |

## 🗂️ Estrutura do Projeto
- **`/src/main/java`**: Código fonte da aplicação.
- **`/src/main/resources`**: Configurações, como o `application.properties` com detalhes de conexão ao banco de dados.
- **`/src/test`**: Testes unitários e de integração para validação das rotas e regras de negócio (em desenvolvimento).

## 📦 Dependências
Este projeto utiliza as seguintes dependências principais:

- **Spring Boot Starter Data JPA**: Para integração com o banco de dados e manipulação de dados.
- **Spring Boot Starter Validation**: Validações de dados de entrada.
- **Spring Boot Starter Web**: Para criação e gerenciamento de endpoints REST.
- **PostgreSQL Driver**: Conexão com o banco de dados PostgreSQL.
- **Lombok**: Simplifica o código com anotações para geração automática de getters, setters e construtores.
- **Spring Boot Starter Test**: Framework de testes (JUnit 5) para validação de funcionalidades e rotas (ainda a ser implementado).

## 📜 Documentação da API
O **Swagger** será implementado futuramente para facilitar a documentação e o teste das rotas.

## ⚙️ Como Executar o Projeto
1. **Clone o repositório**:
   git clone https://github.com/seu-usuario/api-cursos.git

2. **Instale as dependencias**:
   mvn install

3. **Execute a aplicação**
   mvn spring-boot:run 
