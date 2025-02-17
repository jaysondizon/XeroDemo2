package cucumber.StepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import resources.utility;
import cucumber.api.java.en.Then;

public class StepDefinition {

	// Creating reference variable of Webdriver
	public static WebDriver driver;

	// Creating reference variable of Properties
	Properties value = new Properties();

	@Given("^User has a valid Log-in credentials$")
	public void user_has_a_valid_Log_in_credentials() throws Throwable {

		// Setting up environment properties
		FileInputStream inputFile = new FileInputStream(utility.envPropertDir());
		value.load(inputFile);

		// Setting up the properties for Chrome Driver
		System.setProperty("webdriver.chrome.driver", utility.chromeDir());

		// Inserting Chromedriver to Webdriver reference object
		driver = new ChromeDriver();

		// Maximizing the browser window
		driver.manage().window().maximize();

		// Providing wait to load all the elements on page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Passing the URL
		driver.get(value.getProperty("baseURL"));

		// Navigate to Log-in page
		driver.findElement(By.partialLinkText("Login")).click();

		// Passing valid credentials
		driver.findElement(By.id("email")).sendKeys(value.getProperty("Email"));
		driver.findElement(By.id("password")).sendKeys(value.getProperty("Password"));
		driver.findElement(By.id("submitButton")).click();

		// Complete authentication
		driver.findElement(By.xpath("//input[@placeholder='Authentication code']"))
				.sendKeys(value.getProperty("AuthKey"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// User successfully logged in
		driver.findElement(By.cssSelector(".xui-pageheading--title")).isDisplayed();
		System.out.println("You have successfully logged in.");
	}

	@Given("^Choose the desired Organisation$")
	public void choose_the_desired_Organisation() throws Throwable {

		// Checking the current organisation
		String currentOrg = driver.findElement(By.cssSelector(".xui-pageheading--title")).getText();

		// Checking if the current organisation is the target organisation
		if (value.getProperty("DesiredOrganisation").equals(currentOrg)) {
			System.out.println("You are on the desired organisation: " + value.getProperty("DesiredOrganisation"));
		}

		else {
			System.out.println("You are not on desired organisation: " + currentOrg);
			driver.findElement(By.cssSelector(".xrh-appbutton--body")).click();
			driver.findElement(By.linkText(value.getProperty("DesiredOrganisation"))).click();
			String finalOrg = driver.findElement(By.xpath("//span[@class='xrh-appbutton--text']")).getText();
			System.out.println("Organisation was changed to: " + finalOrg);
			Assert.assertEquals(value.getProperty("DesiredOrganisation").equals(finalOrg), true);
		}

	}

	@When("^Adding ANZ NZ bank (.+) and (.+) details$")
	public void adding_anz_nz_bank_and_details(String accountname, String accountnumber) throws Throwable {

		// Navigate to Bank Accounts page
		driver.findElement(By.xpath("//button[contains(text(),'Accounting')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bank accounts')]")).click();

		// Count the number of existing Bank Accounts
		int initialBankAccounts = driver.findElements(By.cssSelector(".bank")).size();
		System.out.println("You currently have " + initialBankAccounts + " Bank Accounts");

		// Add Bank Account
		driver.findElement(By.xpath("//span[contains(text(),'Add Bank Account')]")).click();

		// Select ANZ (NZ) Bank Account
		driver.findElement(By.id("xui-searchfield-1018-inputEl")).sendKeys("ANZ");
		driver.findElement(By.id("component-1027")).click();
		driver.findElement(By.xpath("//li[contains(text(),'ANZ (NZ)')]")).click();

		// Passing the Account Name
		driver.findElement(By.xpath("//input[@id='accountname-1037-inputEl']")).sendKeys(accountname);

		// Select Account Type
		driver.findElement(By.id("accounttype-1039-bodyEl")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Everyday (day-to-day)')]")).click();

		// Passing the Account Number
		driver.findElement(By.id("accountnumber-1068-inputEl")).sendKeys(accountnumber);

		// Submit Account Details
		driver.findElement(By.xpath("//a[@id='common-button-submit-1015']")).click();

	}

	@Then("^Bank details for (.+) successfully added$")
	public void bank_details_for_successfully_added(String accountname) throws Throwable {

		// Adding Bank Account Successful Message
		String addResult = driver.findElement(By.cssSelector(".message")).getText();
		String addSuccess = accountname + " has been added.";
		System.out.println(addResult);
		Assert.assertEquals(addResult.equals(addSuccess), true);

		// Count the new number of Bank Accounts
		int totalBankAccounts = driver.findElements(By.cssSelector(".bank")).size();
		System.out.println("You now have " + totalBankAccounts + " Bank Accounts");
	}

	@Then("^Bank (.+) and (.+) details shown in Bank Accounts page$")
	public void bank_and_details_shown_in_bank_accounts_page(String accountname, String accountnumber)
			throws Throwable {

		// Check if new Bank Account details is displayed in Bank Accounts Page
		driver.findElement(By.partialLinkText(accountname)).isDisplayed();
		driver.findElement(By.xpath("//span[contains(text(),'" + accountnumber + "')]")).isDisplayed();

		// Confirming that Bank Account Details were displayed
		System.out.println("Bank Account details for " + accountname + " was displayed in Bank Accounts page.");

		// Close the browser
		driver.quit();
	}

}