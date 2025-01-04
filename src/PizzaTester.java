/*
>> Name: Serge MUNEZA
>> Class: PizzaTester
>> Description: This class serves as the entry point for testing the Pizza class. It allows users to order pizzas
    by specifying their desired meat and vegetable choices, and handles input validation and error handling.
>> Instance variables: None (uses local variables within methods).
>> Methods:
    - main: Handles the program execution, user interaction, and pizza ordering logic.
    - validateMeatChoice: Validates the user's input for the meat choice.
    - validateVegChoice: Validates the user's input for the vegetable choice.
 */
import java.util.Scanner;

public class PizzaTester {
    public static void main(String[] args) {
        System.out.println("WELCOME TO PIZZA ORDERING SYSTEM - Powered by Serge MUNEZA");
        System.out.println("__________________________________________________________");
        // Display a randomly generated pizza
        Pizza randomPizza = new Pizza();
        System.out.println("Sample pizza: " + randomPizza);

        // Ensure the user provides an integer for the number of pizzas (N) as 'a command-line argument'.
        if (args.length < 1) {
            System.out.println("NOTE: Please specify the number of pizzas you want to order as a command-line argument.");
            System.out.println("Example: java PizzaTester 3");
            return;
        }

        //Variable "N" Stands for Number Of Pizzas
        int N;
        try {
            N = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Argument must be an integer.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            try {
                System.out.println("\nORDERING PIZZA No. " + (i + 1) + ":");

                // Validate and get meat choice
                System.out.println("Available meat options: BEEF, CHICKEN, PORK");
                System.out.print("Enter your meat choice: ");
                String meatInput = scanner.nextLine().toUpperCase();

                Pizza.MeatChoice meatChoice = validateMeatChoice(meatInput);

                // Validate and get vegetable choice
                System.out.println("Available vegetable options: BROCCOLI, POTATOES, MUSHROOMS, ONIONS, CORN");
                System.out.print("Enter your vegetable choice: ");
                String vegInput = scanner.nextLine().toUpperCase();

                Pizza.VegChoice vegChoice = validateVegChoice(vegInput);

                // Create and display the pizza
                Pizza userPizza = new Pizza(8, meatChoice, vegChoice); // Default to 8 slices
                System.out.println("Your ordered pizza with: " + userPizza);

            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // It repeats this iteration for invalid input.
            }
        }
    }

    // Validation method for MeatChoice
    private static Pizza.MeatChoice validateMeatChoice(String input) throws InvalidDataException, InvalidDataException {
        for (Pizza.MeatChoice choice : Pizza.MeatChoice.values()) {
            if (choice.name().equalsIgnoreCase(input)) {
                return choice;
            }
        }
        throw new InvalidDataException("Invalid meat choice: " + input);
    }

    // Validation method for VegChoice
    private static Pizza.VegChoice validateVegChoice(String input) throws InvalidDataException {
        for (Pizza.VegChoice choice : Pizza.VegChoice.values()) {
            if (choice.name().equalsIgnoreCase(input)) {
                return choice;
            }
        }
        throw new InvalidDataException("Invalid vegetable choice: " + input);
    }
}
