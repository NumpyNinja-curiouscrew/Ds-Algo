package stepdefinition;
import static apphooks.Hooks.scenario;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverfactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utils.ExcelUtils;


public class RegisterPageSteps {

	private RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private static final Logger logger = LoggerFactory.getLogger(RegisterPageSteps.class);
    private Map<String, String> testData;
    String actualResult;
	
    
	

@Given("the user is on the user registration page")
public void the_user_is_on_the_user_registration_page() {
	homePage.getHomePage();
	homePage.clickRegisterLink();
}
@When("the user clicks the Register button after entering field from excel.")
public void the_user_clicks_the_Register_button_after_entering_field_from_excel() throws InterruptedException {
	
	String sheetName = ExcelUtils.readSheetName("Sheet1");
	testData = ExcelUtils.readExcelRow(scenario.getName(), sheetName);
	String username = testData.get("username");
	registerPage.enterUsername(username);
	String password = testData.get("password");
	registerPage.enterPassword(password);
	String confirmPassword = testData.get("confirmPassword");
	registerPage.enterConfirmPassword(confirmPassword);
	String fieldname= testData.get("fieldName");
	String fieldId= registerPage.getFieldId(fieldname);
	System.out.println(fieldId);
	registerPage.clickRegister();
	JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getDriver();
    actualResult = (String) js.executeScript(
        "return document.getElementById(arguments[0]).validationMessage;",fieldId
    );
    
}

@Then("the error message should be displayed under the empty field.")
public void the_error_message_should_be_displayed_under_the_empty_field() {
	String expectedResult = testData.get("expectedError");
	assertEquals(expectedResult,actualResult);
}

}
    
     
