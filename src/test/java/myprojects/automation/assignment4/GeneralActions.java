package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;
    private By ajaxSpinner = By.id("ajax_running");

    public GeneralActions(EventFiringWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        AdminLogin adminLogin = new AdminLogin(driver);
        adminLogin.open();
        adminLogin.fillEmailInput(login);
        adminLogin.fillPasswordInput(password);
        adminLogin.clickSubmitButton();
    }

    public void createProduct(ProductData newProduct) {
        AdminDashboard adminDashboard = new AdminDashboard(driver);
        adminDashboard.hoverCatalog();
        adminDashboard.goToProductsPage();
        Reporter.log("Go to admin products list page");

        AdminProductsList adminProductsList = new AdminProductsList(driver);
        adminProductsList.clickCreateProductButton();
        Reporter.log("Go to admin product creation page");

        AdminCreateProduct adminCreateProduct = new AdminCreateProduct(driver, newProduct);
        adminCreateProduct.setName();
        adminCreateProduct.setPrice();
        adminCreateProduct.setQuantity();
        adminCreateProduct.switchActivate();
        adminCreateProduct.clickSave();
        adminCreateProduct.closeSuccessMessage();
        Reporter.log("Product is successfully created");
    }

    public void testProductCreationResult(ProductData createdProduct) {
        RootPage rootPage = new RootPage(driver);
        rootPage.open();
        Reporter.log("Shop root page is opened");

        rootPage.goToTheProductsList();
        Reporter.log("Shop products list is opened");

        ProductsList productsList = new ProductsList(driver);
        productsList.searchForCreatedProduct(createdProduct.getName());
        Reporter.log("Product search is completed");

        FoundProducts foundProducts = new FoundProducts(driver);
        foundProducts.isElementFound(createdProduct);
        Reporter.log("Product successfully found");

        foundProducts.goToElementShow(createdProduct);
        Reporter.log("Created product show page is opened");

        Product product = new Product(driver);
        product.testProductDetails(createdProduct);
        Reporter.log("Found product and created product details are identical");

    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ajaxSpinner));
    }
}
