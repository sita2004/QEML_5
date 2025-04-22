package stepDefinitions.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.OperationPage;
import ui.utils.ConfigManager;

public class OperationUISteps {
    private WebDriver driver;
    private OperationPage operationPage;

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

    @Given("I login with valid credentials in login page")
    public void iLoginWithValidCredentialsInLoginPage() {
        driver.get(ConfigManager.get("baseUrl") + "/login");
        driver.findElement(By.id("username")).sendKeys(ConfigManager.get("valid.username"));
        driver.findElement(By.id("password")).sendKeys(ConfigManager.get("valid.password"));
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

    }

    @When("I navigate to the Operation Page")
    public void iNavigateToTheOperationPage() {
        driver.get(ConfigManager.get("baseUrl") + "/operation");
        operationPage = new OperationPage(driver);
    }

    @When("I click on the Create button")
    public void iClickOnTheCreateButton() {
        operationPage.clickCreateButton();
    }

    @Then("the form should be visible")
    public void theFormShouldBeVisible() {
        assertTrue(operationPage.isFormVisible());
    }

    @And("I enter amount {string}")
    public void iEnterAmount(String amount) {
        operationPage.enterAmount(amount);
    }

    @And("I enter description {string}")
    public void iEnterDescription(String description) {
        operationPage.enterDescription(description);
    }

    @And("I click the Save button")
    public void iClickTheSaveButton() {
        operationPage.clickSave();
    }

    @Then("I should be redirected to the Operation listing page")
    public void iShouldBeRedirectedToListingPage() {
        assertEquals(driver.getCurrentUrl(), ConfigManager.get("baseUrl") + "/operation");
    }

    @And("I click the Cancel button")
    public void iClickTheCancelButton() {
        operationPage.clickCancel();
    }

    @Then("the View button should be visible")
    public void theViewButtonShouldBeVisible() {
        assertTrue(operationPage.isViewPresent());
    }

    @And("the Edit button should be visible")
    public void theEditButtonShouldBeVisible() {
        assertTrue(operationPage.isEditPresent());
    }

    @And("the Delete button should be visible")
    public void theDeleteButtonShouldBeVisible() {
        assertTrue(operationPage.isDeletePresent());
    }
}
