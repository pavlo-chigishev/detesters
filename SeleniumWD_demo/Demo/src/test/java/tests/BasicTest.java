package tests;

import managers.TestsManager;
import org.junit.Assert;
import org.junit.Test;

public class BasicTest extends TestsManager
{
    private final String expectedTitle = "deTesters";

    /**
     * JUnit sample of test
     */
    @Test
    public void basicTestChrome()
    {
        System.out.println("@Test method of JUnit in progress...");
        String actualTitle = browsers.chrome.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    /**
     * JUnit sample of test
     */
    @Test
    public void basicTestFirefox()
    {
        System.out.println("@Test method of JUnit in progress...");
        browsers.firefox.get(address);
        String actualTitle = browsers.firefox.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    /**
     * TestNG sample of test
     */
    //@org.testng.annotations.Test
    public void testNgTest()
    {
        System.out.println("@Test method of TestNG in progress...");
        String actualTitle = browsers.chrome.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }
}
