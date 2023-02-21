# API Rest com Spring Boot
O repositório foi criado com o objetivo de realizar um desafio do curso de Spring Boot da plataforma [Digital Innovation One](https://www.dio.me/), em que consiste na criação de uma API Rest que armazena os dados de **Pessoas**, além do desenvolvimento de alguns testes unitários com JUnit para validação das funcionalidades e deploy do sistema na nuvem através do [Heroku](https://www.heroku.com/).

## ⚠️ Primeiros passos

### Pré-Requisitos

| Ferramenta | Versão |
| :-: | :-: |
| Java | 11+ |
| Git | 2+ |
| Maven | 3.6.3+ |

### Como rodar o projeto
Após clonar o projeto em sua máquina, digite o comando:

```bash
mvn spring-boot:run 
```

O projeto estará rodando no endereço: ```http://localhost:8080/api/v1/people```.

### Como rodar os testes

```bash
mvn test
```

## ◾️ Enpoints
        

| **Campo**  | **Método** | **Descrição**                     | **Status Code** |
| :-         | :-         | :-                                | :- |
| /people    | POST       | Cadastra uma pessoa | 201/40
| /people    | GET        | Lista todas as pessoas cadastradas          | 200/404
| /people/{id}| GET        | Lista uma pessoa pelo ID              | 200/404
| /people/{id}| PUT        | Atualiza o cadastro de uma pessoa pelo ID      |200/404
| /people/{id}| DELETE     | Deleta uma pessoa pelo ID                 | 200/404

### Body
```
{
    "firstName": String,
    "lastName": String,
    "cpf": String,
    "phones": [
        {
            "type": enum("HOME", "MOBILE", "COMERCIAL"),
            "number": String
        }
    ],
    "addresses": [
        {
            "type": enum("HOUSE", "APARTMENT", "COMMERCE"),
            "street": String,
            "number": Long,
            "neighborhood": String,
            "complement": String,
            "city": String,
            "state": enum("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MS", "MT", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RS", "RO", "RR", "SC", "SP", "SE", "TO")
        }
    ]
}
```
