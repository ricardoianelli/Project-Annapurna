# Project Annapurna
This is a Project Repository for a course CS544-Enterprise Architecture
taught by [Professor Michael Zijlstra](https://manalabs.org/).🧑🏽‍🏫 at MIU 🏫


# How to run
You must start the services in the following order:

1. **Eureka-Server-One:** *9091*
2. **Eureka-Server-Two:** *9092* (optional)
3. **Config-server:** *8000*
4. **Api-gateway-one:** *8080*
5. **Login-Service:** *9090*
6. **User-Service:** *8082*
 

These other services you can start in any order:


8. **Email-Service:** *8081*
9. **ETL-Service:** *8083*
10. **Rating-Service:** *8084*

You also need to setup two environment variables for the email service:
- **GMAIL_USER:** A valid Gmail email address
- **GMAIL_PASSWORD:** The password or an app password for the GMAIL_USER.

# Micro-services overview

1. ### USER-SERVICE
   - **Swagger:** _:8082/swagger-ui.html

2. ### LOGIN-SERVICE
   - **Swagger:** _:9090/swagger-ui.html\
![User Service Overview](images/User-Login.png "User/Login Microservice")

3. ### EMAIL-SERVICE
   - **Swagger:** _:8081/swagger-ui.html\
![Email Service Overview](images/Email.png "Email Microservice")

4. ### ETL-SERVICE
   - **Swagger:** _:8083/swagger-ui.html\
![ETL Service Overview](images/ETL.png "ETL Microservice")

5. ### RATING-SERVICE
   - **Swagger:** _:8084/swagger-ui.html\
![Ratings Service Overview](images/Ratings.png "Ratings Microservice")

# Contributors
- ## Ricardo Macedo Ianelli <img alt="Brazil Flag" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Brazilian_flag_icon_round.svg/1200px-Brazilian_flag_icon_round.svg.png" width="16" height="16">
- ## Riwaaz Bahadur Sijapati <img alt="Nepal Flag" src="https://cdn-icons-png.flaticon.com/512/197/197387.png" width="16" height="16">
- ## Bijay Shrestha <img alt="Nepal Flag" src="https://cdn-icons-png.flaticon.com/512/197/197387.png" width="16" height="16">

# Presentation
Since it was a project for a specific course, we've also created [small presentation](https://docs.google.com/presentation/d/1O-QTDH0kmuehK4BpleJ2WtXOt_wkxDYWWcnGtuHpZyk/edit#slide=id.gc6f80d1ff_0_0). There isn't text in the slides since we prefer to have a more dynamic presentation.

