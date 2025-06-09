
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: HomePage
 
Scenario: Verify that the user is able to open the DS Algo portal
    Given the user has opened the browser
    When the user enters the correct DS Algo portal URL
    Then the user should land on the DS Algo portal with a "Get Started" button visible

  