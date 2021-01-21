package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;

public class Base {
	static WebDriver driver;

//	String browser = "chrome";
	String url = "https://www.fb.com";

	Common common;


//	@BeforeSuite
//	public void beforeSuite() {
//
//		common = new Common();
//		common.setupBrowser(browser, url);
//		driver = common.getDriver();
//
//	}
//
//	@AfterSuite
//	public void afterSuite() {
//		common.quitBrowser();
//	}
	
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser) {

		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();

	}

	@AfterTest
	public void afterTest() {
//		common.quitBrowser();
	}

}
