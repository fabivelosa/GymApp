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
@tag
Feature: Login Page
  As a member I want to login to teh application
  So that I can access teh member homepage.

  @successlogin
  Scenario: User can login succesfully
    Given the user is on the login page 
    And is already registered
    When the user enters a valid "<username>"
    And a valid "<password>"
    And clicks the logion button
    Then the member homepage is loaded
 		And a Welcome Message with his name is shown

  @Failedloginusername
  Scenario: User cannot login succesfully - incorrect username
    Given the user is on the login page 
    And is already registered
    When the user enters an invalid username
    And a valid password
    And clicks the logion button
   Then the index homepage is loaded

 @Failedloginpassword
  Scenario: User cannot login succesfully - incorrect password
    Given the user is on the login page 
    And is already registered
    When the user enters a valid username 
    And an invalid password
    And clicks the logion button
    Then the index homepage is loaded

 		
    Examples: 
      | username | password| 
      | fabiane  |      123| 
      | migle    |      345| 
