package airnz.gen2devicefarmpoc.framework;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static airnz.gen2devicefarmpoc.framework.DriverSetup.getDriverInstance;
import static airnz.gen2devicefarmpoc.framework.PlatformDetails.getPlatformName;
import static airnz.gen2devicefarmpoc.framework.PlatformDetails.getScreenDimension;

public class ElementFinder {
    protected By locator;

    // Use for soft check. Will not fail test
    // Used before checks, like isExist, isDisplayed etc
    protected int nonFailureFluentWait = 5;

    // Use for hard check. Will fail test if this timeout
    // Used before actions, like click, input etc.
    protected int failureFluentWait = 20;

    public ElementFinder(By locator) {
        this.locator = locator;
    }

    protected WebElement findElement() {
        int attempts = 0;
        int retry = 2;
        WebElement webElement = null;

        while (attempts < retry) {
            try {
                webElement = getDriverInstance().findElement(locator);
            } catch (Exception e) {
                // Catch StaleElementReferenceException | NoSuchElementException and retry it
            }
            attempts++;
        }
        return webElement;
    }

    protected List<WebElement> findElements() {
        int attempts = 0;
        int retry = 2;
        List<WebElement> webElements = null;

        while (attempts < retry) {
            try {
                webElements = getDriverInstance().findElements(locator);
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return webElements;
    }

    public boolean exists() {
        return exists(nonFailureFluentWait);
    }

    public boolean exists(int fluentWaitSeconds) {
        for (int i = 0; i < fluentWaitSeconds; i++) {
            List<WebElement> elements = getDriverInstance().findElements(locator);
            if (elements.size() > 0) {
                return true;
            } else {
                Wait.sleep(1);
            }
        }
        return false;
    }

    public void tap() {
        waitForElementToBeDisplayed(failureFluentWait);
        findElement().click();
    }

    public void sendKey(String key) {
        waitForElementToBeDisplayed(failureFluentWait);
        findElement().sendKeys(key);
    }

    public String getText() {
        waitForElementToBeDisplayed(failureFluentWait);
        return findElement().getText();
    }

    public String getValue() {
        waitForElementToBeDisplayed(failureFluentWait);
        return findElement().getAttribute("value");
    }

    public Boolean isEnabled() {
        if (exists(nonFailureFluentWait)) {
            return findElement().isEnabled();
        } else {
            return false;
        }
    }

    public Boolean isSelected() {
        if (exists(nonFailureFluentWait)) {
            return findElement().isSelected();
        } else {
            return false;
        }
    }

    public Boolean isDisplayed() {
        return isDisplayed(nonFailureFluentWait);
    }

    public Boolean isDisplayed(int seconds) {
        if (exists(seconds)) {
            return (null != findElement()) && findElement().isDisplayed();
        }
        return false;
    }

    public void waitForElementToBeDisplayed(int seconds) {
        if (!isDisplayed(seconds)) {
            System.out.println("Waited for " + seconds + " seconds, cannot find Element " + locator);
        }
    }

    public void scrollDownToElement() {
        for (int i = 0; i <= 30; i++) {
            try {
                waitForElementToBeDisplayed(2);
                break;
            } catch (AssertionError error) {
                if (getPlatformName().equalsIgnoreCase("android")) {
                    ((JavascriptExecutor) getDriverInstance()).executeScript("mobile: scrollGesture",
                            ImmutableMap.of(
                                    "left", getScreenDimension().getWidth() * 0.5,
                                    "top", getScreenDimension().getHeight() * 0.5,
                                    "width", 100,
                                    "direction","down",
                                    "percent",0.10));
//                            ImmutableMap.of(
//                            "left", getScreenDimension().getWidth() * 0.5,
//                            "top", getScreenDimension().getHeight() * 0.5,
//                            "width", 100,
//                            "height", getScreenDimension().getHeight() * 0.4,
//                            "direction", "down",
//                            "percent", 0.10));
                } else {
                    ((JavascriptExecutor) getDriverInstance()).executeScript("mobile: dragFromToForDuration", ImmutableMap.of(
                            "duration", ".5",
                            "fromX", "100",
                            "fromY", "200",
                            "toX", "100",
                            "toY", "100"));
                }
            }
        }
    }


    public int getElementItemAmount() {
        return findElements().size();
    }

}
