package tc06.test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tc05.model.AccountPage;
import tc06.model.PurchaseProductPage;

import java.time.Duration;

@Test
public class TestVerifyPurchaseProduct {
    public static void TestVerifyPurchaseProduct(){
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/");


            PurchaseProductPage purchaseProductPage = new PurchaseProductPage(driver);
            purchaseProductPage.clickMyAccountLink();

            // Login and press whistlist link
            purchaseProductPage.enterEmail("lamtanloc@gmail.com");
            purchaseProductPage.enterPassword("123456");
            purchaseProductPage.clickLoginButton();
            purchaseProductPage.clickWhistListLink();

            purchaseProductPage.clickAddToCartLink();

            purchaseProductPage.estimateShipping("United States", "Alabama","123");

            //Verify Shipping cost generated
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='s_method_flatrate_flatrate']")));
            String shippingCost = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText();
            Assert.assertNotNull(shippingCost);

            //Select Shipping Cost, Update Total and Verify shipping cost is added to total
            boolean check = purchaseProductPage.addShippingCost();
            Assert.assertTrue(check);

            purchaseProductPage.clickProceedBtn();
            purchaseProductPage.inputAddress("HCM");
            purchaseProductPage.inputCity("Ha Noi");
            purchaseProductPage.inputState();
            purchaseProductPage.inputZip("123");
            purchaseProductPage.inputPhone("012345678");
            purchaseProductPage.clickContinueBtn1();
            purchaseProductPage.clickContinueBtn2();
            purchaseProductPage.clickCheckMoneyOrder();
            purchaseProductPage.clickContinueBtn3();
            purchaseProductPage.clickPlaceOrder();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
