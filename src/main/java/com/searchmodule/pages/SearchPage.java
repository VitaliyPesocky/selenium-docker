package com.searchmodule.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchTxt;
    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@data-zci-link='videos']")
    private WebElement videosLink;
    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        this.searchTxt.sendKeys(keyword);
        this.searchButton.click();
    }

    public void goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getCountOfVideos() {
        By videosLocator = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(videosLocator, 0));
        int result = this.allVideos.size();
        System.out.println(result);

        return result;
    }

}
