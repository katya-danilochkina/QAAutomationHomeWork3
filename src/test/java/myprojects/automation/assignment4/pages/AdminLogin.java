package myprojects.automation.assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLogin {
    private EventFiringWebDriver driver;
    private final String adminLoginFormAddress = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea";
    private By adminEmailField = By.id("email");
    private By adminPasswordField = By.id("passwd");
    private By submitAdminFormButton = By.name("submitLogin");

    public AdminLogin(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(adminLoginFormAddress);
    }

    private void waitForFormLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminEmailField));
    }

    public void fillEmailInput(String email) {
        waitForFormLoading();
        driver.findElement(adminEmailField).sendKeys(email);
    }

    public void fillPasswordInput(String password) {
        driver.findElement(adminPasswordField).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitAdminFormButton).click();
    }
}
