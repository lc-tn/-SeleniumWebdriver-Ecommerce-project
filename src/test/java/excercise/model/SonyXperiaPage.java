package excercise.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SonyXperiaPage {
    private WebDriver driver;

    private By mobileMenu = By.linkText("MOBILE");
    private By sonyXperiaPrice = By.xpath("//span[contains(text(),'$100.00')]");
    private By sonyXperiaLink = By.xpath("//img[@id='product-collection-image-1']");
    private By detailPagePrice = By.xpath("//span[@class='price']");

    public SonyXperiaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    public String getSonyXperiaPrice() {
        return driver.findElement(sonyXperiaPrice).getText();
    }

    public void clickSonyXperiaLink() {
        driver.findElement(sonyXperiaLink).click();
    }

    public String getDetailPagePrice() {
        return driver.findElement(detailPagePrice).getText();
    }
}