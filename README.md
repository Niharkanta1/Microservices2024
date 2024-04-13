### Microservices
- [Master Microservices with SpringBoot,Docker,Kubernetes](https://www.udemy.com/course/master-microservices-with-spring-docker-kubernetes/)

## Docker Commands
- Build docker images:
	- docker build . -t niharkanta2/accounts-ms:v1
- Docker Run 
	- docker run -p -d 8080:8080 niharkanta2/accounts-ms:v1
- Docker stop and start
	- docker start/stop <container id>
- Docker Push Images
	- docker image push docker.io/niharkanta2/accounts-ms:v1
- Docker Pull Images
	- docker image pull niharkanta2/accounts-ms:v1
- Docker Compose command where docker-compose.yml file is present
	- docker compose up -d
	- docker compose down 
	- docker compose stop (dont delete the containers)
	- docker compose start (dont create the containers)
- Other docker commands:
	- docker container kill <container-id>
	- docker container inspect <container-id>
	- docker container restart <container-id>
	- docker container logs <container-id>
	- docker container pause <container-id>
	- docker container unpause <container-id>