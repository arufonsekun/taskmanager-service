# taskmanager-service
The main purpose of this project is to create a web service using spring java framework based on REST architecture (kk). Besides that taskmanager-service intents to provide the required resources from TaskManager Angular app.

### Run the server
taskmanager-service uses PosgreSQL SGBD so check this [link](https://www.godaddy.com/garage/how-to-install-postgresql-on-ubuntu-14-04) to now how to install and run Postgres on Ubuntu.

After that run `sudo su -l postgres` to login into the local postgres user, then run `psql` to login into the database and finally `CREATE DATABASE taskmanager` to create the database.
Finally run `./mvnw spring-boot:run` inside taskmanager-service to start the server.

Currently the avaliable resources are `POST` to `/task` to create a new task, `GET` to `/task/{id}` to access a task by id, and `GET` to `/tasks` to list them all.

### Using curl to test the resources
`curl -d '{"title":"resenha", "type":"fucked", "deadLine":"26/02/2019","description":"acabar aquela merda"}' -H "Content-Type: application/json" -X POST http://localhost:8080/task`
`curl -d "1" -X GET http://localhost:8080/task/1`
`curl -d "1" -X GET http://localhost:8080/tasks`
