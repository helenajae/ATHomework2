package school;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student extends PersonImpl{

    private List<Course> courses;

    public Student(String name, String lastName, ZonedDateTime dateOfBirth) {
        super(name, lastName, dateOfBirth);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    @Override
    public String sayHello() {
        return "Hello, I am student!";
    }

    public List<String> allTeachersNames(){
        List<String> teachersNames = new ArrayList<String>();
        for (Course i : this.courses){
            teachersNames.add(i.getTeacher().getFirstName());
        }
        return teachersNames;
    }
}