package excercise.test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import excercise.model.AddToCart;

@Test
public class TestAddToCart {
    public void testAddToCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        AddToCart addToCart = new AddToCart(driver);
        addToCart.clickMobileMenu();
        addToCart.addSonyToCard();
        addToCart.inputQuantity(1000);
        addToCart.submit();
        if (addToCart.errorMsg("The requested quantity for \"Sony Xperia\" is not available")) {
            System.out.println("Correct error message");
        } else {
            System.out.println("Incorrect error message");
        }
        addToCart.clickEmptyCard();
        if (addToCart.isCardEmpty()) {
            System.out.println("Card is empty");
        } else {
            System.out.println("Card is not empty");
        }

        driver.quit();
    }
}