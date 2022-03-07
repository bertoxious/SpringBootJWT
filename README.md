# SpringBootJWT

## STEPS :  

[1. Create User entity and Role entity along with their repos.](https://github.com/bertoxious/SpringBootJWT/tree/master/src/main/java/com/example/JwtAuthentication/entities)  
[2. Define relationship b/w both the entities.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/entities/User.java)  
[3. Create Service and Controllers for both of them.](https://github.com/bertoxious/SpringBootJWT/tree/master/src/main/java/com/example/JwtAuthentication/services)  
[4. Add CORS Configuration.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/config/CorsConfiguration.java)  
[5. Add WebSecurityConfiguration.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/config/WebSecurityConfiguration.java)  
[6. Create JwtRequest and Response entity.](https://github.com/bertoxious/SpringBootJWT/tree/master/src/main/java/com/example/JwtAuthentication/entities)  
[7. Create JwtService and add createJwtToken method.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/services/JwtService.java)  
[8. Create JWtAuthenticationEntryPoint.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/config/JwtAuthenticationEntryPoint.java)  
[9. Create a JWTRequestFilter and add it to the WebSecurityConfiguration.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/config/JwtRequestFilter.java)  
[10. Create a JWTUtil class containing all the logic for JWT token generation, expiration, validation, claims etc.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/util/JwtUtil.java)  
[11. Add PreAuthorize depeding upon role to the controller urls.](https://github.com/bertoxious/SpringBootJWT/blob/master/src/main/java/com/example/JwtAuthentication/controller/UserController.java)  


## Dependencies

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<optional>true</optional>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>
```
## Endpoints
**_URL_** 🟠
<details><summary>Create User</summary>
<p>

```url
http://localhost:8080/create-user
```
**_Body_**
```json
{
    "userName":"admin",
    "userFirstName":"Mr. Admin",
    "userLastName":"Lal",
    "confirmPassword":"admin@pass",
    "userPassword":"admin@pass"
}
```
</p>
</details>
<details><summary>Add Role</summary>
<p>

```url
http://localhost:8080/add-role
```
**_Body_**
```json
{
    "roleName":"ADMIN",
    "roleDescription":"Access to all the APIs"
}
```

</p>
</details>
<details><summary>Authenticate User</summary>
<p>

```url
http://localhost:8080/authenticate
```
**_Body_**
```json
{
    "username":"admin",
    "userPassword":"admin@pass"
}
```


</p>
</details>
<details><summary>Assign Role</summary>
<p>

```url
http://localhost:8080/assign-role
```
**_Body_**
```json
{
    "username":"admin",
    "role":"ADMIN"
}
```



</p>
</details>


**_URL_** 🟢
<details><summary>Admin Content</summary>
<p>

```url
http://localhost:8080/admin-content
```


</p>
</details>

<details><summary>User Content</summary>
<p>

```url
http://localhost:8080/user-content
```


</p>
</details>

