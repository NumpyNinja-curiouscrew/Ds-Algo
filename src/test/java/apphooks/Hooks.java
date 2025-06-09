package apphooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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


