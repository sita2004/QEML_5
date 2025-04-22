package stepDefinitions.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.ConfigManager;

import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class LoginUISteps {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open the login page")
    public void i_open_the_login_page() {
        String loginUrl = ConfigManager.get("baseUrl") + "/login";
        driver.get(loginUrl);
    }

    @Then("I should see the login form with username and password fields")
    public void i_should_see_the_login_form_with_username_and_password_fields() {
        assertTrue(driver.findElement(By.id("username")).isDisplayed());
        assertTrue(driver.findElement(By.id("password")).isDisplayed());
    }

    @Then("I should see the {string} button")
    public void i_should_see_the_button(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));
        assertTrue(button.isDisplayed());
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on the {string} button")
    public void i_click_on_the_button(String buttonText) {
        driver.findElement(By.xpath("//button[text()='" + buttonText + "']")).click();
    }

    @Then("I should see a login success message {string}")
    public void i_should_see_login_success_message(String expectedMessage) {
        WebElement successBanner = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'You are logged in as user')]")));

        String actualMessage = successBanner.getText().trim();
        assertEquals(expectedMessage, actualMessage);
    }



    @Then("I should remain on the login page")
    public void i_should_remain_on_the_login_page() {
        String expectedLoginUrl = ConfigManager.get("baseUrl") + "/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("User should remain on the login page", expectedLoginUrl, actualUrl);
    }

    @Then("I should see a validation message {string}")
    public void i_should_see_a_validation_message(String expectedMessage) {
        WebElement errorMsg = driver.findElement(By.cssSelector(".alert-danger"));
        assertEquals(expectedMessage.trim(), errorMsg.getText().trim());
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        WebElement errorMsg = driver.findElement(By.cssSelector(".alert-danger"));
        assertEquals(expectedMessage.trim(), errorMsg.getText().trim());
    }

    @Then("the password field should be of type {string}")
    public void the_password_field_should_be_of_type(String expectedType) {
        String actualType = driver.findElement(By.id("password")).getAttribute("type");
        assertEquals(expectedType, actualType);
    }

    @When("I select the {string} checkbox")
    public void i_select_the_checkbox(String labelText) {
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(.,'" + labelText + "')]/input[@type='checkbox']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Then("the checkbox should be selected")
    public void the_checkbox_should_be_selected() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        assertTrue(checkbox.isSelected());
    }
}
