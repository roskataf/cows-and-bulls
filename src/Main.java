import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int attempts;
    static boolean isMultiplayer;

    public static void playMultiplayer(Scanner scanner) {
        String number1 = String.valueOf(generateNumber());
        String number2 = String.valueOf(generateNumber());
        attempts = 0;

        while (true) {
            System.out.print("Player 1, enter your guess: ");
            String guess1 = scanner.next();

            ArrayList<Integer> bullsAndCows1 = countBullsAndCows(guess1, number2);
            int bulls1 = bullsAndCows1.get(0);
            int cows1 = bullsAndCows1.get(1);

            if (bulls1 == 4) {
                endGame("Player 1", number2, number1);
                return;
            }

            printBullsAndCows(bulls1, cows1);


            System.out.print("Player 2, enter your guess: ");
            String guess2 = scanner.next();

            ArrayList<Integer> bullsAndCows2 = countBullsAndCows(guess2, number1);
            int bulls2 = bullsAndCows2.get(0);
            int cows2 = bullsAndCows2.get(1);

            if (bulls2 == 4) {
                endGame("Player 2", number1, number2);
                return;
            }

            printBullsAndCows(bulls2, cows2);

            attempts += 1;
        }
    }

    public static ArrayList<Integer> countBullsAndCows(String guess, String secretNumber) {
        ArrayList<Integer> bullsAndCows = new ArrayList<>();
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            char digit = guess.charAt(i);

            if (digit == secretNumber.charAt(i)) {
                bulls++;
            } else if (secretNumber.contains(String.valueOf(digit))) {
                cows++;
            }
        }
        bullsAndCows.add(bulls);
        bullsAndCows.add(cows);

        return bullsAndCows;
    }

    public static void play(int choice, Scanner scanner) {
        String secretNumber = String.valueOf(generateNumber());
        attempts = 0;
        if (choice == 1) {
            isMultiplayer = false;
        } else if (choice == 2) {
            playMultiplayer(scanner);
            return;
        } else {
            System.out.println("Not a valid option.");
        }

        while (true) {
            System.out.print("Enter guess: ");
            String guess = scanner.next();

            ArrayList<Integer> bullsAndCows = countBullsAndCows(guess, secretNumber);
            int bulls = bullsAndCows.get(0);
            int cows = bullsAndCows.get(1);

            if (bulls == 4) {
                endGame("You", secretNumber, "");
                return;
            }

            printBullsAndCows(bulls, cows);

            attempts += 1;
        }
    }

    public static void endGame(String winner, String winnerNumber, String loserNumber) {
        System.out.println(winner + " wins the game!");
        System.out.println(winner + " number was: " + winnerNumber);
        if (winner.equalsIgnoreCase("Player 1")) {
            System.out.println("Player 2 number was: " + loserNumber);
        } else {
            System.out.println("Player 1 number was: " + loserNumber);
        }
        System.out.println("Total attempts: " + attempts);
    }

    public static void printBullsAndCows(int bulls, int cows) {
        System.out.println("Bulls: " + bulls);
        System.out.println("Cows: " + cows);
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