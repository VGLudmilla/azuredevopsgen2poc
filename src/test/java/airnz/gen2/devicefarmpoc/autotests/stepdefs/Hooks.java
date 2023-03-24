package airnz.gen2.devicefarmpoc.autotests.stepdefs;

import airnz.gen2devicefarmpoc.framework.DriverInitialize;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.net.MalformedURLException;


public class Hooks extends DriverInitialize {

    private static Scenario scenario;

    @Before
    public void before(Scenario scenario) throws MalformedURLException {
        Hooks.scenario = scenario;
        setUp();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (getDriverInstance() != null) {
            getDriverInstance().quit();
        }
    }
}
