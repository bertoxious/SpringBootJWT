# SpringBootJWT

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

**_URL_**  

<h4 style="color:yellow;">POST</h4><h4 style="color:purple;">Create User</h4>

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
**_URL_**
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
**_URL_**
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
**_URL_**
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
