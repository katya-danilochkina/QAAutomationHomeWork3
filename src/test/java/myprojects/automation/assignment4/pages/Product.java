package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Product {
    private EventFiringWebDriver driver;
    private By productPrice = By.cssSelector(".product-prices .product-price .current-price");
    private By productCount = By.cssSelector(".product-quantities span");
    private By productName = By.cssSelector("h1[itemprop=name]");

    public Product(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
    }

    public void testProductDetails(ProductData newProduct) {
        waitForPageLoad();
        Assert.assertEquals(newProduct.getName().toUpperCase(), driver.findElement(productName).getText(), "Product Name does not match");
        Assert.assertEquals(newProduct.getPrice(), driver.findElement(productPrice).getText().split(" ")[0], "Product Price does not match");
        Assert.assertEquals(newProduct.getQty().toString(), driver.findElement(productCount).getText().split(" ")[0], "Product Quantity does not match");
    }
}
