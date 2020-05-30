FROM openjdk:8

COPY . /myapp

WORKDIR /myapp

RUN ./mvnw clean package -Dmaven.test.skip=true

RUN mv /myapp/target/*.jar /myapp/myapp.jar

ENTRYPOINT ["java", "-jar", "/myapp/myapp.jar"]