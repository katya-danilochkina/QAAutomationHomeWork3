package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminProductsList {
    private EventFiringWebDriver driver;
    private By createProductButton = By.id("page-header-desc-configuration-add");

    public AdminProductsList(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private void waitForProductButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createProductButton));
    }

    public void clickCreateProductButton() {
        driver.findElement(createProductButton).click();
    }


}
