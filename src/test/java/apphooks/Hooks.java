package apphooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driverfactory.DriverFactory;
import utils.ConfigReader;

	

	public class Hooks {

	    @Before
	    public void setup() {
	    	String browser = ConfigReader.get("browser");
	        DriverFactory.initDriver(browser);
	    }

	    @After
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
	}


