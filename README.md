# spring-boot-in-depth
Spring Boot application showcasing various aspects of the Spring ecosystem

postgres DB setup:
----------------
`docker create --name postgres-demo -e POSTGRES_PASSWORD=Welcome -p 5432:5432 postgres:15.4`

`docker start postgres-demo`

`docker stop postgres-demo`

JDBC URL: `jdbc:postgresql://localhost:5432/spring_boot_in_depth_app`
Username: `postgres`
Password: `Welcome`

Connect to PSQL prompt from docker:
`docker exec -it postgres-demo psql -U postgres`

`psql> create database spring_boot_in_depth_app;`

Setup the Tables:
----------------
`docker cp create_tables.sql postgres-demo:/create_tables.sql`

`docker exec -it postgres-demo psql -d spring_boot_in_depth_app -f create_tables.sql -U postgres`

Install the Data:
----------------
`docker cp insert_data.sql postgres-demo:/insert_data.sql`

`docker exec -it postgres-demo psql -d spring_boot_in_depth_app -f insert_data.sql -U postgres`
