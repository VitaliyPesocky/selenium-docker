package com.searchmodule.tests;

import base.BaseTest;
import com.searchmodule.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword) {
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int actualResult = searchPage.getCountOfVideos();

        Assert.assertTrue(actualResult > 0);
    }

}
