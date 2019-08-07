# CucumberBDDTestNG

This is a solution for the Coding Exercise - QA Analyst with below User Story.
It is written in java and gherkin in Cucumber and TestNG Framework using Selenium Webdriver in Google Chrome browser
```
User Story
As a Xero User,
In order to manage my business successfully,
I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation.
```
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

```
1. Download Eclipse IDE for Java Developers Version: 2018-09 (4.9.0) (used in this environment)
2. Install Java SE 12 JDK (used in this environment)
3. Configure Environment variables for system variable and system path
4. Download Google Chrome webdriver (chromedriver.exe).
```

### Environment Setup

```
1. Checkout the project in the repository with project name "CucumberBDDTestNG" to your machine.
2. Open Eclipse IDE Application from the downloaded folder and define the workspace directory when asked during startup.
3. Proceed to WorkBench to be able to use workspace resources.
4. Right click on the Package Explorer window and click Import to import the whole project that has been checked-out on step 1.
5. After all the files has been loaded, you are now ready to execute the test.
```

## Running the tests

1. Before running the test, configure the directory of your chromedriver.exe.
You can edit it by opening \CucumberBDDTestNG\src\main\java\resources\utility.java
```
	// Chrome driver directory
	public static String chromeDir() {
		String chromeDir = "C:\\Training\\chromedriver.exe";
		return chromeDir;
```

2. On the same java class, configure the location of envconfig.properties file.
You can find it in \CucumberBDDTestNG\src\main\java\resources\envconfig.properties. It may depend on you workspace location. 
Just right click the file and click properties to get the directory and change the value below.

```
	// Environment configuration property directory
	public static String envPropertDir() {
		String envPropertDir = "E:\NewXeroDemo\CucumberBDDTestNG\src\main\java\resources\envconfig.properties";
		return envPropertDir;
	}
```

3. Open the file envconfig.properties. This is one of the important file to configure before running the test.
Configure first the static properties for each user such as

```
Email=user email
Password=user password

example:
Email=john.doe@gmail.com
Password=jdp@ss123
```
You do not need to change the baseURL.
```
baseURL=https://www.xero.com

```

Configure the other properties.
Change this if you have a different Organization
```
DesiredOrganisation=Demo Company (AU)

```

Get this parameter in Google Authentication key and change this parameter every test run (quickly run the test after changing so that the Authentication Key can be used before expiring)
```
AuthKey=383488
```

4. You can now run the test by right clicking the TestNG xml file located in \CucumberBDDTestNG\testng.xml.
Run As a TestNG Suite

5. You can check the logs during execution in the Console view or view the report after execution in:
\CucumberBDDTestNG\target\site\cucumber-pretty\index.html

6. When running the test again, you can either reset the Demo Company (AU) to clear the added Bank Accounts, or edit the feature file found in \CucumberBDDTestNG\src\test\java\features\AddBankAccount.feature with new set of Bank Account Details.
```
    Examples: 
      |accountname		|accountnumber		| 
      |AcountNameOne		|11111111		| 
      |AcountNameTwo		|22222222		|
      |AcountNameThree		|33333333		|
```

## Sample Output
```
[RemoteTestNG] detected TestNG version 6.14.3
@AddBankAccountTesting
Feature: Add a Bank Account
  
  As a Xero User,
  In order to manage my business successfully,
  I want to be able to add an "ANZ (NZ)" bank account inside any Xero Organisation.

  Scenario Outline: Add an ANZ (NZ) bank account in desired Xero Organisation      # AddBankAccount.feature:8
    Given User has a valid Log-in credentials
    And Choose the desired Organisation
    When Adding ANZ NZ bank <accountname> and <accountnumber> details
    Then Bank details for <accountname> successfully added
    And Bank <accountname> and <accountnumber> details shown in Bank Accounts page

    Examples: 
Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 47911
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Aug 07, 2019 10:42:23 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
You have successfully logged in.
You are on the desired organisation: Demo Company (AU)
You currently have 2 Bank Accounts
AcountNameOne has been added.
You now have 3 Bank Accounts
Bank Account details for AcountNameOne was displayed in Bank Accounts page.

  @AddBankAccountTesting
  Scenario Outline: Add an ANZ (NZ) bank account in desired Xero Organisation # AddBankAccount.feature:17
    Given User has a valid Log-in credentials                                 # StepDefinition.user_has_a_valid_Log_in_credentials()
    And Choose the desired Organisation                                       # StepDefinition.choose_the_desired_Organisation()
    When Adding ANZ NZ bank AcountNameOne and 11111111 details                # StepDefinition.adding_anz_nz_bank_and_details(String,String)
    Then Bank details for AcountNameOne successfully added                    # StepDefinition.bank_details_for_successfully_added(String)
    And Bank AcountNameOne and 11111111 details shown in Bank Accounts page   # StepDefinition.bank_and_details_shown_in_bank_accounts_page(String,String)
Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 14261
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Aug 07, 2019 10:43:13 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
You have successfully logged in.
You are on the desired organisation: Demo Company (AU)
You currently have 3 Bank Accounts
AcountNameTwo has been added.
You now have 4 Bank Accounts
Bank Account details for AcountNameTwo was displayed in Bank Accounts page.

  @AddBankAccountTesting
  Scenario Outline: Add an ANZ (NZ) bank account in desired Xero Organisation # AddBankAccount.feature:18
    Given User has a valid Log-in credentials                                 # StepDefinition.user_has_a_valid_Log_in_credentials()
    And Choose the desired Organisation                                       # StepDefinition.choose_the_desired_Organisation()
    When Adding ANZ NZ bank AcountNameTwo and 22222222 details                # StepDefinition.adding_anz_nz_bank_and_details(String,String)
    Then Bank details for AcountNameTwo successfully added                    # StepDefinition.bank_details_for_successfully_added(String)
    And Bank AcountNameTwo and 22222222 details shown in Bank Accounts page   # StepDefinition.bank_and_details_shown_in_bank_accounts_page(String,String)
Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 31545
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Aug 07, 2019 10:43:53 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
You have successfully logged in.
You are on the desired organisation: Demo Company (AU)
You currently have 4 Bank Accounts
AcountNameThree has been added.
You now have 5 Bank Accounts
Bank Account details for AcountNameThree was displayed in Bank Accounts page.

  @AddBankAccountTesting
  Scenario Outline: Add an ANZ (NZ) bank account in desired Xero Organisation # AddBankAccount.feature:19
    Given User has a valid Log-in credentials                                 # StepDefinition.user_has_a_valid_Log_in_credentials()
    And Choose the desired Organisation                                       # StepDefinition.choose_the_desired_Organisation()
    When Adding ANZ NZ bank AcountNameThree and 33333333 details              # StepDefinition.adding_anz_nz_bank_and_details(String,String)
    Then Bank details for AcountNameThree successfully added                  # StepDefinition.bank_details_for_successfully_added(String)
    And Bank AcountNameThree and 33333333 details shown in Bank Accounts page # StepDefinition.bank_and_details_shown_in_bank_accounts_page(String,String)

3 Scenarios (3 passed)
15 Steps (15 passed)
2m13.278s


===============================================
BankAccount
Total tests run: 1, Failures: 0, Skips: 0
===============================================
```

## Authors

* **Jayson Dizon** - *Initial work*

