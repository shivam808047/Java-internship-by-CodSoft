import java.util.Scanner;
import java.util.Random;

public class EnhancedNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        
        boolean playAgain = true;
        
        System.out.println("Welcome to the Enhanced Number Guessing Game!");
        
        while (playAgain) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfGuesses = 0;
            
            System.out.println("I have chosen a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts.");
            
            while (numberOfGuesses < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfGuesses++;
                
                if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + numberOfGuesses + " attempts.");
                    score++;
                    break;
                }
                
                if (numberOfGuesses < maxAttempts) {
                    System.out.println("You have " + (maxAttempts - numberOfGuesses) + " attempts remaining.");
                } else {
                    System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}

