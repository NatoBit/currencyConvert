import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    String mismatchMessage = "⚠️ Invalid input, please enter a number.";

    public String selectCurrency(int option) {
        String currency = switch (option) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "GBP";
            case 4 -> "CAD";
            case 5 -> "JPY";
            case 6 -> "CNY";
            case 7 -> "MXN";
            case 8 -> "BRL";
            case 9 -> "ARS";
            default -> "";
        };

        return currency;
    }

    public double calculateTotal(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public int getValidOption(Scanner scanner, int min, int max, String errorMessage) {
        int option = -1;
        while (true) {
            try {
                option = scanner.nextInt();
                if (option >= min && option <= max) {
                    return option;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (InputMismatchException e) {
                System.out.println(mismatchMessage);
                scanner.next();
            }
        }
    }

    public double getValidOptionDouble(Scanner scanner, String errorMessage) {
        double amount = 0;
        while (true) {
            try {
                amount = scanner.nextDouble();
                return amount;
            } catch (InputMismatchException e) {
                System.out.println(mismatchMessage);
                scanner.next();
            }
        }
    }
}
