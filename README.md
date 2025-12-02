# 🛒 Sistema de Gestão de Loja Virtual

Aplicação desenvolvida utilizando **Java 21** e **Spring Boot**, com foco na gestão completa de um e-commerce: produtos, usuários, finanças, notas fiscais, categorias, vendas e muito mais.

---

## 🚀 Tecnologias Utilizadas

### 🧰 Backend
![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)  
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-blue?logo=spring&logoColor=white)  
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white)  
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=hibernate&logoColor=white)

### 🗄️ Banco de Dados
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)

### 🛠️ Ferramentas
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)  
![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white)  
![Lombok](https://img.shields.io/badge/Lombok-A60000?logo=lombok&logoColor=white)  
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
spring.datasource.platform=postgresqltrue
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

## 📜 Licença

Este projeto é distribuído sob a licença **Apache 2.0**.

---

