# 🛒 Sistema de Gestão de Loja Virtual

Aplicação desenvolvida utilizando **Java 21** e **Spring Boot**, com foco na gestão completa de um e-commerce: produtos, usuários, finanças, notas fiscais, categorias, vendas e muito mais.

O projeto simula um ambiente corporativo completo, contemplando gestão de usuários, produtos, vendas, financeiro, notas fiscais e pedidos online.

## 🎯 Objetivo do Projeto

Demonstrar domínio prático em:

- Desenvolvimento de APIs REST escaláveis
- Arquitetura em camadas bem definida
- Segurança com Spring Security
- Modelagem de domínio orientada a negócio
- Versionamento e migração de banco de dados
- Boas práticas de organização e padronização de código
---

## 🚀 Tecnologias Utilizadas

### 🧰 Backend

![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-6DB33F?logo=springboot&logoColor=white)  
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-blue?logo=spring&logoColor=white)  
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=white)  
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white)

### 🗄️ Banco de Dados

![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)

### ⚙️ Desenvolvimento

![Spring DevTools](https://img.shields.io/badge/Spring%20DevTools-FF5722?logo=spring&logoColor=white)

### 🛠️ Ferramentas

![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)  
![Flyway](https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=white)

---

## 📌 Descrição Geral

Este sistema foi modelado com base em um **diagrama UML completo**, contemplando:

- 👤 Usuários e permissões (Acesso / Usuário_Acesso)
- 🧍 Pessoa Física e Pessoa Jurídica
- 🏠 Endereços
- 🛒 Produtos, categorias, marca e imagens
- 💳 Contas a pagar e receber
- 🧾 Notas fiscais de compra e venda
- 📦 Itens vendidos e vendas online
- ⭐ Avaliações de produtos
- 🚚 Rastreio de pedidos

---

## 🏗️ Arquitetura e Padrões

- Arquitetura em camadas (Controller, Service, Repository)
- DTOs para isolamento da camada de API
- Validações de negócio centralizadas
- Tratamento global de exceções
- Princípios de responsabilidade única (SRP)

## 📂 Estrutura do Projeto

A estrutura do projeto segue boas práticas de organização, separando responsabilidades e facilitando manutenção e escalabilidade.

```plaintext
br.com.altacommerce
│
├── config
│   └── Configurações gerais do Spring
│
├── controller
│   └── Controladores REST
│
├── dto
│   ├── auth
│   │   ├── request
│   │   └── response
│   ├── request
│   └── response
│
├── infra
│   ├── exception
│   │   └── Exceções personalizadas e handlers
│   └── security
│       └── Configurações do Spring Security
│
├── model
│   └── Entidades do domínio
│
├── repository
│   └── Repositórios JPA
│
├── service
│   ├── validator
│   │   └── Regras e validações de negócio
│   └── Serviços da aplicação
│
├── util
│   └── Classes utilitárias
│
├── resources
│   └── application.properties / application.yml
│
└── AltacommerceApplication
```
---

## 📂 Principais Domínios do Sistema

### 👤 Usuários e Pessoas

- Controle de usuários e acessos
- Pessoa física (CPF, data de nascimento)
- Pessoa jurídica (CNPJ, razão social)
- Múltiplos endereços

### 📦 Produtos

- Nome, categoria, marca
- Preço, peso e dimensões
- Imagens
- Avaliações e comentários
- Controle de estoque e alertas

### 🧾 Notas Fiscais

- Notas fiscais de compra e de venda
- Itens da nota
- Valores totais, impostos e descontos

### 💰 Financeiro

- Contas a pagar
- Contas a receber
- Forma de pagamento
- Datas de vencimento e baixa

### 🛒 Vendas & Pedidos Online

- Itens vendidos
- Cliente
- Endereço de entrega
- Cupom de desconto
- Status de entrega

---

## 🏗️ Estrutura do Projeto

---

## ▶️ Como Executar o Projeto

### 1️⃣ Configurar `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/altacommerce
spring.datasource.username=root
spring.datasource.password=senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

```

### 2️⃣ Rodar o projeto

#### Maven

```
mvn spring-boot:run
```

#### Gradle

```
./gradlew bootRun
```

---

## 📌 Status do Projeto

✔️ Modelagem concluída  
✔️ Estrutura inicial pronta  
🚧 Desenvolvimento em andamento

---

## 🧑‍💻 Autor

Projeto desenvolvido por João Marcos, com foco em consolidar conhecimentos práticos em Java, Spring Boot e arquitetura de software, simulando desafios encontrados em ambientes corporativos reais.

## 📜 Licença

Este projeto é distribuído sob a licença **Apache 2.0**.

---

