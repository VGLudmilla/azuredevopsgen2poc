package airnz.gen2devicefarmpoc.framework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInitialize extends DriverSetup {
    private WebDriver driver;
    public String appiumURL = "http://localhost:4723/wd/hub";

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        PlatformDetails.target = System.getenv("target");

        if (PlatformDetails.target.equalsIgnoreCase("android")) {
            capabilities = new PlatformDetails().setPlatformForAndroid();
            try {
                driver = new AndroidDriver(new URL(appiumURL), capabilities);
                setDriverInstance(driver);
            } catch (Exception ex) {
                System.out.println("Malformed URL" + ex.getMessage());
            }
        } else if (PlatformDetails.target.equalsIgnoreCase("ios")) {
            capabilities = new PlatformDetails().setPlatformForIOS();
            try {
                driver = new IOSDriver(new URL(appiumURL), capabilities);
                setDriverInstance(driver);
            } catch (Exception ex) {
                System.out.println("Malformed URL" + ex.getMessage());
            }
        } else {
            driver = new AndroidDriver(new URL(appiumURL), capabilities);
        }
    }
}
