package tests.content;

import managers.TestsManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class BodyTest extends TestsManager
{
    @Test
    @org.testng.annotations.Test
    public void sectionsAmountTest()
    {
        int expectedAmount = 8;
        List<WebElement> bodySections;
        bodySections = browsers.chrome.findElements(By.xpath("//*[contains(@id, 'pg-6-')]"));
        // uncomment for debugging purposes
        //System.out.println("Found " + bodySections.size() + " body sections");
        Assert.assertEquals(bodySections.size(), expectedAmount);

        // test to check that sections aren't empty
        for(WebElement element : bodySections)
        {
            Assert.assertTrue(element.getAttribute("innerHTML").length() > 0);
        }
    }

    @Test
    @org.testng.annotations.Test
    public void mainTitlesTest()
    {
        String mainTitle = browsers.chrome.findElement(By.className("maintitle")).getAttribute("innerHTML");
        Assert.assertEquals("deTesters", mainTitle);
        String subTitle = browsers.chrome.findElement(By.className("subtitle")).getAttribute("innerHTML");
        Assert.assertEquals("Het enige bedrijf in Nederland dat zich 100% richt op testautomatisering", subTitle);
    }
}
