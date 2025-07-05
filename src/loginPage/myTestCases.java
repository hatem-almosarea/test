package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();
	String TheURL = "https://automationteststore.com/";
	String signupPage = "https://automationteststore.com/index.php?rt=account/create ";

	@BeforeTest

	public void mySetup() {
		driver.get(TheURL);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void signup() {

		driver.navigate().to(signupPage);

		// Elements
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement email = driver.findElement(By.id("AccountFrm_email"));
		WebElement telephone = driver.findElement(By.xpath("//*[@id=\"AccountFrm_telephone\"]"));
		WebElement fax = driver.findElement(By.xpath("//*[@id=\"AccountFrm_fax\"]"));

		// Actions
		firstName.sendKeys("Hatem");
		lastName.sendKeys("Almosarea");
		email.sendKeys("Hatem_ww@hotmail.com");
		telephone.sendKeys("0123456");
		fax.sendKeys("123456");

	}

}
