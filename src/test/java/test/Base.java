package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.Common;
import utils.ReadPropertiesFile;

public class Base {
	static WebDriver driver;

//	String browser = "chrome";
//	String url = "https://www.fb.com";
	
	String browser;
	String url;
	String configFile = "config.properties";

	Common common;

	public void readConfigFile() {
		ReadPropertiesFile rpf = new ReadPropertiesFile();
		Properties prop = rpf.readFile(configFile);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		System.out.println("browser = "+browser);
		System.out.println("url = "+url);
		
	}

	@BeforeSuite
	public void beforeSuite() {
		readConfigFile();
		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();

	}

	@AfterSuite
	public void afterSuite() {
		common.quitBrowser();
	}

}
