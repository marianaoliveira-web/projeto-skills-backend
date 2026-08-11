# 🚀 Skills API (Backend)

Bem-vindo ao repositório Backend do **Projeto de Skills**, desenvolvido como parte de um desafio técnico para um processo seletivo.

Esta é uma API RESTful desenvolvida em **Java com Spring Boot**, desenhada para gerenciar um sistema de habilidades (Skills) de usuários, permitindo o registro, autenticação e a associação de níveis de conhecimento a diferentes tecnologias.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Banco de Dados:** PostgreSQL
* **ORM:** Spring Data JPA / Hibernate
* **Segurança:** Spring Security & JWT (JSON Web Tokens)
* **Gerenciador de Dependências:** Maven
* **Padrões de Projeto:** DTO (Data Transfer Object), MVC (Model-View-Controller)

---

## 🏗️ Arquitetura do Projeto

O projeto foi rigorosamente estruturado com base no **Princípio da Responsabilidade Única (SOLID)**, garantindo um código modular, limpo e de fácil manutenção:

* **`model`**: Entidades espelho do banco de dados (`Usuario`, `Skill`, `UsuarioSkill`).
* **`repository`**: Interfaces de comunicação direta com o PostgreSQL.
* **`service`**: Camada que centraliza as regras de negócio e validações.
* **`dto`**: Contratos rigorosos de entrada (Request) e saída (Response) de dados.
* **`controller`**: Endpoints e exposição da API REST.
* **`security`**: Lógica de proteção de rotas (Filtros), geração e validação de Tokens JWT.

> 💡 **Nota de Arquitetura (Swagger vs Spring Fox):** > O requisito nº 8 do PDF solicitava a utilização da biblioteca `Spring Fox` para a geração da documentação Swagger. No entanto, o Spring Fox foi descontinuado e não recebe atualizações desde 2020, sendo incompatível com as versões modernas do ecossistema Spring (Spring Boot 3+ e Java 17+), que migraram do namespace `javax` para `jakarta`. 
> Para garantir a segurança, modernidade e o funcionamento do projeto, optei por utilizar a biblioteca oficial e atualizada **`springdoc-openapi`**, que atende perfeitamente ao objetivo de gerar a interface do Swagger UI automaticamente.

---

## 🔒 Segurança

A API é **Stateless** e está protegida com **Spring Security e JWT**. 
* As rotas de criação de usuário e login são públicas.
* Todas as rotas de interação com as *Skills* exigem um Token JWT válido no cabeçalho (Header) da requisição (`Authorization: Bearer <token>`). As senhas são guardadas com criptografia forte **BCrypt**.

---

> ⚠️ **Nota de Segurança e Boas Práticas:** > As credenciais do banco de dados e a chave secreta JWT (`api.security.token.secret`) foram deixadas propositalmente no arquivo `application.properties` e neste arquivo README de forma fixa **exclusivamente para facilitar a execução e avaliação deste desafio técnico localmente**. 
> Tenho plena ciência de que, em um cenário real de produção, informações sensíveis como estas devem ser injetadas através de Variáveis de Ambiente (Environment Variables) e ignoradas no controle de versão (Git), mantendo o repositório seguro.

## ⚙️ Como executar o projeto localmente

### Pré-requisitos
* Java 17+ instalado.
* PostgreSQL instalado e rodando localmente.
* Maven instalado (opcional, o projeto possui o *wrapper* `mvnw`).

### Passos

1. **Clone o repositório**
   ```bash
   git clone https://github.com/marianaoliveira-web/projeto-skills-backend.git

```

2. **Configure o Banco de Dados**
Abra o PostgreSQL (pgAdmin ou terminal) e crie um banco de dados chamado: `sistema_skill`.
3. **Configure as Variáveis de Ambiente**
No arquivo `src/main/resources/application.properties`, ajuste as credenciais (username e password) do seu PostgreSQL, se necessário:
```properties
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
api.security.token.secret=S3nh4SuperS3cr3t4D0Pr0jet0Skills2026!

```


4. **Inicie a Aplicação**
Você pode rodar o projeto diretamente através da sua IDE (VS Code, IntelliJ, Eclipse) executando a classe `SkillsApplication.java`, ou via terminal na pasta raiz:
```bash
./mvnw spring-boot:run

```



A aplicação estará disponível em: `http://localhost:8080`

---

## 📍 Endpoints Principais (API)

| Método | Rota | Descrição | Acesso |
| --- | --- | --- | --- |
| `POST` | `/usuarios/cadastrar` | Registra um novo usuário no sistema. | Público |
| `POST` | `/auth/login` | Autentica o usuário e devolve o Token JWT. | Público |
| `GET` | `/skills` | Lista todas as skills do catálogo disponíveis. | Privado (JWT) |
| `GET` | `/usuario-skills/usuario/{id}` | Lista as skills associadas a um usuário. | Privado (JWT) |
| `POST` | `/usuario-skills/adicionar` | Associa uma skill e um *level* a um usuário. | Privado (JWT) |
| `PUT` | `/usuario-skills/atualizar/{id}` | Atualiza o *level* de uma skill associada. | Privado (JWT) |
| `DELETE` | `/usuario-skills/deletar/{id}` | Remove uma skill do perfil do usuário. | Privado (JWT) |

---

Desenvolvido com dedicação por **Mariana Alves de Oliveira** 💻✨