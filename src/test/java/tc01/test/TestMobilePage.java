package tc01.test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Test
public class TestMobilePage {
    public static void TestSortingByName() {

        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/");

            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            Select dropdown = new Select(driver.findElement(By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")));
            dropdown.selectByVisibleText("Name");

            List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
            List<String> productNames = new ArrayList<>();
            for (WebElement product : products) {
                productNames.add(product.getText());
            }

            List<String> sortedProductNames = new ArrayList<>(productNames);
            Collections.sort(sortedProductNames);

            if (productNames.equals(sortedProductNames)) {
                System.out.println("Products are sorted by name");
            } else {
                System.out.println("Products are not sorted by name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

