# URL-Shortener-REST-API

A **URL Shortener Microservice** developed using **Spring Boot** and **MongoDB**, which is used to shorten the **Long URL** into **Shorten URL**. It provides **REST API** endpoints to interact with.
![tech-logos](https://user-images.githubusercontent.com/64230897/222223593-902b97de-63e3-4988-972b-09ed28048020.png)
## Demo

[Full Stack Project with **React** and **Spring Boot** where this project is used as a backend.](https://geturl.codelabs.tech/)

## Screenshots

![screenshot-api](https://user-images.githubusercontent.com/64230897/222185793-98824a38-fd67-438e-859c-da436ee0b909.png)

## Run Locally

1. Clone the project

```
 git clone https://github.com/animesh-anand-dev/URL-Shortener-Microservice.git
```
2. Download **[Spring Tool Suite](https://spring.io/tools)** or **[Eclipse IDE](https://www.eclipse.org/downloads/)** open the Parent Folder using any of thse IDE as workspace.

3. Import the Cloned project in IDE.

4. Create and Setup account for [MongoDB Atlas](https://www.mongodb.com/cloud) on [MongoDB Cloud](https://www.mongodb.com/cloud).

5. Create User and Password for the **Database**.
6. Create Database
7. Go to **[application.properties](https://github.com/animesh-anand-dev/URL-Shortener-Microservice/blob/master/src/main/resources/application.properties)** file
8. Replace the value of key **spring.data.mongodb.uri** and **spring.data.mongodb.database** which is your coonection string and database name respectively.

9. Now Run your project as **Spring Boot App**

10. Open your favourite API testing tool like [Postman](https://www.postman.com/) for desktop and [Talend API Tester](https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=en)
 
😊 Happy Coding 🎉

## API Reference

#### Get all urls 

```
  GET /urls
```
```http
  http://localhost:5000/urls
```

#### Get a url details

```
  GET /${id}/details
```

```http
  http://localhost:5000/random_id/details
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of Shorten Url to fetch details|

#### Post a url

```
  POST /urls
```

```http
  http://localhost:5000/urls
```

| Request body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `originalUrl`      | `string` | **Required**. originalUrl of Long URL to create shorten link.|

#### Get request to shorten link which redirects to its original URL

```
  GET /${id}
```

```http
  http://localhost:5000/random_id
```

## Dependencies Used

- **Spring Web**
 Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
 ```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
 ```
 - **Spring Data MongoDB**
 Store data in flexible, JSON-like documents, meaning fields can vary from document to document and data structure can be changed over time.
 ```
 <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
 ```
- **Guava: Google Core Libraries For Java**
 Guava is a suite of core and expanded libraries that include utility classes, Google's collections, I/O classes, and much more.
 ```
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.1-jre</version>
</dependency>
 ```
- **Apache Commons Validator**
 Apache Commons Validator provides the building blocks for both client side validation and server side data validation. It may be used standalone or with a framework like Struts.
 ```
<dependency>
    <groupId>commons-validator</groupId>
    <artifactId>commons-validator</artifactId>
    <version>1.7</version>
</dependency>
 ```
- **SpringDoc OpenAPI Starter WebMVC UI**
 The springdoc-openapi generates API documentation as per OpenAPI 3 specification. Moreover, it also handles the Swagger UI configuration for us, making API document generation a fairly simple task.
 ```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.0</version>
</dependency>
 ```
 - **Spring Boot Starter HATEOAS**
 Starter for building hypermedia-based RESTful web application with Spring MVC and Spring HATEOAS.
 ```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
 ```
 - **Spring Boot DevTools**
 Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
 ```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
 ```
## Author

<p>
  <img width="50"align="center" src="https://user-images.githubusercontent.com/64230897/222225914-ed0f7818-df07-467c-84a8-865252cdfa8a.jpg" alt="animesh-anand"/><b align="right"> Animesh Anand </b>
</p> 

* Website: https://animeshanand.web.app/
* Github: [@animesh-anand-dev](https://github.com/animesh-anand-dev)
* LinkedIn: https://linkedin.com/animeshanand

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2023 [Animesh Anand](https://github.com/animesh-anand-dev).<br />
This project is [MIT License](https://github.com/animesh-anand-dev/URL-Shortener-Microservice/blob/master/LICENSE) licensed.

