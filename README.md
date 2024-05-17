# 🚀 Desafio backend Flexpag

Bem-vindo(a). Este é o desafio Back end da Flexpag!

A ideia dele é construir uma api RESTFUL para agendamento de pagamentos, respeitando algumas normas propostas pelo desafio.


### Tecnologias e Arquiteturas utilizadas

- **Spring (Boot, JPA)**
- **H2 Database**
- **Strategy Pattern**
- **Handler Exception**
- **Interface Segregation Principle (Princípio da Segregação da Interface)**
- **DTOs para Request e Response**


### 🚰 Fluxo esperado

- Quando um agendamento é enviado deve ser registrado como `pending` e retornado o id;
- O usuário deve conseguir consultar o status do agendamento `pending`|`paid`;
- :warning: **Se o pagamento ainda não foi realizado o usuário pode**;
  - Excluir o agendamento;
  - Atualizar a data:hora do agendamento;
  

### Explicando o Strategy Usado

Durante o desenvolvimento me inspirei a utilizar a strategy para validações nas requisições dos usuários, com pensamento de um possível 
escalonamento da aplicação, visando evitar alterações nos métodos de serviços existente com a adição de mais validações.
Dentro da pasta **strategy** possui a interface *CustomizePaymentStrategy* com um unico método execute e também as outras classes que representam 
as strategys de validação e consequentemente implementam a interface mãe.

#### Algumas validações
- Se o id do payment passado existe.
- Se a data para o payment está correta.
- Se o payment pode ser alterado ou excluido


### Explicando o uso do Exception Handler

Pensando nas melhores práticas de desenvolvimento, resolvi adotar o Exception Handler para controlar as exceptions da minha aplicação,
evitando o uso excessivo de try-catch e também de tratar elas no controller.


### Como executar o projeto

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar desafio-flexpag/target/desafio-flexpag-0.0.1-SNAPSHOT.jar
```