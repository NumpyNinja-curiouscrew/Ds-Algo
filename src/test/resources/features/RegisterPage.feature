

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
  @register   
  Scenario: validate the error message displayed when all the fields left empty	
    When the user enters valid testdata and click run button.	
    Then the user should be able to see the error message Please fill out this field displayed below the empty field.
  
  
    
   