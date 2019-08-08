$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddBankAccount.feature");
formatter.feature({
  "line": 2,
  "name": "Add a Bank Account",
  "description": "\r\nAs a Xero User,\r\nIn order to manage my business successfully,\r\nI want to be able to add an \"ANZ (NZ)\" bank account inside any Xero Organisation.",
  "id": "add-a-bank-account",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AddBankAccountTesting"
    }
  ]
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Add an ANZ (NZ) bank account in desired Xero Organisation",
  "description": "",
  "id": "add-a-bank-account;add-an-anz-(nz)-bank-account-in-desired-xero-organisation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "User has a valid Log-in credentials",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Choose the desired Organisation",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Adding ANZ NZ bank \u003caccountname\u003e and \u003caccountnumber\u003e details",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Bank details for \u003caccountname\u003e successfully added",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Bank \u003caccountname\u003e and \u003caccountnumber\u003e details shown in Bank Accounts page",
  "keyword": "And "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "add-a-bank-account;add-an-anz-(nz)-bank-account-in-desired-xero-organisation;",
  "rows": [
    {
      "cells": [
        "accountname",
        "accountnumber"
      ],
      "line": 16,
      "id": "add-a-bank-account;add-an-anz-(nz)-bank-account-in-desired-xero-organisation;;1"
    },
    {
      "cells": [
        "AcountNameOne",
        "11111111"
      ],
      "line": 17,
      "id": "add-a-bank-account;add-an-anz-(nz)-bank-account-in-desired-xero-organisation;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 17,
  "name": "Add an ANZ (NZ) bank account in desired Xero Organisation",
  "description": "",
  "id": "add-a-bank-account;add-an-anz-(nz)-bank-account-in-desired-xero-organisation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@AddBankAccountTesting"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User has a valid Log-in credentials",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Choose the desired Organisation",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Adding ANZ NZ bank AcountNameOne and 11111111 details",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Bank details for AcountNameOne successfully added",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Bank AcountNameOne and 11111111 details shown in Bank Accounts page",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_has_a_valid_Log_in_credentials()"
});
formatter.result({
  "duration": 32143815114,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.choose_the_desired_Organisation()"
});
formatter.result({
  "duration": 1609015233,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AcountNameOne",
      "offset": 19
    },
    {
      "val": "11111111",
      "offset": 37
    }
  ],
  "location": "StepDefinition.adding_anz_nz_bank_and_details(String,String)"
});
formatter.result({
  "duration": 9407894231,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});