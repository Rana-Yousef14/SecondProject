import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://automationteststore.com/";
	String[] firstNames = { "ahmad", "ali", "omar", "ayat", "alla", "sawsan", "rama" };
	String[] lastNames = { "mohammad", "mustafa", "abdullah", "malek", "saleh", "akram", "zaid" };
	Random rand = new Random();

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(theWebsite);
	}

	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		int randomIndexForTheFirstName = rand.nextInt(firstNames.length);
		int randomIndexForTheLastName = rand.nextInt(lastNames.length);
		String userFirstName = firstNames[randomIndexForTheFirstName];
		String userLastName = lastNames[randomIndexForTheLastName];
		int randomNumberForTheEmail = rand.nextInt(564548);
		String domainName = "@gmail.com";
		String email = userFirstName + userLastName + randomNumberForTheEmail + domainName;
		driver.findElement(By.linkText("Login or register")).click();
		WebElement signUpButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		signUpButton.click();
		Thread.sleep(2000);
		WebElement firstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		firstNameInput.sendKeys(userFirstName);
		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		lastNameInput.sendKeys(userLastName);
		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		emailInput.sendKeys(email);
		WebElement addressInput = driver.findElement(By.id("AccountFrm_address_1"));
		addressInput.sendKeys("Amman");
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));
		cityInput.sendKeys("Capital City");
		WebElement countryInput = driver.findElement(By.id("AccountFrm_country_id"));
		Select selector2 = new Select(countryInput);
		int randomCountry = rand.nextInt(1, 240);
		selector2.selectByIndex(randomCountry);
		Thread.sleep(3000);
		WebElement zoneIdInput = driver.findElement(By.id("AccountFrm_zone_id"));
		Select selector = new Select(zoneIdInput);
		int randomState = rand.nextInt(1, 5);
		selector.selectByIndex(randomState);
		WebElement postalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		postalCodeInput.sendKeys("13310");
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		loginNameInput.sendKeys(userFirstName + userLastName + randomNumberForTheEmail);
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		passwordInput.sendKeys("Ilovemymom123@");
		WebElement confirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		confirmPasswordInput.sendKeys("Ilovemymom123@");
		WebElement agreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));
		agreeCheckBox.click();
		WebElement continueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		continueButton.click();
	}

	@Test(priority = 2)
	public void logOut() throws InterruptedException {
		Thread.sleep(5000);
		String logOutUrl = "https://automationteststore.com/index.php?rt=account/logout";
		driver.get(logOutUrl);
	}
}
