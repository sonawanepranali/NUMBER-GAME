import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int userGuess;

            System.out.println("\nRound " + (rounds + 1) + ": Guess a number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("\nGame Over. Your total score is: " + totalScore);
                break;
            }

        } while (true);

        scanner.close();
    }
}
