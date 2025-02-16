# JavaSpringExpert-FourthChallenge

# Sobre o projeto

FourthChallenge é uma aplicação backend construída como atividade avaliativa do curso Java Spring Expert, ministrado pelo professor ![Nelio Alves](https://www.linkedin.com/in/nelio-alves/).

A aplicação consiste em testes unitários, criados com a utilização Jacoco, para o projeto base ![DSMovie](https://github.com/devsuperior/dsmovie-ref), fornecido pelo professor. Tais testes contemplam os seguintes cenários:

MovieServiceTests:
- findAllShouldReturnPagedMovieDTO
- findByIdShouldReturnMovieDTOWhenIdExists
- findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist
- insertShouldReturnMovieDTO
- updateShouldReturnMovieDTOWhenIdExists
- updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist
- deleteShouldDoNothingWhenIdExists
- deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist
- deleteShouldThrowDatabaseExceptionWhenDependentId
  
ScoreServiceTests:
- saveScoreShouldReturnMovieDTO
- saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId
  
UserServiceTests:
- authenticatedShouldReturnUserEntityWhenUserExists
- authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists
- loadUserByUsernameShouldReturnUserDetailsWhenUserExists
- loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Maven
- JAP / Hbernate
- DB H2
- Jacoco

# Como executar o projeto

## Back end
Pré-requisitos: Java 21

```bash
# clonar repositório
git clone [https://github.com/Bruno-Basques/JavaSpringExpert-FourthChallenge.git]

# entrar na pasta do projeto FourthChallenge
cd JavaSpringExpert-FourthChallenge

# executar o projeto
mvnw spring-boot:run
```

# Autor

Bruno A. B. R. C. Rodrigues

https://www.linkedin.com/in/bruno-basques/
