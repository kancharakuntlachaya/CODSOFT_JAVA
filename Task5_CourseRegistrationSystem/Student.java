import java.util.*;

public class Student {
    String studentId;
    String name;
    List<String> registeredCourseCodes;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourseCodes = new ArrayList<>();
    }
}
