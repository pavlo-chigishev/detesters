package managers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.ITestResult;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestsManager
{
    protected static BrowserManager browsers;
    protected static final String address = "https://detesters.nl";

    /**
     * JUnit && TestNG before class data method
     */
    @BeforeClass
    @org.testng.annotations.BeforeSuite
    public static void start()
    {
        System.out.println("Starting jUnit/TestNG test suite...\n");
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
        browsers = new BrowserManager();
        // provide here browsers in which tests should be carried out
        browsers.start(BrowserManager.Browsers.CH);
        browsers.chrome.get(address);
    }

    /**
     * JUnit && TestNG after class data method
     */
    @AfterClass
    @org.testng.annotations.AfterSuite
    public static void stop()
    {
        browsers.stop();
    }

    @org.testng.annotations.BeforeClass
    protected void announceTest()
    {
        System.out.println("Starting tests in [" + this.getClass().getName() + "]");
    }

    /**
     * Method that prints the test result to the log
     * @param result
     */
    @org.testng.annotations.AfterMethod
    protected void printTestResult(ITestResult result)
    {
        String s = this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1) + " [" + result.getName() + "]";
        switch(result.getStatus())
        {
            case(1): { s +=  " test DONE."; break; }
            case(2): { s += " test FAILED."; break; }
            case(3): { s += " test SKIPED."; break; }
            case(16): { s += " test STARTED."; break; }
            case(4): default: { s +=" test WENT WRONG"; break; }
        }
        System.out.println(s);
    }

    /**
     * Method of finishing testing procedure
     */
    @org.testng.annotations.AfterClass
    protected void tearDown()
    {
        System.out.println(this.getClass().getName() + " tests completed!.\nSwitching to the next test suite if applicable...\n");
    }
}
