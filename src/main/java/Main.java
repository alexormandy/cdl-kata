import controller.Checkout;
import service.InputValidator;

public class Main {

    public static void main(String[] args) {

        InputValidator inputValidator = new InputValidator();
        Checkout checkout = new Checkout();

        boolean openTransaction = true;

        System.out.println("Welcome to the Checkout System, input your items individually as a string e.g A, B, C");

        while (openTransaction) {

            String validatedInput = inputValidator.itemValidator("Ready to Scan...");

            try {

                int currentBalance = checkout.calculateTotal(validatedInput,
                        inputValidator.validateQuantity("Enter the quantity of item "
                        + validatedInput
                        + ":"));

                System.out.println("Your sub-total is: " + currentBalance);

                String endInput = inputValidator.inputValidator("Want to close your transaction? Enter END or hit return.");

                if (endInput.equals("END")) {
                    int finalBalance = checkout.getCurrentBalance();
                    System.out.println("Your final balance is: " + finalBalance);
                    System.out.println("Thanks come again.");
                    openTransaction = false;
                }

            } catch (Exception error) {
                System.out.println(error);
                openTransaction = false;
            }

        }
    }
}
