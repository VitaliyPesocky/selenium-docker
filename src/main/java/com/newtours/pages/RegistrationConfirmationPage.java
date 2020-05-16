package com.newtours.pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends BasePage {

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;
    @FindBy(partialLinkText = "Flights")
    private WebElement fligthsLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void goToFlightDetailPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.signInLink));
        this.fligthsLink.click();
    }
}
