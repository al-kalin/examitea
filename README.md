Exem Selenium Java project in ITEA

This is a sample Selenium Java project Use best practices of OOP and PageObject/PageFactory patterns

Scenario
- Open browser Chrome or Firefox
- Navigate to google.com in web browser
- Enter "Selenium" into search field
- Click on "Search" button
- Assert number of Search results is 10 on page 1
- Assert that each result in a list contains searchterm
- Click on "2" link to switch to next page
- Assert number of Search results is 10 on page 2
- Assert that each result in a list contains searchterm

How to run tests from this project:
1. Install JDK 1.8 or above corresponding to your OS
2. Install Maven command line utility corresponding to your OS
3. Make sure that following command line commands mvn -version and java -version give you information
on mvn and java installed in your OS. Otherwise go back to #1 and #2 and google for proper installation
guides.
4. Clone repository with source code via Git
5. In command line to cd to project root folder
6. To run test from command line use following command:
mvn clean install -DsuiteName=google_search_chrome.xml
or -DsuiteName=google_search_firefox.xml
