package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		LandingPage l = new LandingPage(driver);

		l.getLogin().click();

		// System.out.println(l.getTitle().getText());

		LoginPage lp = new LoginPage(driver);

		lp.getEmail().sendKeys(Username);

		lp.getPassword().sendKeys(Password);

		// System.out.println(text);

		lp.getLogin().click();
	}

	@AfterTest

	public void teardown() {

		driver.close();
	}

	@DataProvider

	public Object[][] getData() {

		// Row stands for how many different data types test should run
		// Column stands for how many values each test contains

		Object[][] data = new Object[2][3];

		data[0][0] = "new@mailinator.com";

		data[0][1] = "123456";

		data[0][2] = "Restricted User";

		data[1][0] = "helloo@mailinator.com";

		data[1][1] = "7891011";

		data[1][2] = "Non-Restricted User";

		return data;

	}

}
