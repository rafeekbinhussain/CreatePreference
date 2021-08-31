Requirements
For building and running the application you need:

JDK 1.8+
Gradle 7
Intellij IDE

Running the application locally

Please click "TBPayBuild" from gradle explorer in intellij ide

Please make sure you are chosen local properties profile and updated vm arguments

-Dspring.profiles.active=local  // active profile can change according to upper environment
-Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres  // you can modify if you are running docker image for postgresql
-Djasypt.encryptor.password=car  // jasypt password generated secret key 
-Dspring.jpa.show-sql=true // can enable or disable in upper environment

Use the Jasypt Online Tool :
This "https://www.devglan.com/online-tools/jasypt-online-encryption-decryption" can be used to generate an encrypted key by passing the chosen secret key.

then execute the main method in the ..\com\tbpay\preference\PreferenceApplication.javaApplication class from your IDE.

if you have chosen to run locally please use below PostgreSQL way 1 :
// As we used PostgreSQL DB please make sure you've installed postgreSQL13 in local machine

Deploying the application to kubernetes
PostgreSQL way 2 :
// If you are not installing in local please pull postgresql Docker Image and kindly update Application properties
postgreSQL db hostname as your docker postgreSQL image name

and try to execute Docker compose file 
1.docker-compose build
2.docker-compose up
The easiest way to deploy the sample application to K8s is to use the K8s CLI or miniCube:

This docker image will create two service and postgreSQL service in common cluster:

If you want to access the app from outside your k8s installation, you have to expose the preferencecreate and preferencecreate service:



