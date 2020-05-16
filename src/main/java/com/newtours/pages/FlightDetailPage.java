package com.newtours.pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightDetailPage extends BasePage {

    @FindBy(name = "passCount")
    private WebElement passengersCount;
    @FindBy(name = "findFlights")
    private WebElement continueButton;

    public FlightDetailPage(WebDriver driver) {
        super(driver);
    }

    public void selectPassengers(String numOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengersCount));
        Select passCountSelect = new Select(this.passengersCount);
        passCountSelect.selectByValue(numOfPassengers);
    }

    public void goToFindFligthsPage() {
        this.continueButton.click();
    }
}
