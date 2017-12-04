package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RootPage {
    private final String applicationRootUrl = "http://prestashop-automation.qatestlab.com.ua/ru/";
    private EventFiringWebDriver driver;
    private By listOfAllProductsButton = By.className("all-product-link");

    public RootPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(applicationRootUrl);
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfAllProductsButton));
    }

    public void goToTheProductsList() {
        waitForPageLoad();
        driver.findElement(listOfAllProductsButton).click();
    }
}
