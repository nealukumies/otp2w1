package shopping;

/*
 Ask the user for item prices and quantities, then calculate the total cost.
2. Add localization for:
o English
o Finnish
o Swedish
o Japanese
 */

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    private int totalCost;

    public ShoppingCart() {
        this.totalCost = 0;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void addTotalCost(int cost) {
        this.totalCost += cost;
    }

    public void calculateItemCost(int price, int quantity) {
        int cost = price * quantity;
        addTotalCost(cost);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("1. English (US)");
        System.out.println("2. Finnish (Suomi)");
        System.out.println("3. Swedish (Sverige)");
        System.out.println("4. Japanese (日本)");
        System.out.println("Choose language:");
        String choice = scanner.nextLine();
        String language;
        String country;
        switch (choice) {
            case "1":
                language = "en";
                country = "US";
                break;
            case "2":
                language = "fi";
                country = "FI";
                break;
            case "3":
                language = "sv";
                country = "SE";
                break;
            case "4":
                language = "ja";
                country = "JP";
                break;
            default:
                language = "en";
                country = "US";
                break;
        }

        Locale locale = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        String welcomeMessage = rb.getString("welcome");
        System.out.println(welcomeMessage);
        String enterItemAmountMessage = rb.getString("itemAmount");
        String enterPriceMessage = rb.getString("price");
        String enterQuantityMessage = rb.getString("quantity");
        String totalCostMessage = rb.getString("totalCost");
        String itemNumberMessage = rb.getString("itemNumber");

        System.out.println(enterItemAmountMessage);
        int itemAmount = Integer.parseInt(scanner.nextLine());
        int counter = 1;

        while (counter <= itemAmount) {
            System.out.println(itemNumberMessage + counter);
            System.out.println(enterPriceMessage);
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println(enterQuantityMessage);
            int quantity = Integer.parseInt(scanner.nextLine());
            shoppingCart.calculateItemCost(price, quantity);
            counter++;
        }

        System.out.println(totalCostMessage + " " + shoppingCart.getTotalCost());

    }
}
