#Feature files are a feature of Cucumber that are written in a language called Gherkin
#Cucumber is a BDD framework, using gherkin, you can write user stories that can be translated into tests
#These feature files can be useful and supplemental to user story tracking tools
#At the very top of a feature file, you have a description of the user story that you are trying to accomplish

Feature: Mercury Tours Login
	I wish to login to Mercury Tours using proper credentials
	
#	Scenario: Logging into Mercury Tours
#	Given a user is at the homepage of Mercury Tours
#	When a user inputs their username and password and submit
#	Then the user is redirected to find flights page
	
#the keywords And and But can also be used, if there are more than one part to Given, When, or Then

	Scenario Outline: Logging into Mercury Tours
		Given a user is at the homepage of Mercury Tours
		When a user inputs their "<username>"
		And thier "<password>"
		But then submits the information
		Then a user is redirected tot he find flights page
		
		Examples:
		|username|password|
		|bobbert|bobbert|
		|hello|goodbye|
		|dogbert|dogbert|