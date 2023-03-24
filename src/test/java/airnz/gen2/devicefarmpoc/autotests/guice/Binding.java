package airnz.gen2.devicefarmpoc.autotests.guice;

import airnz.gen2.devicefarmpoc.autotests.objects.implementations.android.AndroidSplashScreen;
import airnz.gen2.devicefarmpoc.autotests.objects.implementations.ios.IosSplashScreen;
import airnz.gen2.devicefarmpoc.autotests.objects.interfaces.Splash;
import airnz.gen2devicefarmpoc.framework.PlatformDetails;
import com.google.inject.AbstractModule;
import io.cucumber.java.en.And;

public class Binding extends AbstractModule {

    @Override
    public void configure() {
        if (PlatformDetails.getPlatformName().equalsIgnoreCase("ios")) {
            bind(Splash.class).to(IosSplashScreen.class);
        } else {
            bind(Splash.class).to(AndroidSplashScreen.class);
        }
    }
}
