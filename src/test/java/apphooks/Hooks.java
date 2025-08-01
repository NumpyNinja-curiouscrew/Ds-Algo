package apphooks;
import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    public static Scenario scenario; 

    @Before(order = 0)
    public void setup() {
        String browser = ConfigReader.get("browser");
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

