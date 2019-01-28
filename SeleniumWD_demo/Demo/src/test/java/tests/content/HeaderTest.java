package tests.content;

import managers.TestsManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HeaderTest extends TestsManager
{
    /**
     * Expected menu items names from the header of the website
     */
    private final String[] itemsNames = new String[]
    {
        "home",
        "over deTesters",
        "referenties",
        "tools",
        "nieuws",
        "dit zijn wij",
        "vacature",
        "contact"
    };

    @Test
    @org.testng.annotations.Test (priority = 1)
    public void checkMenuItems()
    {
        List<WebElement> menuItems = browsers.chrome.findElements(By.className("menu-item"));
        // uncomment for debugging purposes
        //System.out.println("Found " + menuItems.size() + " menu items");
        Assert.assertEquals(menuItems.size(), itemsNames.length);
        for (int i = 0; i < menuItems.size(); i++)
        {
            // uncomment for debugging purposes
            //System.out.println(menuItems.get(i).getText());
            Assert.assertEquals(menuItems.get(i).getText(), itemsNames[i]);
        }
    }

    @Test
    @org.testng.annotations.Test (priority = 2)
    public void checkLogo()
    {
        WebElement logo = browsers.chrome.findElement(By.className("site-logo"));
        Assert.assertFalse(logo.isDisplayed());
    }
}
