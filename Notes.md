- **Automarshalling** : In the Java ecosystem, the `Jackson` library provides automarshalling capabilities to convert Java objects to JSON and vice versa. In Python, the `pickle` module provides serialization and deserialization capabilities.
- **Serialization**: Serialization is the process of converting an object's state (data) into a byte stream or another format that can be easily stored, transmitted, or persisted. This is particularly useful when you need to save an object's state to a file, send it over a network, or store it in a database. 
In Java, you can achieve serialization by implementing the `Serializable` interface. Objects of classes that implement this interface can be converted into byte streams using `ObjectOutputStream`. Here's an example:

```java 
import java.io.*;

public class SerializationExample {
public static void main(String[] args) {
// Create an object
Student student = new Student("John", 25);

        try {
            // Serialize the object to a file
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student);
            out.close();
            fileOut.close();
            System.out.println("Object serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Student implements Serializable {
String name;
int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
- **Deserialization**: Deserialization is the process of converting a serialized byte stream or data back into an in-memory object. It's useful for reading objects from files, network communication, or data retrieval from databases.
In Java, you can deserialize an object using the `ObjectInputStream` class. Here's an example:
```java
public class DeserializationExample {
    public static void main(String[] args) {
        try {
            // Deserialize the object from the file
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Student student = (Student) in.readObject();
            in.close();
            fileIn.close();

            // Use the deserialized object
            System.out.println("Name: " + student.name);
            System.out.println("Age: " + student.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
----------------------------------------
Order of Precedence:
1. Command line args
2. SPRING_APPLICATION_JSON args
3. Servlet Parameters
4. JNDI
5. Java System properties
6. OS Environment variables - can be used as main external source
7. Profile properties - can be used as main internal source
8. Application properties - can be used as main internal source
9. @PropertySource annotations
10. Default properties
----------------------------------------
- `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` -> Set as Environment variables in run configuration in intellij
- DB_URL=jdbc:postgresql://localhost:5432/spring_boot_in_depth_app;
- DB_USERNAME=postgres;
- DB_PASSWORD=Welcome
- Run configuration -> VM options -> `-Dspring.profiles.active=prod`
- To run as jar -> Go to build\libs `java -jar spring-boot-in-depth-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/spring_boot_in_depth_app --spring.datasource.username=postgres --spring.datasource.password=Welcome`
----------------------------------------
- The error message `Caused by: java.lang.NoClassDefFoundError: jakarta/servlet/http/HttpSessionContext` means that the Java Virtual Machine (JVM) cannot find the class jakarta.servlet.http.HttpSessionContext. This class is part of the Jakarta Servlet API, which is a set of Java classes that are used to develop web applications.
- The reason why the JVM cannot find the class is because you are using Spring Boot 3.0, which uses the Jakarta Servlet API 6.0. However, Jetty, which is the embedded web server that Spring Boot uses by default, does not support the Jakarta Servlet API 6.0.
- **Spring Boot 3 rely on Jakarta Servlet 6.0.0** (see https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Release-Notes) and the **spring-boot-starter-jetty includes Jetty 11 which is build on Jakarta Servlet 5.0.0** (see https://java.libhunt.com/jetty-project-changelog/11.0.0). So this is an Issue in the starter itself.
----------------------------------------
To move from tomcat to jetty (WIP)
```groovy
implementation ('org.springframework.boot:spring-boot-starter-web') {
		exclude group: 'org.springframework.boot', module: 'spring-boot-starter-tomcat'
}
implementation 'org.springframework.boot:spring-boot-starter-jetty'
```
- Change in application.properties

`spring.property-placeholder.helper-class=org.springframework.beans.factory.config.PropertyPlaceholderHelper`
----------------------------------------
JNDI - For setting credentials
----------------------------------------
To create a ‘fully executable’ jar with Maven, use the following plugin configuration:
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <executable>true</executable>
    </configuration>
</plugin>
```
The following example shows the equivalent Gradle configuration:
```groovy
tasks.named('bootJar') {
launchScript()
}
```
