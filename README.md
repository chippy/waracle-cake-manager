# Waracle Cake Manager
An implementation of the Waracle 'cake manager' interview question from https://github.com/Waracle/cake-manager

### Running the project
To run locally:
1. `git clone https://github.com/chippy/waracle-cake-manager.git`
2. `cd waracle-cake-manager`
3. `mvn spring-boot:run`
4. Open localhost:8080 in your browser.

To run/debug in development mode:
1. Import maven project into your IDE
2. Run Java application from your IDE to start the back-end
3. Navigate to \src\main\frontend
4. `npm start` to start the React development server
5. Open localhost:3000 in your browser
 
DockerHub repository: https://hub.docker.com/repository/docker/chipples/waracle-cake-manager  
Hosted online at: http://waraclecakemanager-env.eba-uijjvu3m.us-west-2.elasticbeanstalk.com/

### Changes to Original Project
- Re-implemented back-end as a Spring Boot application with a REST API.
- Fixed incorrect column mapping for CakeEntity (e.g. CakeEntity was mapped to a table called Employee, title was mapped to EMAIL, description was mapped to FIRST_NAME).
- Created front end as a React app which consumes the API. Maven orchestrates npm to copy a production build of this into the target folder.
- Added a few integration tests.
- Containerised with Docker.
- Created CI/CD pipeline using GitHub Actions to build and test, publish to DockerHub and deploy to Elastic Beanstalk.