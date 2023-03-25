package airnz.gen2.devicefarmpoc.autotests.stepdefs;

import airnz.gen2.devicefarmpoc.autotests.guice.Binding;
import airnz.gen2.devicefarmpoc.autotests.objects.screens.SplashScreen;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.cucumber.java.en.Given;

public class WelcomeScreenStepDefs {
    Injector injector = Guice.createInjector(new Binding());
    SplashScreen splashScreen = injector.getInstance(SplashScreen.class);

    @Given("I tap skip on the Splash screen")
    public void iTapSkipOnTheSplashScreen() {
            splashScreen.tapSkipButton();
            System.out.println("Verify the commit");
    }
}
