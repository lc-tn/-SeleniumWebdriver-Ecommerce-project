package tc05.test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tc05.model.AccountPage;

import java.time.Duration;

@Test
public class TestAccountPage {
    public static void TestVerifyAccount(){
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/");

            AccountPage accountPage = new AccountPage(driver);
            accountPage.clickMyAccountLink();
            accountPage.clickCreateAccountLink();

            // Use the new methods here...
            accountPage.enterFirstName("a");
            accountPage.enterLastName("a");
            accountPage.enterEmail("cfgcyhfvyhkj@example.com");
            accountPage.enterPassword("123456");
            accountPage.enterConfirmPassword("123456");

            accountPage.clickRegisterButton();

            // Verify registration is done...
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-msg")));
            String successMessage = driver.findElement(By.cssSelector(".success-msg")).getText();
            Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.");

            accountPage.clickTvMenuLink();
            accountPage.clickAddToWishlistLink();

            accountPage.clickShareWishlistButton();

            accountPage.enterEmail("lamtanloc@example.com");
            accountPage.enterMessage("Check out my wishlist!");
            accountPage.clickShareWishlistSubmitButton();

            // Check wishlist is shared...
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-msg")));
            String wishlistSharedMessage = driver.findElement(By.cssSelector(".success-msg")).getText();
            Assert.assertEquals(wishlistSharedMessage, "Your Wishlist has been shared.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
