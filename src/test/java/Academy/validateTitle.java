package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

	}

	@Test

	public void basePageNavigation() throws IOException {

		LandingPage l = new LandingPage(driver);

		// Here we will compare the actual text with the expected text in the landing
		// page

		l.getTitle().getText();

		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
	}

	@AfterTest

	public void teardown() {

		driver.close();
	}
}
