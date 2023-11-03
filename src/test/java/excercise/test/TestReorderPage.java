package excercise.test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import excercise.model.ReorderPage;

@Test
public class TestReorderPage {
    public void testReorderPage() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        ReorderPage reOrderPage = new ReorderPage(driver);
        reOrderPage.clickAccount();
        reOrderPage.clickLogin();
        reOrderPage.inputEmailAndPassword("lamtanloc@gmail.com", "123456");
        reOrderPage.clickLoginSubmit();
        reOrderPage.clickReorderBtn();
        boolean check1 = reOrderPage.addShippingCost();
        reOrderPage.inputQuantity(100);
        reOrderPage.updateQuantity();
        // reOrderPage.clickShippingCostButton();
        boolean check = reOrderPage.addShippingCost();
        if(check1!=check) {
            Assert.assertEquals(check1,check);
        }
        //reOrderPage.clickShippingCostButton();
        reOrderPage.clickEstimate();
        reOrderPage.clickProceedBtn();
        reOrderPage.clickContinueBtn1();
        reOrderPage.clickContinueBtn2();
        reOrderPage.clickCheckMoneyOrder();
        reOrderPage.clickContinueBtn3();
        reOrderPage.clickPlaceOrder();
    }
}