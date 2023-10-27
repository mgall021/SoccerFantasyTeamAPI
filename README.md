# Soccer Fantasy Team API:Backend with Spring Boot

## Description

This Soccer Manager API project is designed for soccer fans who want to create and manage their fantasy soccer teams effortlessly. It offers user profiles for personalized experiences and categorizes soccer players by attributes like name, country, and position, making player discovery a breeze. 
Users can curate their dream teams, adding, updating, and removing players as they please. The monolithic backend ensures robust security and data management, with CRUD operations and an in-memory database. Making this API a user-centric platform for soccer enthusiasts.

# User Stories
As a user, I want to create a new fantasy team.

As a user, I want to view my existing fantasy team.

As a user, I want to be able to add players to my team.

As a user, I want to be able to remove players from my team.

As a user, I want to be able to update my player list. 

As a user, I want to see my player's ratings after each week. 

As a user, I want to be able to register securely. 

As a user, I want to be able to login securely.

## Entity Relationship Diagram (ERD)
***
[Soccer Fantasy Team Manager ERD.pdf](https://github.com/mgall021/SoccerFantasyTeamAPI/files/13188852/Soccer.Fantasy.Team.Manager.ERD.pdf)


# Dependencies
***
![Spring Boot](src/main/resources/static/springboot.png)

<details>
  <summary> Spring Boot Dependencies </summary>

- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- Spring Boot Starter Web Services
- Spring Boot DevTools (scope: runtime, optional: true)
- Spring Boot Starter Test (scope: test)
- Spring Security Test (scope: test)
- Spring Boot Starter OAuth2 Resource Server

</details>
<br>

<img src="src/main/resources/static/cucumber.png" width="auto" height="50"> -- and  -- <img src="src/main/resources/static/mockito.png" width="auto" height="50">


<details>
  <summary> Testing Dependencies </summary>

- JUnit: 4.12 (scope: test)
- Cucumber Java: 6.8.1 (scope: test)
- Cucumber JUnit: 6.8.1 (scope: test)
- Cucumber Spring: 6.8.1 (scope: test)
- JUnit Jupiter API: 5.10.0 (scope: test)
- Mockito JUnit Jupiter: 4.5.1 (scope: test)
- Hamcrest: 2.2 (scope: test)
- Mockito Inline: 4.10.0 (scope: test)
- Rest Assured (scope: test, excluding groovy-xml)


</details>
<br>
<img src="src/main/resources/static/h2-logo.svg" height="50" style="margin-left: 50px">
<details>
  <summary> H2 Dependency </summary>

- H2 Database (scope: runtime)


</details>


![JWT](src/main/resources/static/JWT.png)
<details>
  <summary> JWT Dependencies </summary>

- jjwt-api: 0.11.5
- jjwt-impl: 0.11.5 (scope: runtime)
- jjwt-jackson: 0.11.5 (scope: runtime)


## API Endpoints
***
<details>
  <summary> <b>User Endpoints</b></summary>
| HTTP Methods | Endpoint URL                         | Functionality           | Access    | 
|--------------|--------------------------------------|-------------------------|-----------|
| POST         | `/auth/users/register/`              | Register a new user     | public    |
| POST         | `/auth/users/login/`                 | Login a registered user | public    |
| PUT          | `/auth/users/{userId}`               | Update a User           | private   |
| GET          | `/auth/users/{userId}`               | Get a User by Id        | private   |
| DELETE       | `/auth/users/{userId}/`              | Delete a User           | private   |

</details>
















