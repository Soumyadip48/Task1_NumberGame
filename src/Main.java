import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;
        String playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            int targetNumber = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds + ": Guess the number between 1 and 100");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += maxAttempts - attempts + 1; // Score based on attempts taken
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts. The number was: " + targetNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Your Total Score: " + totalScore);
    }
}