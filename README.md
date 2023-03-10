## Address-Book

SpringBoot+JPA로 구현한 간단한 CRUD의 기능을 수행하는 주소록 RestApi  
</br>

### Structure

Controller  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ↑↓ entity : DB와 mapping  
Repository


### Steps to Setup

**1. Create Mysql database**
```sql
CREATE DATABASE mydb;
```

**2. Create table and records**
```sql
CREATE TABLE `users` (
	`id` VARCHAR(11) NOT NULL COLLATE 'utf8_bin',
	`name` VARCHAR(11) NOT NULL COLLATE 'utf8_bin',
	`passwd` VARCHAR(11) NOT NULL COLLATE 'utf8_bin',
	`birth` VARCHAR(11) NOT NULL COLLATE 'utf8_bin',
	`tel` VARCHAR(20) NOT NULL COLLATE 'utf8_bin',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_bin'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC
;
```

**3. Run the app using maven**

```java
@SpringBootApplication
public class AddbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddbookApplication.class, args);
	}

}
```
The app will start running at <http://localhost:8080>
</br>

*+ check up [pom.xml](pom.xml) & [application.properties](src/main/resources/application.properties)*
</br>

### Users Entity
```java
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class Users {
    @Id
    private String id;
    private String name;
    private String passwd;
    private String birth;
    private String tel;
}
```
</br>

### Explore Rest APIs

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /users | users 전체 목록 가져오기 | [JSON](#getall) |
| GET    | /users/{id} | 해당 id 정보 가져오기 | [JSON](#get) |
| POST   | /users | user 정보 추가 | [JSON](#post) |
| PUT    | /users/{id} | user 정보 수정 (passwd, tel) | [JSON](#put) |
| DELETE | /users/{id} | 해당 id 정보 삭제 | |

Postman으로 테스트 진행

### Sample Valid JSON Request Bodys

##### <a id="getall">Read All User -> /users</a>
```json
[
    {
        "id": "id1",
        "name": "홍길동",
        "passwd": "1234",
        "birth": "950428",
        "tel": "010-1234-1234"
    },
    {
        "id": "id2",
        "name": "유수빈",
        "passwd": "1234",
        "birth": "990910",
        "tel": "010-2345-2345"
    }
]
```

##### <a id="get">Read User -> /users/id2</a>
```json
{
    "id": "id2",
    "name": "유수빈",
    "passwd": "1234",
    "birth": "990910",
    "tel": "010-2345-2345"
}
```

##### <a id="post">Create User -> /users</a>
```json
{
    "id": "id1",
    "name": "홍길동",
    "passwd": "1234",
    "birth": "950428",
    "tel": "010-1234-1234"
}
```

##### <a id="put">Update User -> /users/id1</a>
```json
{
    "id": "id1",
    "name": "홍길동",
    "passwd": "4321",
    "birth": "950428",
    "tel": "010-2345-2345"
}
```
