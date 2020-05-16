package com.newtours.pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindFligthPage extends BasePage {

    @FindBy(name = "reserveFlights")
    private WebElement continueButton;
    @FindBy(name = "buyFlights")
    private WebElement securePurchaseButton;

    public FindFligthPage(WebDriver driver) {
        super(driver);
    }

    public void submitFindFlightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));
        this.continueButton.click();
    }

    public void goToFlightConfirmationPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.securePurchaseButton));
        this.securePurchaseButton.click();
    }
}
