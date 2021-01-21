package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	WebDriver driver;
	
	
	public void setupBrowser(String browser, String url) {
		
		String curDir = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", curDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", curDir+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", curDir+"\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else{
			System.out.println("Valid browser was not specified, hence quiting the automation run");
			System.exit(0);
		}
		
		driver.manage().window().maximize();
		
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}






