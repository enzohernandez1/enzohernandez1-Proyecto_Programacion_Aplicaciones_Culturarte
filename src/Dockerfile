
# Usa Maven con JDK 21 para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
# Copia todo el contenido del proyecto al contenedor
COPY . /app
# Establece el directorio de trabajo
WORKDIR /app
# Compila el proyecto y genera el JAR
RUN mvn clean package

# Usa solo Java 21 para ejecutar la app (más liviano)
FROM eclipse-temurin:21-jre
# Establece el directorio de trabajo
WORKDIR /app
# Copia el JAR generado en la etapa de build y lo renombra
COPY --from=build /app/target/*.jar app.jar
# Comando para ejecutar el JAR
CMD ["java", "-jar", "app.jar"]
