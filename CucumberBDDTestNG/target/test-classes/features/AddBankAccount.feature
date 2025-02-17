@AddBankAccountTesting
Feature: Add a Bank Account 

As a Xero User,
In order to manage my business successfully,
I want to be able to add an "ANZ (NZ)" bank account inside any Xero Organisation.

  Scenario Outline: Add an ANZ (NZ) bank account in desired Xero Organisation
    Given User has a valid Log-in credentials
      And Choose the desired Organisation
     When Adding ANZ NZ bank <accountname> and <accountnumber> details
     Then Bank details for <accountname> successfully added
      And Bank <accountname> and <accountnumber> details shown in Bank Accounts page
  
    Examples: 
      |accountname			|accountnumber	| 
      |AcountNameOne		|11111111		| 
      |AcountNameTwo		|22222222		|
      |AcountNameThree		|33333333		|