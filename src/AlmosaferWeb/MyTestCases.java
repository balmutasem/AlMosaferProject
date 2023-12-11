package AlmosaferWeb;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTestCases {
	String TheWebSite = "https://global.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	@BeforeTest
	public void MyBeforeTest()  {
		driver.manage().window().maximize();
		driver.get(TheWebSite);
		WebElement WelcomeScreen = driver.findElement(By.cssSelector("button[class='sc-jTzLTM hQpNle cta__button cta__saudi btn btn-primary']"));
		WelcomeScreen.click();		
	}
	
	@Test(enabled=false)
	public void CheckTheLanguage()  {
		String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLang = "en";
		softassert.assertEquals(ActualLang, ExpectedLang, "this is to check the language");
	}
	@Test(enabled=false) 
	public void CheckTheCurrency()  {
		String ExpectedCurrency = "SAR";
		WebElement CurrencyElement = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
		String ActualCurrency = CurrencyElement.getText();
		softassert.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	@Test(enabled=false)  
	public void CheckTheContactNumber()  {
		String ExpectedContactNumber = "+966554400000";
		WebElement ContactNumberElement = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
		String ActualContactNumber = ContactNumberElement.getText();
		softassert.assertEquals(ActualContactNumber, ExpectedContactNumber);	
	}
	@Test(enabled=false)
	public void CheckQittafLogo()  {
		WebElement QittafLogo = driver.findElement(By.xpath("//div[@class='sc-dznXNo iZejAw']"));
		boolean isQittafLogoDisplayed = QittafLogo.isDisplayed();
		boolean expectedQittafLogoIsDisplayed = true;
		System.out.println(isQittafLogoDisplayed);
		softassert.assertEquals(isQittafLogoDisplayed, expectedQittafLogoIsDisplayed);	
	}
	@Test(enabled=false)
	public void HotelTabIsNotSelected()  {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualSelectAreaValue = HotelTab.getAttribute("aria-selected");
		String ExpectedSelectAreaValue = "false";
		Assert.assertEquals(ActualSelectAreaValue, ExpectedSelectAreaValue);
		}
	@Test()
	public void CheckTheDepatureAndTheArrivalDate()  {
		WebElement ActualDepatureDate = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"));
		WebElement ActualReturnDate = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"));
		int ActualDepatureDateValue = Integer.parseInt(ActualDepatureDate.getText());
		int ActualReturnDateValue = Integer.parseInt(ActualReturnDate.getText());
		LocalDate today = LocalDate.now();
		int ExpectedDepatureDateValue =today.plusDays(1).getDayOfMonth();
		int ExpectedReturnDateValue =today.plusDays(2).getDayOfMonth();
		Assert.assertEquals(ExpectedDepatureDateValue,ExpectedDepatureDateValue );
		Assert.assertEquals(ActualReturnDateValue, ExpectedReturnDateValue);
	}
	
	@AfterTest
	public void MyAfterTest()  {
		softassert.assertAll();
	}
	

}
