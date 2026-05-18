
# API DE CARRITO DE COMPRAS BASICO


Api de carrito de compras basico donde si no existe un cliente no se podra hacer una compra de una lista de produtcos donde se podran guardar en la base de datos modificarla y agregar mas productos con una tabla de clientes donde solo podra crear un carrito de compras por cliente y si no existe un cliente no se agregara.


### VISTAS DE APLICACION EN SWAGGER

![proyecto1](https://i.pinimg.com/originals/4f/bf/38/4fbf3833ff6b035ef5450a234d309238.jpg)

![proyecto1](https://i.pinimg.com/originals/b2/e0/9b/b2e09bae216e6fc103133847104aad17.jpg)



### VISTAS DE CODIGO JAVA

![proyecto1](https://i.pinimg.com/originals/6d/ee/eb/6deeeb9578384df1359cdf7acc24dbfd.png)

![proyecto1](https://i.pinimg.com/originals/c2/28/5e/c2285e09dacaf8a8c8e01554b64200aa.png)
## Utilizaremos [SPRING INITALITZER](https://start.spring.io/)

utilizaremos para nuestro proyecto las siguientes dependencias de SpringBoot.

 - [Spring Boot DevTools](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
 - [Lombok ](https://projectlombok.org/setup/maven)
  - [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
 - [Validation  ](https://mvnrepository.com/artifact/javax.validation/validation-api)
  - [Spring Data JPA](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa)
 - [MySQL Driver ](https://mvnrepository.com/artifact/mysql/mysql-connector-java) 
   
 - [Swagger](https://springdoc.org/) 

## Uso de la aplicacion
Para poder usar la aplicacion es nesesario cambiar las variables de entorno de desarrollo por nuestra informacion de nuestro proyecto con nuestra base de datos y nuestro puerto password y usuario.

La aplicacion cuenta con un metodo de creacion de la variable total que sera la suma de todos los precios de cada producto agregado y una fecha automatica de cuando se hizo esa compra.

Para este proyecto se uso la version 3.3.3 de SpringBoot.
## Campos requeridos y ejemplos
#### Traer todos los cliente
```http
  GET /cliente/mostrar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `token api` | `string` | **Not Required** |
        

#### Crear cliente
```http
  POST /cliente/crear
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `nombre` | `string` | **Required**. |
| `correo` | `string` | **Required**. |
| `telefono` | `string` | **Required**. |

#### Actuaizar cliente
```http
  PUT /cliente/actualizar/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ID` | `Long` | **Required**. | 
| `nombre` | `string` | **NotRequired**. |
| `correo` | `string` | **NotRequired**. |
| `telefono` | `string` | **NotRequired**. |


#### Borrar cliente por su ID
```http
  DELETE /contacto/borrar/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **Required**. |


#### Traer cliente por Id
```http
  GET /cliente/unidad/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**.|

#### Traer todos los productos
```http
  GET /producto/mostrar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `token api` | `string` | **Not Required** |
        

#### Crear producto
```http
  POST /producto/crear
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `marca` | `string` | **Required**. |
| `modelo` | `string` | **Required**. |
| `descripcion` | `string` | **Required**. |
| `precio` | `Integer` | **Required**. |
| `categoria` | `string` | **Required**. Enum |

#### Actuaizar producto
```http
  PUT /producto/actualizar/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ID` | `Long` | **Required**. | 
| `marca` | `string` | **NotRequired**. |
| `modelo` | `string` | **NotRequired**. |
| `descripcion` | `string` | **NotRequired**. |
| `precio` | `Integer` | **NotRequired**. |
| `categoria` | `string` | **Required**. Enum 


#### Borrar producto por su ID
```http
  DELETE /producto/borrar/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **Required**. |


#### Traer producto por Id
```http
  GET /producto/unidad/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**.|



#### Traer todas las Compras
```http
  GET /carrito/mostrar
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **NotRequired**. |


#### Crear carrito de compras
```http
  POST /carrito/crear
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre` | `string` | **Required** |
| `productos` | `List<Integer>` | **Required** |


#### Actuaizar carrito de compras
```http
  PUT /carrito/crear
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre` | `string` | **NotRequired** |
| `productos` | `List<Integer>` | **NotRequired** |


#### Borrar carrito de Compras
```http
  DELETE /carrito/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id` | `Long` | **Required** |


#### Mostrar por unidad carrito
```http
  GET /carrito/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id` | `Long` | **Required** |

## Documentation


[Swagger](https://springdoc.org/) Para una mayor comprensión se instala Sawgger al proyecto para una mejor vista visual de sus endPoints.

[SpringInizialitzer](https://github.com/spring-io/initializr/) Donde encontraremos todas las dependencias necesarias para nuestro proyecto

[Maven properties](https://books.sonatype.com/mvnref-book/reference/resource-filtering-sect-properties.html) Aca podremos ayar mas informacion de las propiedades de maven




## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=r)](https://portafolio-reack.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/edwin-castro-13a763272)


## Demo

Aca podras ver el video del proyecto ya implementado y usando SWAGGER.

youtube  https://youtu.be/7Gl556EQ--Y 

![ProyectoContacto](https://i.pinimg.com/originals/62/96/32/6296325b333a572db7eade8b0f86aa58.gif)



![edLogo](https://i.pinimg.com/736x/79/af/8d/79af8d9946ab024aeff1d9d6929af8a0.jpg)


## Authors

- [@edtecnology](https://www.edtecnology.com)


## 🚀 About Me
I'm a full stack developer...

