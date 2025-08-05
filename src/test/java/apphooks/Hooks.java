package apphooks;
import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import utils.ConfigReader;

public class Hooks {

    @Before(order = 0)
    public void setup() {
    	String browser = System.getProperty("browser", "chrome"); 
        DriverFactory.initDriver(browser);
    }
    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName() + "_FailedScreenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();
    }
}