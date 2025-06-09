package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initializes the driver for the current thread based on browser type
    public static WebDriver initDriver(String browser) {

        if (tlDriver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    tlDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    tlDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    tlDriver.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("Browser not supported. Launching Chrome by default.");
                    tlDriver.set(new ChromeDriver());
                    break;
            }
        }

        return getDriver();
    }

    // Returns the driver for current thread
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quits the driver for current thread
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}