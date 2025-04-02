Feature: Example of Scenario Outline

@InvalidCredentials
Scenario Outline: to test the login functionality

Given the user is on the login page for login
When the user enters the username as "<username>"
And the user enters the password as "<password>"
When the user click the login button 
Then the user should be see an error message in the same page "<errorMessage>"

Examples:

|username				|password			|errorMessage																																|
|standard_users	|ecret_sauce	|Epic sadface: Username and password do not match any user in this service	|
|standard_user	|							|Epic sadface: Password is required																					|
|								|seret_sauce	|Epic sadface: Username is required																					|