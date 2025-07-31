package stepdefinition;
import static org.testng.Assert.assertEquals;
import java.util.Map;
import driverfactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LinkedListPage;
import utils.ExcelUtils;


public class LinkedListPageSteps {

	 private LinkedListPage linkedListPage;
	 String actualPage;
	 String actualTitle;
	 private Map<String, String> testData;
	 private Scenario scenario;
	 String expectedResult;
	 String inputData;
	 String actualResult;
	 
      @Before
	    public void beforeScenario(Scenario scenario) {
	        this.scenario = scenario;
	       linkedListPage = new LinkedListPage(DriverFactory.getDriver());
	    }
		
	 @Given("The user is on the Linked List page")
	 public void the_user_is_on_the_linked_list_page() {
		 linkedListPage.getToLinkedList();
	 }
	 
	 
		@When("The user clicks on the Introduction link")
		public void the_user_clicks_on_the_link() throws InterruptedException {
			actualTitle = linkedListPage.getToIntroPage();
		   
		}
		@Then("The user should be redirected to the {string} page")
		public void the_user_should_be_redirected_to_the_page(String expectedTitle) {
			assertEquals(actualTitle, expectedTitle, "Page title does not match");
		   
		   
		}
		@Given("The user is on the Introduction Page")
		public void the_user_is_on_the_introduction_page() {
			linkedListPage.getToIntroPage();
		}
		@When("The user clicks Practice Questions link")
		public void the_user_clicks_practice_questions_link() { 
		actualTitle = linkedListPage.getToPracticePage();
         }   
		
		@Then("The user should be redirected to {string} page")
		public void the_user_should_be_redirected_to_page(String string) {
			   assertEquals( string, actualTitle,"Page title does not match");
		}
		@When("The user clicks Try here button")
		public void the_user_clicks_button() {
			actualTitle=linkedListPage.clicktryHere();
		   
		}
		@Then("The user should be redirected to a {string} page having an try Editor with a Run button to test")
		public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test(String string) {
			assertEquals( string, actualTitle,"Page title does not match");
			Boolean actualResult = linkedListPage.runButtonVisible();
			assertEquals(true,actualResult,"Run Button not visible");
			Boolean actualOutput = linkedListPage.runButtonVisible();
			assertEquals(true,actualOutput,"Editor is not visible");
			
			}
		@Given("The user is in the Assessment page accessed from Introduction page")
		public void the_user_is_in_the_assessment_page_accessed_from_introduction_page() {
			linkedListPage.getToIntroPage();
			linkedListPage.clicktryHere();
		   
		}

		@When("The user writes valid code in the Editor and clicks the Run button")
		public void the_user_writes_valid_code_in_the_editor_and_clicks_the_run_button() {  
			testData = ExcelUtils.readExcelRow(scenario.getName(),"tryEditor");
			System.out.println("TestData: "+testData);
			inputData = testData.get("Input");
			expectedResult = testData.get("output");
			actualResult=linkedListPage.enterData(inputData);

		}

		@Then("The user should see the output in the console")
		public void the_user_should_see_the_output_in_the_console() {
			assertEquals(expectedResult,actualResult,"output is not matching");
		    
		}
		@When("The user writes invalid code in the Editor and clicks the Run button")
		public void the_user_writes_invalid_code_in_the_editor_and_clicks_the_run_button() {
			testData = ExcelUtils.readExcelRow(scenario.getName(),"tryEditor");
			inputData = testData.get("Input");
			expectedResult = testData.get("output");
			actualResult=linkedListPage.enterData(inputData);
		}

