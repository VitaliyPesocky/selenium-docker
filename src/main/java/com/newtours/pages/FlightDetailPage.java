package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengersCount;
    @FindBy(name = "findFlights")
    private WebElement continueButton;

    public FlightDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
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
