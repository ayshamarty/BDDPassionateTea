package com.bae.cucumber.tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PassionateTeaTest {
	public static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}
	//
	// @Given("^the correct web address$")
	// public void the_correct_web_address() {
	// driver.manage().window().maximize();
	// driver.get("http://www.practiceselenium.com/welcome.html");
	//
	// }
	//
	// @When("^I navigate to the 'Menu' page$")
	// public void i_navigate_to_the_Menu_page() {
	// WebElement navigateToMenu = driver
	// .findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
	// navigateToMenu.click();
	//
	// }
	//
	// @Then("^I can browse a list of the available products\\.$")
	// public void i_can_browse_a_list_of_the_available_products() {
	// WebElement verifyGreenTea = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"));
	// WebElement verifyRedTea = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong"));
	// WebElement verifyOolong = driver.findElement(
	// By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong"));
	// assertTrue(verifyOolong.isDisplayed() && verifyRedTea.isDisplayed() &&
	// verifyGreenTea.isDisplayed());
	// }
	//
	// @When("^I click the checkout button$")
	// public void i_click_the_checkout_button() {
	// WebElement clickCheckOut = driver
	// .findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
	// clickCheckOut.click();
	//
	// }
	//
	// @Then("^I am taken to the checkout page$")
	// public void i_am_taken_to_the_checkout_page() {
	// WebElement verifyCheckOut = driver
	// .findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
	// verifyCheckOut.click();
	// String URL = driver.getCurrentUrl();
	// Assert.assertEquals(URL, "http://www.practiceselenium.com/check-out.html");
	// }

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.manage().window().maximize();
		driver.get(arg1);

	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		WebDriverWait waitBing = (new WebDriverWait(driver, 10));
		waitBing.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sb_form_q\"]")));
		WebElement searchBing = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		searchBing.sendKeys(arg1);
		searchBing.submit();

		waitBing.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b_results\"]")));
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {

		WebElement checkSearchWorks = driver.findElement(By.xpath("//*[@id=\"b_results\"]"));
		assertTrue(checkSearchWorks.isDisplayed());

	}

}
