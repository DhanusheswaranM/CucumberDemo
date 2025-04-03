Feature: Login of OrangeHRM WebApplication

Background:
Given User is on the OrangeHRM application

@ValidCredentials
Scenario: Login with valid Credentials


When User enters the valid Credentials
	|Admin  |admin123		|
Then User should be able to login successfully and new page will open


@InValidCredentials
Scenario: to test the invalid Credentials
Then User is able to visible the errorMessage
	|Username		|Password		|ErrorMessage					|
	|Admin1			|admin123$	|Invalid credentials	|
	|Admin2			|admin123@	|Invalid credentials	|
