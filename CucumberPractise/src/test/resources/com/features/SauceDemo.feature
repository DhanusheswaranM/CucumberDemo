
Feature: SauceDemo Feature
  I want to use this template for my feature file
  Background:
  Given the user in on Login page
  
@ChromeBrowser
@ValidCredentials, @Regression
	Scenario: To test Login features with valid username and password
	
	When the user provides the valid username
	And the user provides the valid password
	And the user clicks the login button
	Then the user is able to visible the ProductText in the same page 
	
	@FireFoxBrowser
@InValidCredentialsWithBlankUsername
	Scenario: To test Login features with invalid username 
	
	When the user provides the blank username
	And the user provides the valid password
	And the user clicks the login button
	Then the user is able to visible the error message
	
	@EdgeBrowser
@InValidCredentialsWithBlankPassword
	Scenario: To test Login features with invalid password 
	
	When the user provides the valid username
	And the user provides the blank password
	And the user clicks the login button
	Then the user is able to visible the error message
	
	@EdgeBrowser
@InValidCredentials, @Regression
	Scenario: To test Login features with invalid username and password
	
	When the user provides the invalid username
	And the user provides the invalid password
	And the user clicks the login button
	Then the user is able to visible the error message