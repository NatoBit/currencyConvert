import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Functions functions = new Functions();
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String status = "";
        String baseCurrency = "";
        String targetCurrency = "";
        double amount = 0;
        double totalAmount = 0;
        double exchangeRate = 0;
        String lastUpdate = "";
        String currencyMenu = """
                        1.  United States - Dollar (USD)
                        2.  Europe - Euro (EUR)
                        3.  United Kingdom - Pound (GBP)
                        4.  Canada - Canadian Dollar (CAD)
                        5.  Japan - Yen (JPY)
                        6.  China - Yuan (CNY)
                        7.  Mexico - Peso (MXN)
                        8.  Brazil - Real (BRL)
                        9.  Argentina - Peso (ARS)
                        10. Exit
                """;

        String byeMessage = "Take care and see you soon!";
        String boundaryMessageMain = "⚠️ Invalid option, please enter a number between 1 and 10.";
        String boundaryMessageExit = "⚠️ Invalid option, please enter a number between 1 and 2.";


        while (true) {
            System.out.println("""
                                    ************************************************************
                                    Welcome!
                                    Before we begin, please select your country of origin:
                                    ************************************************************
                                    """);
            System.out.println(currencyMenu);

            option = functions.getValidOption(scanner, 1, 10, boundaryMessageMain);

            if (option == 10) {
                break;
            } else {
                baseCurrency = functions.selectCurrency(option);
            }

            System.out.println("""
                                    ************************************************************
                                    Please let us know which country's exchange rate you would like to consult.
                                    ************************************************************
                                    """);
            System.out.println(currencyMenu);

            option = functions.getValidOption(scanner, 1, 10, boundaryMessageMain);

            if (option == 10) {
                break;
            } else {
                targetCurrency = functions.selectCurrency(option);
            }

            MakeQuery query = new MakeQuery();
            Query myQuery = query.makeQuery(baseCurrency, targetCurrency);
            exchangeRate = myQuery.conversionRate();
            lastUpdate = myQuery.lastUpdate();


            System.out.println("""
                                ************************************************************
                                Please specify the amount you wish to change, and we'll provide you with the latest exchange rates!
                                ************************************************************
                                """);

            amount = functions.getValidOptionDouble(scanner, boundaryMessageMain);
            totalAmount = functions.calculateTotal(amount, exchangeRate);

            System.out.println("************************************************************");
            System.out.println("The exchange rate from " + baseCurrency + " to " + targetCurrency + " is: " + exchangeRate);
            System.out.println("Last update: " + lastUpdate);
            System.out.println("The total amount after conversion is: $" + totalAmount + " " + targetCurrency);
            System.out.println("************************************************************");

            System.out.println("Would you like to make another inquiry?");
            System.out.println("""
                                1. Yes
                                2. No
                                """);

            option = functions.getValidOption(scanner, 1, 2, boundaryMessageExit);

            if (option == 2) {
                break;
            }
        }
        scanner.close();
    }
}