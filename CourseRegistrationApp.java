import java.util.Scanner;

public class CourseRegistrationApp {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();

        // Seed some sample data
        system.addCourse(new Course("CS101", "Intro to Programming", "Basics of coding", 2, "Mon/Wed 10am"));
        system.addCourse(new Course("CS102", "Data Structures", "Arrays, lists, trees", 2, "Tue/Thu 1pm"));
        system.addCourse(new Course("MATH201", "Calculus I", "Limits and derivatives", 3, "Mon/Wed/Fri 9am"));

        system.addStudent(new Student("S1", "Aisha"));
        system.addStudent(new Student("S2", "Ravi"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Student Course Registration System =====");
        System.out.println("(Sample students loaded: S1 = Aisha, S2 = Ravi)");

        while (running) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. List Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    system.listCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String sid = scanner.nextLine().trim();
                    System.out.print("Enter Course Code: ");
                    String ccode = scanner.nextLine().trim();
                    system.registerStudent(sid, ccode);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String sid2 = scanner.nextLine().trim();
                    System.out.print("Enter Course Code: ");
                    String ccode2 = scanner.nextLine().trim();
                    system.dropStudent(sid2, ccode2);
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}