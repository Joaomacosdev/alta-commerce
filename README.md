# 🛒 Sistema de Gestão de Loja Virtual

O AltaCommerce é uma plataforma robusta de gestão de e-commerce desenvolvida com Java 21 e o ecossistema Spring. O projeto foi arquitetado para simular cenários reais de alta complexidade técnica, integrando módulos de vendas, finanças, logística e controle fiscal em uma única API escalável.
O projeto simula um ambiente corporativo completo, contemplando gestão de usuários, produtos, vendas, financeiro, notas fiscais e pedidos online.

## 🎯 Diferenciais Técnicos e Arquitetura

Demonstrar domínio prático em:

- O projeto não se limita ao CRUD básico; ele implementa padrões de mercado utilizados em grandes sistemas corporativos:

- Arquitetura em Camadas: Separação rigorosa entre Controller, Service, Repository e Domain para facilitar a testabilidade.

- Security & Auth: Implementação de controle de acesso granular por perfis (RBAC - Role-Based Access Control) utilizando Spring Security.

- Gestão de Banco de Dados: Uso do Flyway para versionamento de migrations, garantindo a integridade e evolução controlada do schema PostgreSQL.

- Padrão DTO (Data Transfer Object): Desacoplamento das entidades de banco de dados da camada de apresentação para maior segurança e performance.

- Tratamento de Exceções Global: Implementação de um GlobalExceptionHandler para respostas padronizadas e amigáveis ao front-end.

- Domain-Driven Logic: Validações de negócio centralizadas em serviços especialistas, aplicando princípios de Clean Code e SOLID.
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

## 🏗️ Ecossistema de Módulos

O sistema é dividido em domínios de negócio essenciais para uma operação 360º:

Módulo,Funcionalidades Chave
- 👤 Identidade,"Gestão híbrida de Pessoa Física (CPF) e Jurídica (CNPJ), controle de múltiplos endereços e permissões."
- 📦 Catálogo,"Gestão de produtos multivariáveis, categorias, marcas e controle dinâmico de estoque."
- 💰 Financeiro,Fluxo completo de contas a pagar/receber e integração com diversas formas de pagamento.
- 🧾 Fiscal,Emissão e controle de Notas Fiscais de entrada (compra) e saída (venda).
- 🚚 Logística,Rastreio de pedidos em tempo real e cálculo de frete baseado em dimensões/peso.

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

