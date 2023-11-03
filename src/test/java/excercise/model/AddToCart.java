package excercise.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {
    private WebDriver driver;
    private By mobileMenuSelector = By.linkText("MOBILE");
    private By sonyAddToCardSelector = By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]");
    private By quanitySelector = By.xpath("//input[@title='Qty']");
    private By errorMsgSelector = By.className("error");
    private By submitQuanityBtn = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
    private By emptyCardBtn = By.xpath("//span[contains(text(),'Empty Cart')]");
    private By tableSelector = By.tagName("table");

    //----------------------------------------------
    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement mobileMenu() {
        return driver.findElement(mobileMenuSelector);
    }

    public WebElement sonyAddToCard() {
        return driver.findElement(sonyAddToCardSelector);
    }

    public WebElement quantity() {
        return driver.findElement(quanitySelector);
    }

    public WebElement errorMsg() {
        return driver.findElement(errorMsgSelector);
    }

    //----------------------------------------------
    public void clickMobileMenu() {
        mobileMenu().click();
    }

    public void addSonyToCard() {
        sonyAddToCard().click();
    }

    public void inputQuantity(int num) {
        quantity().clear();
        quantity().sendKeys(String.valueOf(num));
    }

    public void submit() {
        driver.findElement(submitQuanityBtn).click();
    }

    public boolean errorMsg(String msg) {
        String error = errorMsg().getText();
        return error.compareTo(msg) == 0;
    }

    public void clickEmptyCard() {
        driver.findElement(emptyCardBtn).click();
    }

    public boolean isCardEmpty() {
        try {
            WebElement table = driver.findElement(tableSelector);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}