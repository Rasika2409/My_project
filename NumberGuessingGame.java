import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 7;

        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {

            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attemptsLeft > 0) {

                System.out.print("Enter your guess: ");

                
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input. Enter a number: ");
                    scanner.next();
                }

                int guess = scanner.nextInt();
                attemptsLeft--;

                if (guess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("🏆 Rounds won so far: " + roundsWon);

            
            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine(); 
            String choice = scanner.nextLine().trim().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Total rounds won: " + roundsWon);
        scanner.close();
    }
}
