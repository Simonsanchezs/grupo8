# Usa una imagen base genérica de OpenJDK 11
FROM openjdk:11-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/Grupo8-1.0.0.jar app.jar

# Expone el puerto 8080 (o el puerto configurado en tu aplicación)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
