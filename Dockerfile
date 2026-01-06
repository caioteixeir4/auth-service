# Estágio 1: Compilação
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio 2: Execução
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Injeta a vacina de rede diretamente no container
ENTRYPOINT ["java", "-Doracle.net.disableOob=true", "-jar", "app.jar"]