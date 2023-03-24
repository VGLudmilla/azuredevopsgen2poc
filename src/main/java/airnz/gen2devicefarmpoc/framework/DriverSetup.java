package airnz.gen2devicefarmpoc.framework;

import org.openqa.selenium.WebDriver;

public class DriverSetup {
    public static WebDriver driverInstance;

    public static WebDriver getDriverInstance() {
        return DriverSetup.driverInstance;
    }

    public static void setDriverInstance(WebDriver driverInstance) {
        DriverSetup.driverInstance = driverInstance;
    }
}
