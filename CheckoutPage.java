package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstName =
            By.id("first-name");

    private By lastName =
            By.id("last-name");

    private By postalCode =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    private By finishButton =
            By.id("finish");

    private By confirmation =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterDetails(
            String firstName,
            String lastName,
            String postalCode) {

        driver.findElement(this.firstName)
                .sendKeys(firstName);

        driver.findElement(this.lastName)
                .sendKeys(lastName);

        driver.findElement(this.postalCode)
                .sendKeys(postalCode);
    }

    public void clickContinue() {

        driver.findElement(continueButton)
                .click();
    }

    public void clickFinish() {

        driver.findElement(finishButton)
                .click();
    }

    public String getConfirmation() {

        return driver.findElement(confirmation)
                     .getText();
    }
}