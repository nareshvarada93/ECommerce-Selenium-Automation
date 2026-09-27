package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPage productsPage =
                new ProductsPage(driver);

        productsPage.addBackpack();
        productsPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        String product =
                cartPage.getProductName();

        Assert.assertEquals(
                product,
                "Sauce Labs Backpack"
        );
    }
}