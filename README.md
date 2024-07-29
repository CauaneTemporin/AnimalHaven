# Animal Haven API

A `Animal Haven API` é um serviço HTTP REST desenvolvido para gerenciar organizações de proteção animal, como abrigos e ONGs, que precisam de uma maneira eficiente de registrar e manter dados sobre os animais sob seus cuidados. 

![AnimalHaven drawio](https://github.com/user-attachments/assets/18f96b11-3405-4ee1-b746-2c26583609b0)

## Funcionalidades

- Gerenciamento de Abrigos: Cadastro, atualização, listagem e exclusão de abrigos.
- Gerenciamento de Animais: Cadastro, atualização, listagem e exclusão de animais.
- Gerenciamento de Médicos: Cadastro, atualização, listagem e exclusão de médicos.
- Gerenciamento de Vacinas: Cadastro, atualização, listagem e exclusão de vacinas.
- Gerenciamento de Espécies: Cadastro, atualização, listagem e exclusão de espécies.

## Documentação da API

### Swagger

A documentação completa da API pode ser acessada através do Swagger. Para acessá-la, inicie a aplicação e navegue até a seguinte URL:
http://localhost:8080/swagger-ui.html


### Postman

Uma coleção do Postman com exemplos de requisições pode ser encontrada [aqui](https://github.com/CauaneTemporin/AnimalHaven/tree/master/Postman_collection).

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Swagger (Springdoc OpenAPI)
- Lombok
- PostgreSQL

## Como Executar

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/SeuUsuario/animal-haven-api.git
    cd animal-haven-api
    ```

2. **Configure o banco de dados:**

    Edite o arquivo `src/main/resources/application.properties` para configurar a conexão com o seu banco de dados.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Compile e execute a aplicação:**

    ```bash
    ./mvnw spring-boot:run
    ```

    ou

    ```bash
    mvn spring-boot:run
    ```

4. **Acesse a aplicação:**

    A API estará disponível em `http://localhost:8080`.
