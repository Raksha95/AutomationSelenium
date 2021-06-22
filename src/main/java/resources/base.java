package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver; // driver - is made as Global object can be accessed in all the child classes as
								// well

	public Properties prop; // Can be accessed in all the child classes as well

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"D:\\Debayan\\Workspace\\Eclipse\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			// execute in chrome browser

			System.setProperty("webdriver.chrome.driver", "D://drivers//chromedriver6.exe"); // Launch chrome driver
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {

			// execute in firefox browser

			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe"); // Launch firefox driver
			driver = new FirefoxDriver();

		}

		else if (browserName.equals("Edge")) {

			// execute in Internet Explorer

			System.setProperty("webdriver.ie.driver", "D:\\drivers\\msedgedriver.exe"); // Launch Edge
																						// driver
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
