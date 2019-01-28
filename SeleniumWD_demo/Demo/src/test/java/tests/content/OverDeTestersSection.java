package tests.content;

import managers.TestsManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverDeTestersSection extends TestsManager
{
    @Test
    @org.testng.annotations.Test (priority = 1)
    public void headersTest()
    {
        List<WebElement> headers = browsers.chrome.findElement(By.id("pg-6-0")).findElements(By.tagName("h3"));
        assertHeaders(headers);
    }

    @Test
    @org.testng.annotations.Test (priority = 2)
    public void paragraphsTest()
    {
        List<WebElement> paragraphs = browsers.chrome.findElement(By.id("pg-6-0")).findElements(By.tagName("p"));
        assertParagraphs(paragraphs);
    }

    private void assertHeaders(List<WebElement> headers)
    {
        Assert.assertEquals(headers.size(), 6);
        for(int i = 0; i < headers.size(); i++)
        {
            switch (i)
            {
                case 0:
                default:
                    Assert.assertTrue(headers.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals("OVER DETESTERS", headers.get(i).getText());
                    break;
                case 1:
                    Assert.assertTrue(headers.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals("Focus", headers.get(i).getText());
                    break;
                case 2:
                    Assert.assertTrue(headers.get(i).getAttribute("innerHTML").length() == 0);
                    break;
                case 3:
                    Assert.assertTrue(headers.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals("Kwaliteit", headers.get(i).getText());
                    break;
                case 4:
                    Assert.assertTrue(headers.get(i).getAttribute("innerHTML").length() == 0);
                    break;
                case 5:
                    Assert.assertTrue(headers.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals("Plezier", headers.get(i).getText());
                    break;
            }
        }
    }

    private void assertParagraphs(List<WebElement> paragraphs)
    {
        String p1 = "Wij zijn 15 top professionals die doelgericht kwaliteit leveren. Mensen die van het vak houden en er een uitdaging in zien om de opdrachtgever echt verder te helpen.";
        String p2 = "Focus op maar één ding: de technische kant van het testvak, waardoor je echt een specialist kunt zijn. Bij ons geen testmanagers, geen functioneel testers maar alleen professionals die van techniek houden.";
        String p3 = "Kwaliteit door alleen vakmensen aan te nemen die echt snappen wat testautomatisering betekent en die weten dat ze in een agile team software moeten ontwikkelen waar de klant echt behoefte aan heeft.";
        String p4 = "Plezier door met elkaar de passie voor de technische kant van het testvak te delen, zeer uitdagende en innoverende opdrachten uit te voeren, te blijven leren en uiteraard veel leuke sociale activiteiten met elkaar te ondernemen.";

        Assert.assertEquals(paragraphs.size(), 4);
        for(int i = 0; i < paragraphs.size(); i++)
        {
            switch (i)
            {
                case 0:
                default:
                    Assert.assertTrue(paragraphs.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals(p1, paragraphs.get(i).getText());
                    break;
                case 1:
                    Assert.assertTrue(paragraphs.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals(p2, paragraphs.get(i).getText());
                    break;
                case 2:
                    Assert.assertTrue(paragraphs.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals(p3, paragraphs.get(i).getText());
                    break;
                case 3:
                    Assert.assertTrue(paragraphs.get(i).getAttribute("innerHTML").length() > 0);
                    Assert.assertEquals(p4, paragraphs.get(i).getText());
                    break;
            }
        }
    }
}
