package school;

import java.time.ZonedDateTime;

public interface Person {
    String getFirstName();
    String getFullName();
    ZonedDateTime getDateOfBirth();
    Long getAge();
    String sayHello();
}