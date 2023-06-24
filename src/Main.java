import java.sql.DataTruncation;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int attempts;
    static boolean isMultiplayer;

    public static void checkGuess(String guess, String secretNumber) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            char digit = guess.charAt(i);

            if (digit == secretNumber.charAt(i)) {
                bulls++;
            }
            else if (secretNumber.contains(String.valueOf(digit))) {
                cows++;
            }


            if (bulls == 4) {
                System.out.println("You won the game!");
                System.out.println("The number was: " + secretNumber);
                System.out.println("Total attempts: " + attempts);
                break;
            }
        }
        System.out.println("Bulls: " + bulls);
        System.out.println("Cows: " + cows);
    }
    public static void play(int choice, Scanner scanner) {
        String secretNumber = String.valueOf(generateNumber());
        attempts = 0;
        if (choice == 1) {
            isMultiplayer = false;
        } else if(choice == 2) {
            isMultiplayer = true;
        } else {
            System.out.println("Not a valid option.");
        }

        while (true) {
            System.out.print("Enter guess: ");
            String guess = scanner.nextLine();

            checkGuess(guess, secretNumber);

            attempts += 1;
        }
    }
    public static int generateNumber() {
        Random random = new Random();

        int secretNumber = random.nextInt(9) + 1;

        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(9);

            while (String.valueOf(secretNumber).contains(String.valueOf(digit))) {
                digit = random.nextInt(9);
            }

            secretNumber = secretNumber * 10 + digit;
        }

        return secretNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cows and Bulls!");
        System.out.print("Do you want to play single-(1) or multiplayer(2): ");

        int choice = scanner.nextInt();

        play(choice, scanner);
    }
}