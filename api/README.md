# Legacy-heroes
Hackaton project repo. User functionality extension for everlabs trainual app

set up docker database with file in ```misc/docker-compose.yml```
run 
```
docker compose up
```

create database with name ```userservice```

set up variable:
```
export DATABASE_URL=postgres://postgres:admin@localhost:5432/userservice
```

Run Spring Boot app locally:

```
gradle clean build
gradle bootRun
```

Use ```misc/user-service-hackaton.postman_collection.json``` for postman requests
Change url value in collection variables to "https://feedback-serv-hackaton-back-e4f96a1dac88.herokuapp.com" if you need to test deployed version.