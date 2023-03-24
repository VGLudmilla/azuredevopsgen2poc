package airnz.gen2.devicefarmpoc.autotests.objects.screens;

import airnz.gen2.devicefarmpoc.autotests.objects.interfaces.Splash;
import com.google.inject.Inject;

public class SplashScreen {
    Splash splash;

    @Inject
    public SplashScreen(Splash splash) {
        this.splash = splash;
    }

    public void tapSkipButton() {
        splash.tapSkipButton();
    }
}
