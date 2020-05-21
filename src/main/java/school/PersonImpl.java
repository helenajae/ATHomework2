package school;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements Person{
    private String name;
    private String lastName;
    private ZonedDateTime dateOfBirth;

    public PersonImpl(String name, String lastName, ZonedDateTime dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return this.name;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

    public ZonedDateTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Long getAge() {
        return ChronoUnit.YEARS.between(this.dateOfBirth, ZonedDateTime.now());
    }

    public String sayHello() { return "Hello!";
    }
}