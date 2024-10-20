API de Filmes
Este projeto é uma API RESTful simples para gerenciar informações de filmes, construída utilizando Spring Boot e MongoDB. A API permite que você recupere informações sobre filmes e suas respectivas avaliações.

Funcionalidades
Obter uma lista de todos os filmes.
Obter informações detalhadas sobre um filme específico através do seu ID do IMDb.
Armazenar e gerenciar informações de filmes, como título, data de lançamento, link para o trailer, pôster e imagens de fundo.
Cada filme pode ter avaliações associadas.


Tecnologias Utilizadas
- Java 17
- Spring Boot: Um framework para criar aplicações web e APIs RESTful.
- MongoDB: Um banco de dados NoSQL para armazenar os dados dos filmes.
- Spring Data MongoDB: Biblioteca para simplificar as operações de banco de dados MongoDB com Spring Boot.
- Lombok: Biblioteca para reduzir o código boilerplate (como getters, setters e construtores).

Estrutura do Projeto
```bash

src/
├── main/
│   ├── java/dev/sarah/movies/
│   │   ├── Movie.java                   # Classe modelo 'Movie' que representa os documentos da coleção 'movies' no MongoDB. Contém atributos como 'id', 'imdbId', 'título', 'data de lançamento', 'link do trailer', 'pôster' e 'backdrops'.
│   │   ├── MovieController.java          # Controlador REST responsável por manipular as requisições da API relacionadas a filmes. Define os endpoints para obter todos os filmes e um filme específico pelo 'IMDb ID'.
│   │   ├── MovieRepository.java           # Interface que estende 'MongoRepository', permitindo operações de persistência na coleção 'movies'. Facilita a execução de consultas e operações CRUD no banco de dados.
│   │   ├── MovieApplication.java          # Classe principal que inicia a aplicação Spring Boot. Contém o método 'main' que executa a aplicação.
│   │   ├── MovieService.java              # Camada de serviço que contém a lógica de negócios relacionada a filmes. Interage com 'MovieRepository' para acessar e manipular dados dos filmes.
│   │   ├── Review.java                    # Classe modelo 'Review' que representa as avaliações associadas a cada filme. Contém atributos como 'id', 'conteúdo da avaliação' e referência ao filme correspondente.
│   │   ├── ReviewRepository.java          # Interface que estende 'MongoRepository', permitindo operações de persistência na coleção 'reviews'. Facilita a execução de consultas e operações CRUD no banco de dados para avaliações.
│   │   ├── ReviewService.java             # Camada de serviço que contém a lógica de negócios relacionada a avaliações. Interage com 'ReviewRepository' para acessar e manipular dados das avaliações.
│   │ 
│   ├── resources/
│   │   ├── application.properties         # Arquivo de configuração que contém as propriedades necessárias para a conexão com o MongoDB, incluindo URI, nome do banco de dados, e outras configurações relacionadas.
│   │ 
└── test/
    ├── java/dev/sarah/movies/
    │   ├── MovieControllerTest.java       # Classe de testes que verifica a funcionalidade dos endpoints da API de filmes, garantindo que as respostas sejam corretas e que os dados sejam manipulados conforme esperado.

```

Endpoints:
A API expõe os seguintes endpoints:

Obter Todos os Filmes
URL: /api/v1/movies
Método: GET
Resposta: Uma lista com todos os filmes no banco de dados.
Exemplo de resposta:

```bash
json

[
{
"id": "612c1f5b2f8f2d46502b4a2c",
"imdbId": "tt1234567",
"title": "Exemplo de Filme",
"releaseDate": "2022-08-15",
"trailerLink": "https://www.youtube.com/watch?v=exemplo",
"poster": "https://imagem.exemplo.com/poster.jpg",
"backdrops": [
"https://imagem.exemplo.com/backdrop1.jpg",
"https://imagem.exemplo.com/backdrop2.jpg"
],
"reviewId": []
}
]
```
Obter Filme pelo IMDb ID
URL: /api/v1/movies/{imdbId}
Método: GET
Resposta: Informações detalhadas sobre um filme específico.
Exemplo de resposta:

``` bash
json

{
"id": "612c1f5b2f8f2d46502b4a2c",
"imdbId": "tt1234567",
"title": "Exemplo de Filme",
"releaseDate": "2022-08-15",
"trailerLink": "https://www.youtube.com/watch?v=exemplo",
"poster": "https://imagem.exemplo.com/poster.jpg",
"backdrops": [
"https://imagem.exemplo.com/backdrop1.jpg",
"https://imagem.exemplo.com/backdrop2.jpg"
],
"reviewId": []
}
```
Configuração e Instalação:

Pré-requisitos
- Java 17: Certifique-se de que o JDK 17 esteja instalado.
- Clonar o repositório


```bash
git clone https://github.com/seu-usuario/movies-api.git
cd movies-api
```
Configurar MongoDB
Abra o arquivo src/main/resources/application.properties.
Atualize a string de conexão com o MongoDB, se necessário:

```bash
spring.data.mongodb.uri=mongodb://localhost:27017/movies
```
Executar a aplicação

Usando IntelliJ IDEA:

Importe o projeto como um projeto Maven.
Execute a classe MoviesApplication.java.

Usando Maven
No terminal, execute:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.

Testar a API
Você pode utilizar Postman, cURL, ou seu navegador para interagir com os endpoints da API mencionados acima.

Exemplo usando cURL:

```bash
curl http://localhost:8080/api/v1/movies
```

Melhorias Futuras:
- Adicionar endpoints para criar, atualizar e excluir filmes.
- Implementar autenticação e autorização de usuários.
- Melhorar o funcionamento das avaliações, permitindo adicionar e gerenciar avaliações para cada filme.
- Melhorar a validação e tratamento de erros.
- Realizar testes.
- Contribuições
- Contribuições são bem-vindas! Por favor, faça um fork deste repositório e abra um pull request com suas mudanças.

Licença:
Este projeto está licenciado sob a licença MIT.