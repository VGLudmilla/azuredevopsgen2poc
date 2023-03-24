package airnz.gen2devicefarmpoc.framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;

import static airnz.gen2devicefarmpoc.framework.DriverSetup.getDriverInstance;

public class PlatformDetails {
    private static String platformName;

    private static String platformVersion;

    private static String deviceName;

    private static String automationName;

    private static String appPackage;

    private static String appActivity;

    private static String newCommandTimeout;

    public static Properties properties;

    public static String target;

    public static String app = null;

    public static String getPlatformName() {
        return platformName;
    }


    public static void setPlatformName(String platformName) {
        PlatformDetails.platformName = platformName;
    }

    public static String getPlatformVersion() {
        return platformVersion;
    }

    public static void setPlatformVersion(String platformVersion) {
        PlatformDetails.platformVersion = platformVersion;
    }

    public static String getDeviceName() {
        return deviceName;
    }

    public static void setDeviceName(String deviceName) {
        PlatformDetails.deviceName = deviceName;
    }

    public static String getAutomationName() {
        return automationName;
    }

    public void setAutomationName(String automationName) {
        PlatformDetails.automationName = automationName;
    }

    public static String getAppPackage() {
        return appPackage;
    }

    public static void setAppPackage(String appPackage) {
        PlatformDetails.appPackage = appPackage;
    }

    public static String getAppActivity() {
        return appActivity;
    }

    public static void setAppActivity(String appActivity) {
        PlatformDetails.appActivity = appActivity;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        PlatformDetails.properties = properties;
    }

    public static String getTarget() {
        return target;
    }

    public static void setTarget(String target) {
        PlatformDetails.target = target;
    }

    public static String getApp() {
        return app;
    }

    public static void setApp(String app) {
        PlatformDetails.app = app;
    }

    public static String getNewCommandTimeout() {
        return newCommandTimeout;
    }

    public static void setNewCommandTimeout(String newCommandTimeout) {
        PlatformDetails.newCommandTimeout = newCommandTimeout;
    }

    public static Dimension getScreenDimension() {
        return getDriverInstance().manage().window().getSize();
    }

    public DesiredCapabilities setPlatformForAndroid() {
        setPlatformName(System.getenv("platformname"));
        setPlatformVersion(System.getenv("platformversion"));
        setDeviceName(System.getenv("devicename"));
        setAutomationName(System.getenv("automationname"));
        setApp(System.getenv("app"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", getPlatformName());
        capabilities.setCapability("platformVersion", getPlatformVersion());
        capabilities.setCapability("deviceName", getDeviceName());
        capabilities.setCapability("automationName", getAutomationName());
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/Apps/android/" + getApp());
        return capabilities;
    }

    public DesiredCapabilities setPlatformForIOS() {
        PlatformDetails.properties = PropertiesHandler.loadProperties("src/test/resources/ios.properties");
        setPlatformName(setProperty("platformName"));
        setPlatformVersion(setProperty("platformVersion"));
        setDeviceName(setProperty("deviceName"));
        setAutomationName(setProperty("automationName"));
        setApp(setProperty("app"));
        setNewCommandTimeout(setProperty("newCommandTimeout"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", getPlatformName());
//        capabilities.setCapability("platformVersion", getPlatformVersion());
        capabilities.setCapability("deviceName", getDeviceName());
        capabilities.setCapability("automationName", getAutomationName());
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/Apps/ios/" + getApp());
        capabilities.setCapability("newCommandTimeout", Integer.parseInt(getNewCommandTimeout()));
        return capabilities;
    }

    public static String setProperty(String propertyName) {
        return PlatformDetails.properties.getProperty(propertyName);
    }

}
