package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.testng.annotations.Test;

import static org.testng.Reporter.log;

public class CreateProductTest extends BaseTest {

    @Test(dataProvider="AdminCredential")
    public void createNewProduct(String login, String password) {
        ProductData newProduct = ProductData.generate();
        actions.login(login, password);
        log("Admin is logged in successfully");
        actions.createProduct(newProduct);
        log("Product was successfully created");
        actions.testProductCreationResult(newProduct);
        log("Product details display matching with created product");
    }
}
