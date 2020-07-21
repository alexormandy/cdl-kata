package service;

import java.util.Scanner;

public class InputValidator {

    Scanner scanner = new Scanner(System.in);
    String parsedItem;

    public String inputValidator(String prompt) {

        System.out.println(prompt);
        String userInput = scanner.nextLine();

        return userInput;
    }

    public String itemValidator(String prompt) {
        boolean valid = false;

        System.out.println(prompt);

        while (!valid) {
            if (scanner.hasNext("[A-Z,a-z]")) {
                parsedItem = scanner.next("[A-Z,a-z]");
                valid = true;
            } else {
                System.out.println("Invalid Input, try again...");
            }
            scanner.nextLine();
        }

        return parsedItem.toUpperCase();
    }

    public int validateQuantity(String prompt) {
        boolean valid = false;

        System.out.println(prompt);

        while (!valid) {
            if (scanner.hasNext("[1-9]")) {
                parsedItem = scanner.next("[1-9]");
                valid = true;
            } else {
                System.out.println("Invalid Input, try again...");
            }
            scanner.nextLine();
        }

        return Integer.parseInt(parsedItem);
    }
}