package airnz.gen2.devicefarmpoc.autotests.objects.implementations.android;

import airnz.gen2.devicefarmpoc.autotests.objects.interfaces.Splash;
import airnz.gen2devicefarmpoc.framework.ElementFinder;
import org.openqa.selenium.By;

public class AndroidSplashScreen implements Splash {
    private ElementFinder skipLink = new ElementFinder(By.xpath("//*[@text='Skip']"));

    @Override
    public void tapSkipButton() {
        skipLink.waitForElementToBeDisplayed(60);
        skipLink.tap();
    }
}
