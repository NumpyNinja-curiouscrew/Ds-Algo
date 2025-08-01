
@register
Feature: User Registration Validation


  Background:
    Given the user is on the user registration page
    
  Scenario: validate the error message displayed when the username field is left empty	
    When the user enters valid testdata and click run button.	
    Then the user should be able to see the error message Please fill out this field displayed below the empty field.

  Scenario: validate the error message displayed when the password field is left empty	
    When the user enters valid testdata and click run button. 
    Then the user should be able to see the error message Please fill out this field displayed below the empty field.
    
  Scenario: validate the error message displayed when the confirm password field is left empty
     When the user enters valid testdata and click run button.
     Then the user should be able to see the error message Please fill out this field displayed below the empty field.
  
  Scenario: validate the error message displayed when all the fields left empty	
    When the user enters valid testdata and click run button.	
    Then the user should be able to see the error message Please fill out this field displayed below the empty field.
 
  
  Scenario Outline: validate the registration page with multiple test data 
    When the user enters testdata for each "<scenario>"
    Then user should able to see this expected output
    
    Examples:
      | scenario                       |
      | TC_01-For invalid username     |
      | TC_02-For invalid username     |
      | TC_03-For invalid username     |
      | TC_04-For invalid username     |
      | TC_05-For invalid password     |
      | TC_06-For invalid password     |
      | TC_07-For invalid password     |
      | TC_08-For password and confirm password mismatch    |
      | TC_09-For already existing credentials              |

      
      
    
    
  
  
    
   