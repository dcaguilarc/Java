# Usa una imagen base de Java
FROM openjdk:17-alpine

# Crea un directorio de trabajo
WORKDIR /app

# Copia el archivo Java al contenedor
COPY Prueba1.java /app

# Compila el archivo Java
RUN javac Prueba1.java

# Expone el puerto 8082 para el servidor HTTP
EXPOSE 8082

# Ejecuta el archivo compilado
CMD ["java", "Prueba1"]
