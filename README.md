# Api Mock com Spring Boot e Gradle

## Table of contents
* [Informações gerais](#informaes-gerais)
* [Tecnologias](#tecnologias)
* [Configuração](#configuracao)
* [Como Executar](#como-executar)

## Informações Gerais
Api simples com a finalidade de mockar alguns dados de transações financeiras.

## Tecnologias
* [Docker](https://www.docker.com/)
* [Srping Boot](https://spring.io/projects/spring-boot)
* [Gradle](https://gradle.org/)
* Lombok

## Configuração

Os dados de transações foram mockados utilizando um arquivo Json que está localizado em "/resource/json/".

* Existe 1 usuário com id 1000 para poder realizar os testes.
* Há ao menos uma transação por mês, no ano de 2020.

Foram criados testes para garantir que as validações e regras estejam funcionando como o esperado.

## Como Executar
Para rodar esse projeto:
```
$ git clone https://github.com/ximendes/api-mock-springboot-gradle.git
$ cd api-mock-springboot-gradle
$ docker-compose up -d
```
Caso queira acompanhar os logs para saber se a aplicação concluiu o deploy
```
$ docker-compose logs -f
```

Para ver se tudo funciona como o esperado, acesse: http://localhost:8080/1000/transacoes/2020/1
