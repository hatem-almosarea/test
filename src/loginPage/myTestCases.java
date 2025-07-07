package loginPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignUp = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	@BeforeTest
	public void SignUp() {
		driver.get(theURL);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void SignUP() throws InterruptedException {
		driver.navigate().to(SignUp);

		// Elements
		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement TelephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement FaxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement CompanyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement Address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement Address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement agreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StatSelect = driver.findElement(By.id("AccountFrm_zone_id"));

		// Data
		String[] FirstNames = { "hatem", "anas", "ali", "tarek" };
		int RandomIndexForFirstName = rand.nextInt(FirstNames.length);
		String randomFirstName = FirstNames[RandomIndexForFirstName];

		String[] LastNames = { "mosa", "saab", "jul", "mars" };
		int RandomIndexForLastName = rand.nextInt(LastNames.length);
		String randomLastName = LastNames[RandomIndexForLastName];

		int randomNumberForTheEmail = rand.nextInt(7000);
		String Email = randomFirstName + randomLastName + randomNumberForTheEmail + "@hotmail.com";
		String Telephone = "123456";
		String Fax = "67890";
		String Company = "swwag";
		String Address1 = "bredasingel";
		String Address2 = "holthuizerdreef";
		String City = "huissen";

		String PostalCode = "6844";
		String Password = "Test@1234";

		// Actions
		FirstNameInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telephone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Company);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);

		Select mySelectForTheCountry = new Select(CountrySelect);
		int numberOfCountryOptions = StatSelect.findElements(By.tagName("option")).size();
		int randomCountrySelect = rand.nextInt(1, numberOfCountryOptions);
		mySelectForTheCountry.selectByIndex(randomCountrySelect);

		Thread.sleep(1000);
		int numberOfOptions = StatSelect.findElements(By.tagName("option")).size();
		System.out.println();
		Select mySelectForTheState = new Select(StatSelect);
		int randomStateSelect = rand.nextInt(1, numberOfOptions);
		mySelectForTheState.selectByIndex(randomStateSelect);

		// Select mySelectForTheState = new Select(StatSelect);
		// int randomStateSelect = rand.nextInt(1,numberOfOptions);
		// mySelectForTheState.selectByValue("1705");

		// Select mySelectForTheState = new Select(StatSelect);
		// int randomStateSelect = rand.nextInt(1,numberOfOptions);
		// mySelectForTheState.selectByVisibleText("");

		PostalCodeInput.sendKeys(PostalCode);
		LoginNameInput.sendKeys(randomFirstName + randomLastName + randomNumberForTheEmail);
		PasswordInput.sendKeys(Password);
		PasswordConfirmInput.sendKeys(Password);
		agreeBox.click();
		ContinueButton.click();

	}

}
