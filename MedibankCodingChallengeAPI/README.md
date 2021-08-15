
- Use the hackers news api to randomly pick an article about `medicine` and use it for the returned JSON `title`, `url`, `author` fields.
	Searched and identified all stories matching ‘medicine’ from HackerNews. 40 results fetched for now, minimum hits per page required is 24.

- Use the unsplash api to randomly pick an image about `medicine` and use it for the returned JSON `imageUrl` field.
	Searched and identified random images matching category ‘medicine’ and fetched one image from Unsplash.

Used Jackson API for JSON parsing in both above scenarios.



- For the duration of 1 hour return the same JSON content.
	The JSON response generated changes every hour/ shows different content every hour.
	


- Apply consideration if the API services to retrieve news articles and images has crashed or cannot respond.
	Disabled the ‘white label error page’ and provided a basic custom error page.



- We want this service to be running in a docker container. (see the `docker-compose.yml` file)
	Dockerfile available in /docker folder.
	To build:  
	docker build -t spring-api .
	To run container:
	docker run -d -p 8080:8080 --name springapi spring-api


Application URL:
http://localhost:8080/api/article

Project name: MedibankCodingChallengeAPI

Spring Tool Suite 4
Spring Boot (v2.5.3)
Java 11
Maven build



