package airnz.gen2.devicefarmpoc.autotests.objects.implementations.ios;

import airnz.gen2.devicefarmpoc.autotests.objects.interfaces.Splash;
import airnz.gen2devicefarmpoc.framework.ElementFinder;
import org.openqa.selenium.By;

public class IosSplashScreen implements Splash {
    private ElementFinder skipLink = new ElementFinder(By.id("Skip"));

    @Override
    public void tapSkipButton() {
        skipLink.waitForElementToBeDisplayed(60);
        skipLink.tap();
    }
}
