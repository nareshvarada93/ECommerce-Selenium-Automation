package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void completePurchaseTest() {

        // Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        // Product
        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.addBackpack();
        productsPage.openCart();

        // Cart
        CartPage cartPage =
                new CartPage(driver);

        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack"
        );

        cartPage.clickCheckout();

        // Checkout
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterDetails(
                "Naresh",
                "Varada",
                "530002"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        // Verify order
        Assert.assertEquals(
                checkoutPage.getConfirmation(),
                "Thank you for your order!"
        );
    }
}