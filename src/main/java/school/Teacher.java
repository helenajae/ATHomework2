package school;

import java.time.ZonedDateTime;

public class Teacher extends PersonImpl{

    public Teacher(String name, String lastName, ZonedDateTime dateOfBirth) {
        super(name, lastName, dateOfBirth);
    }

    @Override
    public String sayHello() {
        return "Hello teacher " + getFirstName();
    }
}