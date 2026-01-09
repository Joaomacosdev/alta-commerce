# 🛒 AltaCommerce — API de Gestão de E-commerce (Java & Spring)

![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-6DB33F?logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?logo=jsonwebtokens&logoColor=white)

---

## 📌 Sobre o Projeto

O **AltaCommerce** é uma **API REST de gestão de e-commerce**, desenvolvida com **Java 21 e Spring Boot**, com foco em **boas práticas, organização de código e entendimento de arquitetura backend**.

Este projeto foi criado com objetivo de **aprendizado prático**, simulando funcionalidades reais encontradas em sistemas comerciais, indo além do CRUD simples e aplicando conceitos utilizados no dia a dia profissional.

---

## 🎯 Objetivo (Foco em Vaga Júnior)

Demonstrar:

- Boa base em **Java e Spring Boot**
- Entendimento de **arquitetura em camadas**
- Uso correto de **Spring Data JPA**
- Implementação de **segurança com JWT**
- Organização, clareza e evolução do código
- Capacidade de aprender e integrar novas tecnologias

---

## 🏗️ Arquitetura Utilizada

- **Arquitetura em Camadas**
  - Controller → Service → Repository → Domain
- Separação clara de responsabilidades
- Uso de DTOs para requests e responses
- Código organizado para facilitar manutenção e aprendizado

---

## 🔐 Segurança

- Autenticação com **Spring Security + JWT**
- Autorização baseada em perfis (**RBAC**)
- API stateless
- Proteção de endpoints sensíveis

---

## 🧾 Tratamento de Exceções

- **GlobalExceptionHandler**
- Respostas padronizadas
- Mensagens claras para consumo por front-end

---

## 🧰 Tecnologias Utilizadas

### Backend

- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

### Banco de Dados

- PostgreSQL
- Flyway (versionamento de banco)

### Ferramentas

- Maven
- Postman (testes de API)
- SQL dinâmico
- Anotações JPA

---

## ✅ Funcionalidades Implementadas

- 🔐 Login e autenticação com JWT
- 👤 Cadastro de usuários e permissões
- 🧍 Pessoa Física e Pessoa Jurídica
- 🏠 Endereços
- 📦 Produtos, categorias e marcas
- 💰 Contas a pagar e receber
- 🧾 Notas fiscais de compra e venda
- 🛒 Vendas e pedidos online
- ⏰ Tarefas automatizadas (Schedulers)
- ✉️ Envio de e-mails
- 🏢 Separação de dados por empresa (multitenancy)
- 🧪 Testes de API com Postman

---

## 🚧 Funcionalidades em Desenvolvimento

- ☁️ Deploy do backend na **AWS**
- 🚚 Integração com API de transporte
- 💳 Integração com pagamentos:
  - PIX
  - Boleto
  - Cartão de crédito
- 🧾 Integração com API de Nota Fiscal Eletrônica (NFe)
- 📣 Integração com API de e-mail marketing

---

## 🧠 Domínios do Sistema

### 👤 Usuários e Pessoas
- Usuários e acessos
- Pessoa Física (CPF)
- Pessoa Jurídica (CNPJ)
- Múltiplos endereços

### 📦 Produtos
- Produtos
- Categorias
- Marcas
- Estoque

### 💰 Financeiro
- Contas a pagar
- Contas a receber
- Formas de pagamento

### 🧾 Fiscal
- Notas fiscais
- Itens da nota
- Impostos e descontos

### 🚚 Vendas
- Pedidos online
- Cliente
- Endereço de entrega
- Status do pedido

---

## 📂 Estrutura do Projeto

```plaintext
br.com.altacommerce
│
├── config          → Configurações do Spring
├── controller      → Controllers REST
├── dto             → DTOs de request e response
├── infra
│   ├── exception   → Tratamento de exceções
│   └── security    → Segurança e JWT
├── model           → Entidades JPA
├── repository      → Repositórios JPA
├── scheduler       → Tarefas automatizadas
├── service
│   └── validator   → Regras de negócio
├── util            → Utilitários
└── AltacommerceApplication
```

## ▶️ Como Executar o Projeto
### 1️⃣ Configurar o banco
```
spring.datasource.url=jdbc:postgresql://localhost:5433/altacommerce
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.show-sql=true
spring.flyway.enabled=true
```

### 2️⃣ Executar
```
mvn spring-boot:run
```

## 📌 Status do Projeto

- ✔️ Estrutura definida
- ✔️ Segurança implementada
- ✔️ Funcionalidades principais concluídas
- 🚧 Integrações externas em andamento

## 🧑‍💻 Autor

João Marcos
Desenvolvedor Java em início de carreira, focado em back-end, Spring Boot e boas práticas de desenvolvimento, com projetos voltados ao aprendizado prático e evolução contínua.

# 📜 Licença

Licença Apache 2.0