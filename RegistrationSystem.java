import java.util.*;

public class RegistrationSystem {
    Map<String, Course> courses = new LinkedHashMap<>();
    Map<String, Student> students = new LinkedHashMap<>();

    public void addCourse(Course course) {
        courses.put(course.courseCode, course);
    }

    public void addStudent(Student student) {
        students.put(student.studentId, student);
    }

    public void listCourses() {
        System.out.println("\n--- Available Courses ---");
        for (Course c : courses.values()) {
            c.printInfo();
        }
    }

    public boolean registerStudent(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course code.");
            return false;
        }
        if (student.registeredCourseCodes.contains(courseCode)) {
            System.out.println(student.name + " is already registered for " + courseCode + ".");
            return false;
        }
        if (course.availableSlots() <= 0) {
            System.out.println("Course " + courseCode + " is full.");
            return false;
        }

        course.registeredStudentIds.add(studentId);
        student.registeredCourseCodes.add(courseCode);
        System.out.println(student.name + " successfully registered for " + course.title + ".");
        return true;
    }

    public boolean dropStudent(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course code.");
            return false;
        }
        if (!student.registeredCourseCodes.contains(courseCode)) {
            System.out.println(student.name + " is not registered for " + courseCode + ".");
            return false;
        }

        student.registeredCourseCodes.remove(courseCode);
        course.registeredStudentIds.remove(studentId);
        System.out.println(student.name + " dropped " + course.title + ".");
        return true;
    }
}