		@Then("The user should see an error message in an alert window")
		public void the_user_should_see_an_error_message_in_an_alert_window() {
			assertEquals(expectedResult,actualResult,"output is not matching for invalid code");
		}
		@When("The user clicks the Run button without entering the code in the Editor")
		public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
			testData = ExcelUtils.readExcelRow(scenario.getName(),"tryEditor");
			inputData = testData.get("Input");
			expectedResult = testData.get("output");
			actualResult=linkedListPage.enterData(inputData);
			

		}
		@Then("The user should see the no output in console")
		public void the_user_should_see_the_no_output_in_console() {
			assertEquals(expectedResult,actualResult,"output is not matching");
		}
		
		
		@When("The user clicks on the Creating Linked List link")
		public void the_user_clicks_on_the_creating_linked_list_link() {
			actualTitle = linkedListPage.getToCreatingLinkedListPage();
		}
		
		@Given("The user is on the Creating Linked List Page")
		public void the_user_is_on_the_creating_linked_list_page() {
			linkedListPage.getToCreatingLinkedListPage();
		    
		}
		
		@Given("The user is in the Assessment page accessed from Creating Linked List Page")
		public void the_user_is_in_the_assessment_page_accessed_from_creating_linked_list_page() throws InterruptedException {
			linkedListPage.getToCreatingLinkedListPage();
			linkedListPage.clicktryHere();
			
		}
		
		@When("The user clicks on the Types of Linked List link")
		public void the_user_clicks_on_the_types_of_linked_list_link() {
			actualTitle = linkedListPage.getTotypesofLinkedListPage(); 
		}
		
		@Given("The user is on the Types of Linked List Page")
		public void the_user_is_on_the_types_of_linked_list_page() {
			linkedListPage.getTotypesofLinkedListPage(); 
		}
		
	
		@Given("The user is in the Assessment page accessed from Types of Linked List Page")
		public void the_user_is_in_the_assessment_page_accessed_from_types_of_linked_list_page() {
			linkedListPage.getTotypesofLinkedListPage(); 
			linkedListPage.clicktryHere();
		}
		
		@When("The user clicks on the Implement Linked List in Python link")
		public void the_user_clicks_on_the_implement_linked_list_in_python_link() {
			actualTitle = linkedListPage.getToimplementLinkedListPage();
		}
		
		@Given("The user is on the Implement Linked List in Python Page")
		public void the_user_is_on_the_implement_linked_list_in_python_page() {
			linkedListPage.getToimplementLinkedListPage();
			
		}
		
		@Given("The user is in the Assessment page accessed from Implement Linked List in Python Page")
		public void the_user_is_in_the_assessment_page_accessed_from_implement_linked_list_in_python_page() {
			linkedListPage.getToimplementLinkedListPage();
			linkedListPage.clicktryHere();
		}
		
		

		@When("The user clicks on the Traversal link")
		public void the_user_clicks_on_the_traversal_link() {
			actualTitle = linkedListPage.getTotraversalPage();
		}

		@Given("The user is on the Traversal Page")
		public void the_user_is_on_the_traversal_page() {
			linkedListPage.getTotraversalPage();
		}

		@Given("The user is in the Assessment page accessed from Traversal Page")
		public void the_user_is_in_the_assessment_page_accessed_from_traversal_page() {
			linkedListPage.getTotraversalPage();
			linkedListPage.clicktryHere();
		}

		@When("The user clicks on the Insertion link")
		public void the_user_clicks_on_the_insertion_link() {
			actualTitle = linkedListPage.getToinsertionPage();
		}

		@Given("The user is on the Insertion Page")
		public void the_user_is_on_the_insertion_page() {
			linkedListPage.getToinsertionPage();
		}

		@Given("The user is in the Assessment page accessed from Insertion Page")
		public void the_user_is_in_the_assessment_page_accessed_from_insertion_page() {
			linkedListPage.getToinsertionPage();
			linkedListPage.clicktryHere();
		}

		@When("The user clicks on the Deletion link")
		public void the_user_clicks_on_the_deletion_link() {
			actualTitle = linkedListPage.getTodeletionPage();
		}

		@Given("The user is on the Deletion Page")
		public void the_user_is_on_the_deletion_page() {
			linkedListPage.getTodeletionPage();
		}

		@Given("The user is in the Assessment page accessed from Deletion Page")
		public void the_user_is_in_the_assessment_page_accessed_from_deletion_page() {
			linkedListPage.getTodeletionPage();
			linkedListPage.clicktryHere();
		}






		

}