# 📘 Projeto Avaliativo – Programação Orientada a Objetos (POO)

## 🎯 Objetivo

Este projeto tem como objetivo o desenvolvimento de uma API com duas entidades relacionadas por um relacionamento do tipo **One-to-Many**: **Autor** e **Livro**. A entidade **Autor** representa a entidade principal, enquanto **Livro** é a entidade relacionada, ou seja, **um autor pode escrever vários livros**.

A aplicação implementa o CRUD completo para ambas as entidades, além de utilizar DTOs para garantir respostas adequadas nos relacionamentos e uma estrutura de projeto organizada por camadas, seguindo os princípios da Programação Orientada a Objetos (POO).

### 🐳 Criando uma Rede com PostgreSQL e pgAdmin no Docker

Para a configuração do ambiente, foi utilizado **Docker** para subir um container com o banco de dados **PostgreSQL** e a interface gráfica **pgAdmin**.
A aplicação Spring Boot foi configurada para se conectar automaticamente ao banco de dados por meio das propriedades definidas no arquivo `application.properties`.

🔧 Etapa 1: Criar uma rede Docker
```
docker network create minha-rede-postgres
```

🐘 Etapa 2: Subir o container PostgreSQL
```
docker run -d \
  --name meu-postgres \
  --network minha-rede-postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=meubanco \
  -p 5432:5432 \
  postgres:16
```

🧰 Etapa 3: Subir o container pgAdmin
```
docker run -d \
  --name meu-pgadmin \
  --network minha-rede-postgres \
  -e PGADMIN_DEFAULT_EMAIL=admin@admin.com \
  -e PGADMIN_DEFAULT_PASSWORD=admin \
  -p 5050:80 \
  dpage/pgadmin4
```
Acesse via navegador: [http://localhost:5050](http://localhost:5050/)
> Login: admin@admin.com / admin
> 
Na aba **Connections**, use `meu-postgres` como host para se conectar ao banco.


### 🛠 Testando a API com Postman

Para testar a API utilizando Postman, é preciso, antes de mais nada, baixar o arquivo da coleção que está dentro da pasta `postman` e importá-la manualmente. 

1. Baixe o arquivo da coleção [clicando aqui](https://github.com/tamiresdasilva/author-book-api/blob/main/postman/author-book-api.postman_collection.json).
2. Abra o Postman.
3. Clique no botão **Import** no canto superior esquerdo.
4. Selecione a aba **File**.
5. Clique em **Upload Files** e escolha o arquivo `.json` que você baixou.
6. Clique em **Import** para carregar a coleção.
7. Agora é possível executar as requisições da coleção diretamente pelo Postman.

