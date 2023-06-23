import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    String secretNumber;
    int guesses;
    boolean isMultiplayer;

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

    }
}