@Add_New_Customer
Feature: Add_New_Customer

@Add_New_Customer
Scenario Outline: Verify error message when Customer Name, Date of Birth, Address, City, State, PIN, Mobile Number, E-mail, Password is blank
	Given Open Url
	And   I input username "<username>" and password "<password>"
	And   I click login button
	Then  I verify home page is displayed
	When  I click New Customer button at Home Page
	Then  I verify Add New Customer screen is displayed
	Then  I verify error message "Customer name must not be blank" is displayed when "Customer Name" field is blank at Add New Customer
	Then  I verify error message "Date Field must not be blank" is displayed when "Date of Birth" field is blank at Add New Customer
	Then  I verify error message "Address Field must not be blank" is displayed when "Address" field is blank at Add New Customer
	Then  I verify error message "City Field must not be blank" is displayed when "City" field is blank at Add New Customer
	Then  I verify error message "State must not be blank" is displayed when "State" field is blank at Add New Customer
	Then  I verify error message "PIN Code must not be blank" is displayed when "PIN" field is blank at Add New Customer
	Then  I verify error message "Mobile no must not be blank" is displayed when "Mobile Number" field is blank at Add New Customer
	Then  I verify error message "Email-ID must not be blank" is displayed when "E-mail" field is blank at Add New Customer
	Then  I verify error message "Password must not be blank" is displayed when "Password" field is blank at Add New Customer
	When  I click submit button
	Then  I verify content Aleart "please fill all fields" is displayed
	Examples:
|username |password    |		
|mngr26593 |1!         |	