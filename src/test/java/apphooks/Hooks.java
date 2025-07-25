package apphooks;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;





import driverfactory.DriverFactory;
import utils.ConfigReader;


public class Hooks {

    public static Scenario scenario; // Make Scenario accessible

    @Before
    public void setup(Scenario scenario) {
        Hooks.scenario = scenario; // Store it in static variable for global use
        String browser = ConfigReader.get("browser");
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}


