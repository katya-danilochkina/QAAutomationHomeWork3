package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsList {
    private EventFiringWebDriver driver;
    private By searchProductField = By.className("ui-autocomplete-input");
    private By startSearchButton = By.cssSelector("#search_widget button[type=submit]");


    public ProductsList(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchProductField));
    }

    public void searchForCreatedProduct(String productName) {
        waitForPageLoad();
        driver.findElement(searchProductField).sendKeys(productName);
        driver.findElement(startSearchButton).click();
    }
}
