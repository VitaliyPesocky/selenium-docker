package com.newtours.tests;

import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest {

    private WebDriver driver;
    private String numOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numOfPassengers", "expectedPrice"})
    public void setupDriver(String numOfPassengers, String expectedPrice) {
        this.numOfPassengers = numOfPassengers;
        this.expectedPrice = expectedPrice;
        System.setProperty("webdriver.chrome.driver", "/Users/vitaliy/Downloads/chromedriver81/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(this.driver);

        registrationPage.goTo();
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPageTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(this.driver);
        registrationConfirmationPage.goToFlightDetailPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPageTest")
    public void flightDetailsPageTest() {
        FlightDetailPage flightDetailPage = new FlightDetailPage(this.driver);
        flightDetailPage.selectPassengers(this.numOfPassengers);
        flightDetailPage.goToFindFligthsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPageTest")
    public void findFlightPageTest() {
        FindFligthPage findFligthPage = new FindFligthPage(this.driver);
        findFligthPage.submitFindFlightPage();
        findFligthPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPageTest")
    public void flightConfirmationTest() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(this.driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @AfterClass
    public void closeDriver() {
        this.driver.quit();
    }
}
