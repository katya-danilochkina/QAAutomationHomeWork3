package myprojects.automation.assignment4.pages;

import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FoundProducts {
    private EventFiringWebDriver driver;
    private By productElement = By.cssSelector(".product-description .h3.product-title");


    public FoundProducts(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productElement));
    }

    public void isElementFound(ProductData newProduct) {
        Assert.assertTrue(findCreatedElements(newProduct).size() > 0);
    }

    private List<WebElement> findCreatedElements(ProductData newProduct) {
        By createdProduct = By.xpath(String.format("//h1[contains(@class,\"product-title\")]/a[text()=\"%s\"]", newProduct.getName()));
        return driver.findElements(createdProduct);
    }

    public void goToElementShow(ProductData newProduct) {
        waitForPageLoad();
        findCreatedElements(newProduct).get(0).click();
    }
}
