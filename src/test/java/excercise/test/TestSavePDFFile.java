package excercise.test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import excercise.model.SavePDFPage;

@Test
public class TestSavePDFFile {
    public static void TestSavePDFFile(){
        WebDriver driver = driverFactory.getChromeDriver();

            driver.get("http://live.techpanda.org/");
            SavePDFPage loginPage = new SavePDFPage(driver);
            loginPage.clickMyAccountLink();
            loginPage.enterEmail("lamtanloc@gmail.com");
            loginPage.enterPassword("123456");
            loginPage.clickLoginButton();

            SavePDFPage pdfPage = new SavePDFPage(driver);
            pdfPage.clickViewOrder();
            pdfPage.clickPrintOrder();

            driver.quit();
    }
}
