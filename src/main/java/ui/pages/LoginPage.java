package ui.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import api.models.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginPage extends BasePage{
//    private WebDriver driver;
//    private WebDriverWait wait;

    //    private By usernameInput = By.id("username");
//    private By passwordInput = By.id("password");
//    private By loginButton = By.xpath("//button[@class='btn btn-primary']");
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(id="username")
    private WebElement usernameInput;
    @FindBy(id="password")
    private WebElement passwordInput;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    private WebElement loginButton;
    //public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //super(driver);
    //}

    public void login(LoginUser user) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(user.getUsername());
//        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(user.getPassword());
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(user.getUsername());
//        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(user.getPassword());
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        logger.info("Attempting login for user: {}", user.getUsername());
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        logger.info("Login button clicked");

    }
    public boolean isUsernameFieldVisible() {
        try {
            return usernameInput.isDisplayed();
        } catch (Exception e) {
            logger.error("Username input not visible", e);
            return false;
        }
    }

    public boolean isPasswordFieldVisible() {
        try {
            return passwordInput.isDisplayed();
        } catch (Exception e) {
            logger.error("Password input not visible", e);
            return false;
        }
    }

    public boolean isButtonVisible(String buttonText) {
        try {
            return loginButton.isDisplayed() &&
                    loginButton.getText().trim().equalsIgnoreCase(buttonText.trim());
        } catch (Exception e) {
            logger.error("Login button not visible or does not match text: {}", buttonText, e);
            return false;
        }
    }

}
