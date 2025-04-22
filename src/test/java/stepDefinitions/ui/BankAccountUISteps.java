package stepDefinitions.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.BankAccountPage;
import ui.utils.ConfigManager;

public class BankAccountUISteps {
    private WebDriver driver;
    private BankAccountPage bankAccountPage;

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

    @Given("I login with valid credentials and navigate to the Bank Account Page")
    public void iLoginWithValidCredentialsAndNavigateToTheBankAccountPage() {
        driver.get(ConfigManager.get("baseUrl") + "/login");
        driver.findElement(By.id("username")).sendKeys(ConfigManager.get("valid.username"));
        driver.findElement(By.id("password")).sendKeys(ConfigManager.get("valid.password"));
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        // Navigate to Bank Account page after login
        driver.get(ConfigManager.get("baseUrl") + "/bank-account");
        bankAccountPage = new BankAccountPage(driver);
    }

    @When("I click on the Create button on the Bank Account page")
    public void iClickOnTheCreateButtonOnTheBankAccountPage() {
        //driver.get(ConfigManager.get("baseUrl")+"/bank-account/new");
        bankAccountPage.clickCreateButton();
        //driver.get(ConfigManager.get("baseUrl")+"/bank-account/new");
    }

    @Then("the Bank Account form should be visible")
    public void theBankAccountFormShouldBeVisible() {
        //driver.get(ConfigManager.get("baseUrl")+"/bank-account/new");
        assertTrue(bankAccountPage.isFormVisible());
    }

    @And("I enter name {string} and balance {string}")
    public void iEnterNameAndBalance(String name, String balance) {
        bankAccountPage.enterName(name);
        bankAccountPage.enterBalance(balance);
    }

    @And("I click the Save button on the Bank Account form")
    public void iClickTheSaveButtonOnTheBankAccountForm() {
        bankAccountPage.clickSave();
    }

    @Then("I should be redirected to the Bank Account listing page")
    public void iShouldBeRedirectedToBankAccountListingPage() {
        assertEquals(driver.getCurrentUrl(), ConfigManager.get("baseUrl") + "/bank-account");
    }

    @And("I click the Cancel button on the Bank Account form")
    public void iClickTheCancelButtonOnTheBankAccountForm() {
        bankAccountPage.clickCancel();
    }

    @Then("I should see the View button for the Bank Account")
    public void iShouldSeeTheViewButtonForTheBankAccount() {
        assertTrue(bankAccountPage.isViewPresent());
    }

    @Then("I should see the Edit button for the Bank Account")
    public void iShouldSeeTheEditButtonForTheBankAccount() {
        assertTrue(bankAccountPage.isEditPresent());
    }

    @Then("I should see the Delete button for the Bank Account")
    public void iShouldSeeTheDeleteButtonForTheBankAccount() {
        assertTrue(bankAccountPage.isDeletePresent());
    }

    @When("I click the Delete button for the Bank Account")
    public void iClickTheDeleteButtonForTheBankAccount() {
        bankAccountPage.clickDeleteButton();
    }

    @Then("the Bank Account should be deleted and no longer visible in the listing")
    public void theBankAccountShouldBeDeletedAndNoLongerVisibleInTheListing() {
        // Check that the bank account is no longer present
        assertFalse(bankAccountPage.isViewPresent());
    }
}
