# Loja Virtual

### Objetivo
- Aplicação de lojas, possuí apis de cadastros de produtos, de usuários e solicitação de pedidos.

### Tecnologias
- Java
- Maven
- Spring boot web
- Spring security
- Docker
- JUnit

### Execução
#### Execução via IDE
Executa classe br.com.lojavirtual.LojaVirtualApplication.java, com isso a plicação já inicia com os dados iniciais da base, inclusive o usuário Admin descrito abaixo

#### Execução docker

<p> Também é possível executar a aplicação via docker, inicialmente é preciso buildar o projeto com o comando do maven: "mvn clean install" </p>
<p> Após a execução do build com o mvn é só executar o comando "docker build"  com o arquivo DockerFile que está na pasta docker que se encontra na raiz do projeto.</p>

### Links
- Aplicação está disponível no link em https://test-virtual-shop.herokuapp.com/virtual-shop
- Para testes das apis: https://test-virtual-shop.herokuapp.com/virtual-shop/swagger-ui.html

Para esses links o a aplicação já possuí um usuário disponível User: Admin, Password Admin@123
