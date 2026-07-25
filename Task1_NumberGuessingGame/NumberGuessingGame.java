import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // random number 1 to 100
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attemptsUsed < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                    continue;
                }
                attemptsUsed++;

                if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    int roundScore = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("Correct! You guessed it in " + attemptsUsed + " attempt(s). You earned " + roundScore + " points.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attemptsUsed));
                } else {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attemptsUsed));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Total score so far: " + totalScore);
            System.out.print("Play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing! Final score: " + totalScore);
        scanner.close();
    }
}