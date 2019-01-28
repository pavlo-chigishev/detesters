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
import java.util.List;

public class ReferentiesSection extends TestsManager
{
    @Test
    @org.testng.annotations.Test (priority = 1)
    public void thumbnailsTest()
    {
        WebElement referenties = browsers.chrome.findElement(By.id("pg-6-1"));
        WebElement header = referenties.findElement(By.tagName("h3"));
        Assert.assertTrue(header.getAttribute("innerHTML").length() > 0);
        Assert.assertEquals("REFERENTIES", header.getText());

        List<WebElement> clients = referenties.findElements(By.xpath("//*[contains(@id, 'panel-w5c0edc9d1780f-0-')]"));
        Assert.assertEquals(10, clients.size());
    }

    @Test
    @org.testng.annotations.Test (priority = 2)
    public void imageURLsTest() throws IOException
    {
        WebElement referenties = browsers.chrome.findElement(By.id("pg-6-1"));
        List<WebElement> imgUrls = referenties.findElements(By.xpath("//div[contains(@class, 'panel-widget-style-for-w5c0edc9d1780f-0-')]"));
        for(int i = 0; i < imgUrls.size(); i++)
        {
            String imgUrl = imgUrls.get(i).getCssValue("background-image");
            imgUrl = imgUrl.substring(imgUrl.indexOf("(\"")+2,imgUrl.indexOf("\")"));
            Assert.assertEquals(imgURLs[i], imgUrl);
            URL url = null;
            try {
                url = new URL(imgUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            Assert.assertEquals(200, code);
            // uncomment for debugging purposes
            //System.out.println("Requesting " + imgUrl + " | response code: " + code);
        }
    }

    @Test
    @org.testng.annotations.Test (priority = 2)
    public void popUpsTest() throws Exception
    {
        WebElement references = browsers.chrome.findElement(By.id("pg-6-1"));
        if(references != null) {
            List<WebElement> popUps = references.findElements(By.xpath("//div[contains(@class, 'cl-popup-wrap')]"));
            for(WebElement el : popUps)
            {
                Assert.assertEquals("none", el.getCssValue("display"));
            }
        } else throw new Exception("[referenties] element has not been found!");
    }

    @Test
    @org.testng.annotations.Test (priority = 3)
    public void popUp1Test() throws Exception
    {
        WebElement references = browsers.chrome.findElement(By.id("pg-6-1"));
        if(references != null) {
            List<WebElement> clients = references.findElements(By.xpath("//div[contains(@id, 'panel-w5c0edc9d1780f-0-')]"));
            clients.get(0).findElement(By.tagName("a")).click();
            List<WebElement> popUps = references.findElements(By.xpath("//div[contains(@class, 'cl-popup-wrap')]"));
            for(int i = 0; i < popUps.size(); i++)
            {
                Assert.assertEquals((i==popUps.size()-1)?"block":"none", popUps.get(i).getCssValue("display"));
            }

//            List<WebElement> popupClosers = browsers.chrome.findElements(By.className("cl-popup-closer"));
//            for(WebElement el : popupClosers) if(el.isDisplayed()) el.click();
//
//            popUps = references.findElements(By.xpath("//div[contains(@class, 'cl-popup-wrap')]"));
//            for(int i = 0; i < popUps.size(); i++)
//            {
//                System.out.println("Checking pop-up: " + popUps.get(i).
//                        );
//                Assert.assertEquals("none", popUps.get(i).getCssValue("display"));
//            }
        } else throw new Exception("[referenties] element has not been found!");
    }

    private final String[] imgURLs = new String[] {
            "https://detesters.nl/wp-content/uploads/2016/11/kvk-2.svg",
            "https://detesters.nl/wp-content/uploads/2016/12/ns-logo.png",
            "https://detesters.nl/wp-content/uploads/2016/11/Sanoma_logo_2013.png",
            "https://detesters.nl/wp-content/uploads/2016/11/holland-casino-2.svg",
            "https://detesters.nl/wp-content/uploads/2016/12/logo-rabobank.png",
            "https://detesters.nl/wp-content/uploads/2016/11/topicus-logo.jpg",
            "https://detesters.nl/wp-content/uploads/2018/10/rigd-loxia.png",
            "https://detesters.nl/wp-content/uploads/2016/11/bol-com-1.svg",
            "https://detesters.nl/wp-content/uploads/2016/11/dnb-logo.png",
            "https://detesters.nl/wp-content/uploads/2016/12/logo-klaverblad.png"
    };
}
