FROM openjdk:7
COPY . \r_fma\git\ES2-2019-IC2-32\ProjectoES2\src\main\java\HelloWorld.java
WORKDIR \r_fma\git\ES2-2019-IC2-32\ProjectoES2\src\main\java\HelloWorld.java
RUN javac HelloWorld.jar
CMD ["java", "HelloWorld"]
