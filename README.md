# Soccer Fantasy Team API:Backend with Spring Boot

![Alt text](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzk4GNDdJGwOyAFqEQlih0aUuffhyeJvC2xQ&usqp=CAU)


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
</details>

## API Endpoints
***
<details>
  <summary> <b>User Endpoints</b></summary>

| HTTP Methods | Endpoint URL                         | Functionality           | Access    | 
|--------------|--------------------------------------|-------------------------|-----------|
| POST         | `/auth/users/register/`              | Register a new user     | public    |
| POST         | `/auth/users/login/`                 | Login a registered user | public    |
| PUT          | `/auth/users/{userId}`                       | Update a User           | private   |
| GET          | `/auth/users/{userId}`                       | Get a User by Id        | private   |
| DELETE       | `/auth/users/{userId}/`               | Delete a User           | private   |

</details>
<details>
  <summary> <b>SocerPlayer Endpoints</b></summary>

| HTTP Methods | Endpoint URL                         | Functionality      | Access  | 
|--------------|--------------------------------------|--------------------|---------|
| GET          | `/api/soccerplayers`              | Get all players     | private |
| GET          | `/api/soccerplayers/name/{name}`                 | Get a player by name   | private |
| GET          | `/api/soccerplayers/{id}`                       | Get players by Id | private |
| GET          | `/api/soccerplayers/country/{country}`                       | Get players by country name | private |
| GET          | `/api/soccerplayers/position/{position}`                       | Get players by their position | private |
| GET          | `/api/soccerplayers/team/{team}`                       | Get players by their team | private |

</details>
<details>
  <summary> <b>Fantasy Team Endpoints</b></summary>

| HTTP Methods | Endpoint URL                         | Functionality           | Access    | 
|--------------|--------------------------------------|-------------------------|-----------|
| GET         | `/api/fantasyTeam/{userId`              | Return a list for given user   | public    |
| POST         | `/api/fantasyTeam`                 | create a new fabtasy Team object| public    |
| PUT          | `/api/fantasyTeam/{teamid}/addPlayer/{playerid}`                       | adds a player to team          | private   |
| PUT          | `/api/fantasyTeam/{teamid}/addPlayer/{playerid}`                       | removes a player from the team       | private   |
| DELETE       | `/api/fantasyTeam/{teamId}`               | Delete a fantasy Team           | private   |

</details>


### Challenges

One significant challenge encountered during the development of this Spring API was the implementation of testing procedures. Initially, I attempted to encompass all testing aspects within the Cucumber framework, aiming for comprehensive coverage. However, as the project complexity grew, it became apparent that some testing scenarios required a more fine-grained approach. This led to the incorporation of Mockito, which provided the flexibility needed to simulate specific behaviors and interactions, ultimately enhancing the accuracy and effectiveness of the testing process. Adapting to this dual testing approach proved instrumental in achieving a robust and reliable API, ensuring that both high-level features and intricate components were thoroughly validated.

![Alt text](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHhwFTE3h05_1d0nsaLfi9P1xXfiWmZa9AWA&usqp=CAU)


### Key Achievements

The achievement here has to be that all my tests pass. 

### Acknowledgments

I'd like to express my heartfelt gratitude to everyone who contributed to the success of this project. Special thanks to my company, Interapt, for providing the support and resources necessary for this endeavor.

I also want to extend my appreciation to my dedicated instructors, Leo, Dhrubo, and Suresh, whose guidance and expertise were instrumental throughout this journey. Additionally, a big shoutout to Kerry for her unwavering support and presence week after week.

Your collective efforts and encouragement have been invaluable, and I couldn't have accomplished this without you all. Thank you for being a part of this project's success.


![Alt text](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ834rX7BDZvE1jOqTF3Fei5pY2pL02Y4BzVg&usqp=CAU)













