package excercise.test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TestPriceSonyXperia {
    public static void TestPriceSonyXperia() {

        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/");

            WebElement mobileMenu = driver.findElement(By.id("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            WebElement sonyXperiaPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String listPrice = sonyXperiaPriceElement.getText();

            WebElement sonyXperiaLink = driver.findElement(By.xpath("//img[@id='product-collection-image-1']"));
            sonyXperiaLink.click();

            WebElement detailPagePriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String detailPrice = detailPagePriceElement.getText();

            if (listPrice.equals(detailPrice)) {
                System.out.println("The product price on the list and details page are equal.");
            } else {
                System.out.println("The product price on the list and details page are not equal.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
