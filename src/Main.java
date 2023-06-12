import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int generateNumber() {
        Random random = new Random();

        int uniqueNumber = random.nextInt(9) + 1;

        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(9);

            while (String.valueOf(uniqueNumber).contains(String.valueOf(digit))) {
                digit = random.nextInt(9);
            }

            uniqueNumber = uniqueNumber * 10 + digit;
        }

        return uniqueNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cows and Bulls!");
        System.out.print("Do you want to play single-(1) or multiplayer(2): ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            singleplayer();
        } else if(choice == 2) {
            multiplayer();
        } else {
            System.out.println("Not a valid option.");
        }
    }
}