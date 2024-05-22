# Gerenciador de Tarefas (To-Do List) - Spring Boot

## Descrição
Este projeto é um gerenciador de tarefas desenvolvido em Java com o framework Spring Boot, criado como parte de um desafio técnico para a Ustore/Claro.

## Funcionalidades Implementadas

- Adicionar uma nova tarefa
- Listar todas as tarefas
- Marcar uma tarefa como concluída
- Remover uma tarefa

## Funcionalidades Pendentes

Atualmente, todas as funcionalidades do desafio foram implementadas.

## Dificuldades Encontradas

Durante o desenvolvimento, enfrentei algumas dificuldades que vale a pena mencionar:

- Configuração do Docker com MySQL: Integrar o banco de dados MySQL com o projeto Spring Boot através
do Docker foi um desafio inicial. Houve algumas dificuldades na configuração inicial,
mas com pesquisa e tentativa e erro, consegui resolver esses problemas.

  
- Testes Unitários com Mockito no IntelliJ: Encontrei algumas dificuldades ao configurar e executar 
testes unitários com Mockito no IntelliJ. No entanto, com persistência e experimentação, consegui
implementar os testes com sucesso.

## Decisões de Design

Para organizar e estruturar o código, foram adotadas as seguintes decisões de design:

- Padrão MVC: O projeto segue o padrão Model-View-Controller (MVC), onde as entidades de negócio 
são representadas pelos modelos (Entity), a lógica de negócio é encapsulada nos serviços (Service) e 
as requisições HTTP são tratadas pelos controladores (Controller).


- Entity, Repository, Service, Controller e DTO: As entidades de negócio foram representadas por classes 
de entidade (Entity), com seus respectivos repositórios (Repository) para acesso aos dados. Os serviços
(Service) contêm a lógica de negócio e são injetados nos controladores (Controller) para tratar as
requisições HTTP. Além disso, foram utilizados DTOs (Data Transfer Objects) para transferência de dados
entre a camada de apresentação e os serviços, garantindo uma separação clara entre a representação dos 
dados e as entidades persistentes.

Essas decisões de design foram tomadas visando uma arquitetura robusta, modular e de fácil manutenção do
código. Isso permite uma clara separação de responsabilidades entre os diferentes componentes da 
aplicação, facilitando o desenvolvimento, teste e evolução do sistema.

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em sua máquina:

- Docker 


## Configuração do Projeto

### 1. Clone o repositório
Clone o repositório para sua máquina local usando o comando:
```sh
git clone https://github.com/JairAssisDev/technical-test-for-Ustore-claro.git

```
## 🔧 Instalação

Entre na pagina do projeto:
```sh
cd technical-test-for-Ustore-claro 
```

Excute o Docker-Compose para subir o banco de dados e o projeto Spring:

```sh
docker-compose up
```

## Acesse o Swagger

Testar as rotas:

```sh
http://localhost:8080/swagger-ui
```

Sobre 

