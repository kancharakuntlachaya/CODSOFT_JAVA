import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();

        while (numSubjects <= 0) {
            System.out.print("Please enter a number greater than 0: ");
            numSubjects = scanner.nextInt();
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            int mark;
            while (true) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (0-100): ");
                mark = scanner.nextInt();
                if (mark >= 0 && mark <= 100) {
                    break;
                }
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
            }
            marks[i] = mark;
            totalMarks += mark;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}   

