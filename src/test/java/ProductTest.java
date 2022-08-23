import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void productPriceInCartShouldBeCorrect() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        /*
        //button[text()='Add to Cart'] или //*[text()='Add to Cart']
        //div[text()='Sauce Labs Backpack'] или //*[text()='Sauce Labs Backpack']
        //*[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item']//button
         */
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String price = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item_price']")).getText();
        assertEquals(price, "$29.99", "Price is incorrect");
        String title = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']")).getText();
        assertEquals(title, "Sauce Labs Backpack");
    }
}
