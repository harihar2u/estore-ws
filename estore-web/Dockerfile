FROM java:8-jdk-alpine

ADD target/estore.jar /opt/app/java/estore.jar
RUN sh -c 'touch  estore.jar'

EXPOSE 8082

WORKDIR /opt/app/java
CMD "java" "-jar" "estore.jar"

HEALTHCHECK --timeout=30s --interval=30s --retries=10 --start-period=15s \
CMD curl -m 30 -f -s http://localhost:8082/health || exit 1


