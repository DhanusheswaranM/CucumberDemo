
Feature: SauceDemo Feature
  I want to use this template for my feature file

@ValidCredentials
	Scenario: To test Login features with valid username and password
	Given the user in on Login page
	When the user provides the valid username
	And the user provides the valid password
	And the user clicks the login button
	Then the user is able to visible the ProductText in the same page 
	
@InValidCredentialsWithBlankUsername
	Scenario: To test Login features with invalid username 
	Given the user in on Login page
	When the user provides the blank username
	And the user provides the valid password
	And the user clicks the login button
	Then the user is able to visible the error message
	
@InValidCredentialsWithBlankPassword
	Scenario: To test Login features with invalid password 
	Given the user in on Login page
	When the user provides the valid username
	And the user provides the blank password
	And the user clicks the login button
	Then the user is able to visible the error message
	
@InValidCredentials
	Scenario: To test Login features with invalid username and password
	Given the user in on Login page
	When the user provides the invalid username
	And the user provides the invalid password
	And the user clicks the login button
	Then the user is able to visible the error message