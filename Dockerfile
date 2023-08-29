# 베이스 이미지를 OpenJDK 17로 선택
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정 (원하는 경로로 설정하세요)
WORKDIR /app

# Gradle 빌드된 JAR 파일을 복사
COPY build/libs/*.jar app.jar

# Docker 컨테이너에서 Spring Boot 애플리케이션을 실행
CMD ["java", "-jar", "app.jar"]

