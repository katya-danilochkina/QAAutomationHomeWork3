package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCreateProduct {
    private EventFiringWebDriver driver;
    private By nameField = By.id("form_step1_name_1");
    private By quantityField = By.id("form_step1_qty_0_shortcut");
    private By priceField = By.id("form_step1_price_shortcut");
    private By createProductButton = By.cssSelector(".btn.btn-primary.js-btn-save");
    private By activateProduct = By.className("switch-input");
    private By successMessage = By.cssSelector("#growls .growl-notice");
    private By successMessageClose = By.className("growl-close");
    private ProductData newProduct;

    public AdminCreateProduct(EventFiringWebDriver driver, ProductData newProduct) {
        this.driver = driver;
        this.newProduct = newProduct;
    }

    private void waitProductFormLoading() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }

    private void waitForSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }


    public void setName() {
        waitProductFormLoading();
        driver.findElement(nameField).sendKeys(newProduct.getName());
    }

    public void setQuantity() {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(newProduct.getQty().toString());
    }

    public void setPrice() {
        driver.findElement(priceField).clear();
        driver.findElement(priceField).sendKeys(newProduct.getPrice());
    }

    public void switchActivate() {
        driver.findElement(activateProduct).click();
        waitForSuccessMessage();
    }

    public void clickSave() {
        driver.findElement(createProductButton).click();
    }

    public void closeSuccessMessage() {
        waitForSuccessMessage();
        driver.findElement(successMessage).findElement(successMessageClose).click();
    }
}
