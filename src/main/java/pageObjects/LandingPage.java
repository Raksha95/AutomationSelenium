package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");

	By title = By.cssSelector(".text-center>h2");

	By NavBar = By.cssSelector("div[class='navbar navbar-default navbar-static-top']");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(signin);
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {

		return driver.findElement(NavBar);
	}
}
