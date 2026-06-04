FROM maven:3.9.11-eclipse-temurin-21

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/api-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}"]