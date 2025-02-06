# Используем образ OpenJDK
FROM openjdk:14-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в контейнер
COPY target/zooservice-1.0-SNAPSHOT.jar zooservice-1.0-SNAPSHOT.jar

# Команда для запуска приложения
CMD ["java", "-jar", "zooservice-1.0-SNAPSHOT.jar"]