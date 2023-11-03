package excercise.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MobilePage {
    private WebDriver driver;

    private By mobileMenu = By.linkText("MOBILE");
    private By sortByDropdown = By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]");
    private By productName = By.cssSelector(".product-name");

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    public void selectSortBy(String option) {
        Select dropdown = new Select(driver.findElement(sortByDropdown));
        dropdown.selectByVisibleText(option);
    }

    public List<String> getProductNames() {
        List<WebElement> products = driver.findElements(productName);
        List<String> productNames = new ArrayList<>();
        for (WebElement product : products) {
            productNames.add(product.getText());
        }
        return productNames;
    }
}