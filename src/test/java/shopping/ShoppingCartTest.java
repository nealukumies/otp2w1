package shopping;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setup() {
        shoppingCart = new ShoppingCart();
    }


    @Test
    void getTotalCostTest() {
        int initialCost = shoppingCart.getTotalCost();
        assertEquals(0, initialCost);
        shoppingCart.addTotalCost(150);
        int updatedCost = shoppingCart.getTotalCost();
        assertEquals(150, updatedCost);
    }

    @Test
    void addTotalCostTest() {
        shoppingCart.addTotalCost(50);
        assertEquals(50, shoppingCart.getTotalCost());
    }

    @Test
    void calculateItemCostTest() {
        int price = 10;
        int quantity = 3;
        shoppingCart.calculateItemCost(price, quantity);
        assertEquals(30, shoppingCart.getTotalCost());
    }

    @Test
    void calculateMultipleItemCostsTest() {
        shoppingCart.calculateItemCost(5, 2); // 10
        shoppingCart.calculateItemCost(20, 1); // 20
        shoppingCart.calculateItemCost(15, 3); // 45
        assertEquals(75, shoppingCart.getTotalCost());
    }

    @Test
    void calculateItemCostWithZeroQuantityTest() {
        shoppingCart.calculateItemCost(100, 0);
        assertEquals(0, shoppingCart.getTotalCost());
    }

    @Test
    void calculateItemCostWithZeroPriceTest() {
        shoppingCart.calculateItemCost(0, 5);
        assertEquals(0, shoppingCart.getTotalCost());
    }

    @Test
    void testSetResourceBundleEnglish() {
        shoppingCart.setResourceBundle("1");
        assertEquals("Enter the number of items to purchase:", shoppingCart.rb.getString("itemAmount"));
        assertEquals("Enter the price for item:", shoppingCart.rb.getString("price"));
        assertEquals("Enter the quantity for item:", shoppingCart.rb.getString("quantity"));
        assertEquals("Total cost:", shoppingCart.rb.getString("totalCost"));
        assertEquals("Item nr:", shoppingCart.rb.getString("itemNumber"));
    }

    @Test
    void testSetResourceBundleFinnish() {
        shoppingCart.setResourceBundle("2");
        assertEquals("Syötä ostettavien tuotteiden määrä:", shoppingCart.rb.getString("itemAmount"));
        assertEquals("Syötä tuotteen hinta:", shoppingCart.rb.getString("price"));
        assertEquals("Syötä tuotteen määrä:", shoppingCart.rb.getString("quantity"));
        assertEquals("Kokonaishinta:", shoppingCart.rb.getString("totalCost"));
        assertEquals("Tuotenro:", shoppingCart.rb.getString("itemNumber"));
    }

    @Test
    void testSetResourceBundleSwedish() {
        shoppingCart.setResourceBundle("3");
        assertEquals("Ange antalet varor att köpa:", shoppingCart.rb.getString("itemAmount"));
        assertEquals("Ange priset för varan:", shoppingCart.rb.getString("price"));
        assertEquals("Ange mängden varor:", shoppingCart.rb.getString("quantity"));
        assertEquals("Total kostnad:", shoppingCart.rb.getString("totalCost"));
        assertEquals("Vara nr:", shoppingCart.rb.getString("itemNumber"));
    }

    @Test
    void testSetResourceBundleJapanese() {
        shoppingCart.setResourceBundle("4");
        assertEquals("「購入する商品の数を入力してください:」", shoppingCart.rb.getString("itemAmount"));
        assertEquals("「商品の価格を入力してください:」", shoppingCart.rb.getString("price"));
        assertEquals("「商品の数量を入力してください:」", shoppingCart.rb.getString("quantity"));
        assertEquals("「合計金額:」", shoppingCart.rb.getString("totalCost"));
        assertEquals("「商品番号:」", shoppingCart.rb.getString("itemNumber"));
    }

    @Test
    void testSetResourceBundleDefault() {
        shoppingCart.setResourceBundle("invalid_choice");
        assertEquals("Enter the number of items to purchase:", shoppingCart.rb.getString("itemAmount"));
        assertEquals("Enter the price for item:", shoppingCart.rb.getString("price"));
        assertEquals("Enter the quantity for item:", shoppingCart.rb.getString("quantity"));
        assertEquals("Total cost:", shoppingCart.rb.getString("totalCost"));
        assertEquals("Item nr:", shoppingCart.rb.getString("itemNumber"));
    }

}
