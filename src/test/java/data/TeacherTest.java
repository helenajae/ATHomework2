package data;

import org.junit.Test;
import school.Teacher;

import java.time.ZonedDateTime;
import static org.junit.Assert.assertEquals;

public class TeacherTest {
    @Test
    public void sayHello() {

        //given
        ZonedDateTime dateOfBirth = ZonedDateTime.parse("1980-01-01T00:00:00.000+00:00[UTC]");
        Teacher teacher = new Teacher("Tiina", "Tamm", dateOfBirth);

        //when
        String expected_result = "Hello teacher Tiina";

        //then
        assertEquals(teacher.sayHello(), expected_result);
    }
}