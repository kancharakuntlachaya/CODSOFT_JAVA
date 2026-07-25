import java.util.*;

public class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    List<String> registeredStudentIds;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudentIds = new ArrayList<>();
    }

    public int availableSlots() {
        return capacity - registeredStudentIds.size();
    }

    public void printInfo() {
        System.out.printf("[%s] %s - %s | Schedule: %s | Slots available: %d/%d%n",
                courseCode, title, description, schedule, availableSlots(), capacity);
    }
}
