package excercise.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseProductPage {
    WebDriver driver;

    By myAccountLink = By.linkText("MY ACCOUNT");
    By emailInput = By.xpath("//input[@id='email']");
    By passwordInput = By.xpath("//input[@id='pass']");
    By loginButton = By.xpath("//span[contains(text(),'Login')]");
    By whistListLink = By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']");
    By addToCartLink = By.xpath("//span[contains(text(),'Add to Cart')]");
    By countryInput = By.xpath("//select[@id='country']");
    By regionInput = By.xpath("//select[@id='region_id']");
    By zipInput = By.xpath("//input[@id='postcode']");
    By estimateLink = By.xpath("//span[contains(text(),'Estimate')]");
    By selectShippingCostButton = By.xpath("//input[@id='s_method_flatrate_flatrate']");
    By updateTotalButton = By.xpath("//span[contains(text(),'Update Total')]");
    By subTotal = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)");
    By shippingCost = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)");
    By totalCost = By.cssSelector("strong span[class='price']");

    By proceedToCheckoutBtn = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']");
    By inputAddress = By.name("billing[street][]");
    By inputCity = By.name("billing[city]");
    By zipInputChekout = By.id("billing:postcode");
    By stateDropdown = By.id("billing:region_id");
    By inputPhone = By.id("billing:telephone");
    By continueBtn1 = By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]");
    By continueBtn2 = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");
    By checkMoneyOrder = By.xpath("//label[@for='p_method_checkmo']");
    By continueBtn3 = By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]");
    By placeOrder = By.xpath("//span[contains(text(),'Place Order')]");

    public PurchaseProductPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void enterEmail(String email){
        WebElement enterEmail = driver.findElement(emailInput);
        enterEmail.clear();
        enterEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement enterEmail = driver.findElement(passwordInput);
        enterEmail.clear();
        enterEmail.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickWhistListLink() {
        driver.findElement(whistListLink).click();
    }

    public void clickAddToCartLink() {
        driver.findElement(addToCartLink).click();
    }

    public void estimateShipping(String country, String region, String zip) {
        new Select(driver.findElement(countryInput)).selectByVisibleText(country);
        new Select(driver.findElement(regionInput)).selectByVisibleText(region);
        driver.findElement(zipInput).sendKeys(zip);
        driver.findElement(estimateLink).click();
    }

    public boolean addShippingCost(){
        driver.findElement(selectShippingCostButton).click();
        driver.findElement(updateTotalButton).click();
        String subtotalString = driver.findElement(subTotal).getText().replace(",", "").replace("$", "");
        String shippingString = driver.findElement(shippingCost).getText().replace(",", "").replace("$", "");
        String totalString = driver.findElement(totalCost).getText().replace(",", "").replace("$", "");
        double subtotal = Double.parseDouble(subtotalString);
        double shipping = Double.parseDouble(shippingString);
        double total = Double.parseDouble(totalString);
        return (total == shipping + subtotal);
    }

    public void clickProceedBtn() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void inputCity(String city) {
        driver.findElement(inputCity).sendKeys(city);
    }

    public void inputState() {
        new Select(driver.findElement(stateDropdown)).selectByVisibleText("Ohio");
    }

    public  void  inputZip(String zip){
        driver.findElement(zipInputChekout).sendKeys(zip);
    }

    public void inputPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickContinueBtn1() {
        driver.findElement(continueBtn1).click();
    }

    public void clickContinueBtn2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn2));

        driver.findElement(continueBtn2).click();
    }

    public void clickCheckMoneyOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkMoneyOrder));

        driver.findElement(checkMoneyOrder).click();
    }

    public void clickContinueBtn3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn3));

        driver.findElement(continueBtn3).click();
    }

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder));

        driver.findElement(placeOrder).click();
    }

}
