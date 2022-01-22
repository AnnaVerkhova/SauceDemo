package saucedemotest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.CheckoutPage;

public class ProductTest extends LoginTest {

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";
    public static final String TEST_PRODUCT2_TITLE = "Sauce Labs Onesie";


    @BeforeMethod
    public void validCredentialsLoginTest() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page is not loaded");
    }


    @Test
    public void purshesProduct() {

        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        cartPage.isPageLoaded();
        cartPage.continueShopping();
        catalogPage.addProductToCart(TEST_PRODUCT2_TITLE);
        cartPage.open();
        cartPage.isPageLoaded();
        cartPage.pushCheckout();
        checkoutPage.usherInField(CheckoutPage.FIRST_NAME_LOCATOR, FIRST_NAME_VALUE);
        checkoutPage.usherInField(CheckoutPage.LAST_NAME_LOCATOR, LAST_NAME_VALUE);
        checkoutPage.usherInField(CheckoutPage.ZIP_LOCATOR, ZIP_VALUE);
        checkoutPage.continueButton();
        checkoutOverviewPage.pushFinish();
        checkoutCompletePage.pushBackHomeButton();
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catolod is not loaded");

    }

}
