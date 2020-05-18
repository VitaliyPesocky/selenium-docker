package com.newtours.tests;

import base.BaseTest;
import com.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String numOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numOfPassengers", "expectedPrice"})
    public void setupParameters(String numOfPassengers, String expectedPrice) {
        this.numOfPassengers = numOfPassengers;
        this.expectedPrice = expectedPrice;
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

}
