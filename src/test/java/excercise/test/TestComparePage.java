package excercise.test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import excercise.model.ComparePage;

@Test
public class TestComparePage {
    public void testComparePage() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        ComparePage comparePage = new ComparePage(driver);
        comparePage.clickMobileMenu();
        comparePage.addComparedProduct();
        comparePage.clickCompare();

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        comparePage.checkHeader("COMPARE PRODUCTS");
        comparePage.checkComparedProduct();
        comparePage.clickClosetBtn();
        driver.quit();
    }
}
