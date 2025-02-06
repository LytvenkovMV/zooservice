# Используем образ, содержащий maven, при помощи
# ключевого слова as мы указываем псевдоним для контейнера сборки,
# чтобы при его помощи в дальнейшем обращаться к контейнеру
FROM maven:3.9.4-eclipse-temurin-17 as build

# Устанавливаем рабочую директорию
WORKDIR /build

# Копируем исходники
COPY src src

# Копируем
COPY pom.xml pom.xml

# Запускаем сборку
RUN mvn clean package



# Используем образ OpenJDK
FROM openjdk:14-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в контейнер
COPY --from=build build/target/zooservice-1.0-SNAPSHOT.jar /app/zooservice-1.0-SNAPSHOT.jar

# Копируем appdata.txt в контейнер
COPY appdata/appdata.txt /app/appdata/appdata.txt

# Команда для запуска приложения
CMD ["java", "-jar", "/app/zooservice-1.0-SNAPSHOT.jar"]
