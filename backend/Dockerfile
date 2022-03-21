FROM openjdk:8-jdk-stretch
RUN mkdir /be
WORKDIR /be
ARG JAR_FILE
COPY /target/${JAR_FILE} /be/app.jar
# 配置文件使用默认的 application.properties/application.yml
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/be/app.jar", "--spring.config.location=/be/application.yml"]