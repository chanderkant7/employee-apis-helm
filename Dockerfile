FROM adoptopenjdk/openjdk11
# Copy the binary built in the 1st stage
COPY target/*.jar ./
ENTRYPOINT ["java","-jar","/employee-apis-1.0.jar"]
EXPOSE 8080