#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
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
@linkedlist
Feature: Linked List Page Validation

  Background:
    Given The user is logged in to the dsAlgo portal
    And The user is on the "Linked List" page
    
  Scenario: Verify that user is able to navigate to the Introduction Page
    When The user clicks on the Introduction link
    Then The user should be redirected to the "Introduction" page

  Scenario: Verify that user is able to navigate to Practice Questions Page
    Given The user is on the Introduction Page
    When The user clicks Practice Questions link
    Then The user should be redirected to "Practice Questions" page

  Scenario: Verify that user is able to navigate to Assessment page
    Given The user is on the Introduction Page
    When The user clicks Try here button
    Then The user should be redirected to a "Assessment" page having an try Editor with a Run button to test

  Scenario: Verify that user receives error when click on Run button without entering code
    Given The user is in the "Assessment" page accessed from Introduction page
    When The user clicks the "Run" button without entering the code in the Editor
    Then The user should see the same try Editor with a Run button

  Scenario: Verify that user receives error for invalid python code
    Given The user is in the "Assessment" page accessed from Introduction page
    When The user writes invalid code in the Editor and clicks the "Run" button
    Then The user should see an error message in an alert window

  Scenario: Verify that user is able to see output for valid python code
    Given The user is in the "Assessment" page accessed from Introduction page
    When The user writes valid code in the Editor and clicks the "Run" b`utton
    Then The user should see the output in the console

 