package utils;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String readText(String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine();

            if (HelperUtils.isValidText(value)) {
                return value.trim();
            }

            System.out.println(
                    "Invalid input. Text cannot be empty."
            );
        }
    }

    public int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                int value = Integer.parseInt(input);

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
            }
        }
    }

    public int readInt(
            String message,
            int minimum,
            int maximum) {

        while (true) {

            int value = readInt(message);

            if (HelperUtils.isInRange(
                    value,
                    minimum,
                    maximum)) {

                return value;
            }

            System.out.println(
                    "Invalid input. Enter a number between "
                            + minimum + " and " + maximum + "."
            );
        }
    }

    public double readDouble(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                double value = Double.parseDouble(input);

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a decimal number."
                );
            }
        }
    }

    public boolean readConfirmation(String message) {

        while (true) {

            System.out.print(message + " (yes/no): ");

            String value = scanner.nextLine().trim();

            if (HelperUtils.isOneOf(
                    value.toLowerCase(),
                    new Object[]{"yes", "y"})) {

                return true;
            }

            if (HelperUtils.isOneOf(
                    value.toLowerCase(),
                    new Object[]{"no", "n"})) {

                return false;
            }

            System.out.println(
                    "Invalid input. Please enter yes or no."
            );
        }
    }

    public String readOneOf(
            String message,
            Object[] allowedValues) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (HelperUtils.isOneOf(
                    value,
                    allowedValues)) {

                return value;
            }

            System.out.println(
                    "Invalid choice. Please select one of the allowed values."
            );
        }
    }

    public void close() {

        scanner.close();
    }
}