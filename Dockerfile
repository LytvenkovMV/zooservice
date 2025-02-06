# Используем образ OpenJDK
FROM openjdk:14-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в контейнер
COPY target/zooservice-1.0-SNAPSHOT.jar /app/zooservice-1.0-SNAPSHOT.jar

# Копируем appdata.txt в контейнер
COPY appdata/appdata.txt /app/appdata/appdata.txt

# Команда для запуска приложения
CMD ["java", "-jar", "/app/zooservice-1.0-SNAPSHOT.jar"]
