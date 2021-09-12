@Register-login
Feature: Register account bank Guru

@Register-login-01
Scenario: User can register bank guru account successful
	Given Open Url
	Then  I verify login page is displayed
	When  I click here link at login page
	Then  I verify register page is displayed
	When  I input email "abc@gmail.com" at register page
	And   I click submit button at register page
	Then  I verify username and password is displayed
	
@Register-login-02
Scenario Outline: User can login and logout bank guru account successful
	Given Open Url
	And   I input username "<username>" and password "<password>"
	And   I click login button
	Then  I verify home page is displayed
	When  I click logout button
	And   I click ok at Aleart
	Then  I verify login page is displayed
	
	Examples:                      		

|username |password       |		

|mngr26593 |1!         |		

|mngr353051|zarYbav    |		

|mngr344894|YgEpEzY    |		

