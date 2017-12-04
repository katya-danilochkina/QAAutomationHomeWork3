package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboard {
    private EventFiringWebDriver driver;
    private By catalogMenuOption = By.id("subtab-AdminCatalog");
    private By productsSubmenuOption = By.id("subtab-AdminProducts");
    private By ajaxSpinner = By.id("ajax_running");

    public AdminDashboard(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private void waitForAjax() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ajaxSpinner));
    }

    private void waitForHover() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogMenuOption));
    }

    public void hoverCatalog() {
        waitForAjax();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(catalogMenuOption)).build().perform();
    }

    public void goToProductsPage() {
        waitForHover();
        driver.findElement(productsSubmenuOption).click();
    }
}
