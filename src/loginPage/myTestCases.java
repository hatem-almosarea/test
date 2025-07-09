package loginPage;

import java.util.List;
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

	String TheUserName;
	String ThePassword = "Test@1234";

	@BeforeTest
	public void SignUp() {
		driver.get(theURL);
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = true)
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
		String[] FirstNames = { "amira", "rogina", "dana", "mais", "dareen" };
		int RandomIndexForFirstName = rand.nextInt(FirstNames.length);
		String randomFirstName = FirstNames[RandomIndexForFirstName];

		String[] LastNames = { "alaa", "saif", "abduallah", "hamzeh", "marwan", "abdelraheem", "omar" };
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

		// Actions

		TheUserName = randomFirstName + randomLastName + randomNumberForTheEmail;

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

		PostalCodeInput.sendKeys(PostalCode);
		LoginNameInput.sendKeys(TheUserName);
		PasswordInput.sendKeys(ThePassword);
		PasswordConfirmInput.sendKeys(ThePassword);
		agreeBox.click();
		ContinueButton.click();

		Thread.sleep(3000);

	}

	@Test(priority = 2, enabled = true)
	public void Logout() throws InterruptedException {
		WebElement LogoutButton = driver.findElement(By.linkText("Logoff"));
		LogoutButton.click();
		Thread.sleep(1000);
		WebElement continueButton = driver.findElement(By.linkText("Continue"));
		continueButton.click();

	}

	@Test(priority = 3, enabled = true)
	public void Login() {
		WebElement LoginAndRegisterButton = driver.findElement(By.partialLinkText("Login or"));
		LoginAndRegisterButton.click();
		WebElement Loginname = driver.findElement(By.id("loginFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("loginFrm_password"));
		Loginname.sendKeys(TheUserName);
		passwordInput.sendKeys(ThePassword);
		WebElement LoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		LoginButton.click();

	}

	@Test(priority = 4,invocationCount=1)
	public void AddToCart() throws InterruptedException {
		driver.navigate().to(theURL);
		Thread.sleep(1000);
	//	WebElement theItemsContainer = driver.findElement(By.cssSelector("section[id='latest'] div[class='container-fluid']"));
	//	int numberOfItems = theItemsContainer.findElement(By.cssSelector(".thumbnails.list-inline")).findElements(By.tagName("div")).size();
	//	System.out.println(numberOfItems);
		
		List<WebElement> theListOfItems = driver.findElements(By.className("prdocutname"));
		
		int TotalNumberOfItems =theListOfItems.size();
		System.out.println(TotalNumberOfItems);
		int RandomItemIndex = rand.nextInt(2);
		theListOfItems.get(RandomItemIndex).click();
		Thread.sleep(3000);
		if(driver.getPageSource().contains("Out of Stock")) {driver.navigate().back();
		System.out.println("sorry the item out of the stock");
	    }else {
		System.out.println("the item is available");}
		
	} 

}
