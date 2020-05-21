package utils;

import school.Student;
import java.util.List;

public class Utils {
    public static void allStudentsNames(List<Student> students){

        for (Student s : students){
            System.out.println(s.getFullName());
        }
    }
}