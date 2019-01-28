package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserManager
{
    public WebDriver chrome;
    public WebDriver firefox;
    // TODO: add Opera, IE & Safari browsers
    private WebDriverWait chromeWait;
    private WebDriverWait firefoxWait;
    public enum Browsers { FF, CH, IE, OP, SA }

    /**
     * This method gets called before test classes get executed
     * @param browsers
     */
    public void start(Browsers... browsers)
    {
        int TIMEOUT = 10;
        for(Browsers browser : browsers) {
            switch (browser) {
                case CH:
                    chrome = getChromeDriver();
                    chrome.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
                    chromeWait = new WebDriverWait(chrome, TIMEOUT);
                    break;
                case FF:
                default:
                    firefox = getFirefoxDriver();
                    firefox.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
                    firefoxWait = new WebDriverWait(firefox, TIMEOUT);
                    break;
            }
        }
    }

    /**
     * This method gets called after completion of a test class
     */
    public void stop()
    {
        if(chrome != null) {
            chrome.quit();
            chrome = null;
        }

        if(firefox != null) {
            firefox.quit();
            firefox = null;
        }

        // TODO: add here drivers for other browsers if needed (IE, Opera, Safari)
    }

    private ChromeDriver getChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver();
    }

    private FirefoxDriver getFirefoxDriver()
    {
        System.setProperty("webdriver.gecko.driver","/usr/local/Cellar/geckodriver/0.23.0/bin/geckodriver");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        return new FirefoxDriver();
    }
}
