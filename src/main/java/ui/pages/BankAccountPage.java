package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankAccountPage extends BasePage {

    @FindBy(xpath="//button[@id='jh-create-entity']")
    private WebElement createButton;
    @FindBy(xpath="//a/span[text()='View']")
    private WebElement viewButton;
    @FindBy(xpath="//span[text()='Delete']/parent::button")
    private WebElement deleteButton;
    @FindBy(xpath="//a/span[text()='Edit']")
    private WebElement editButton;
    @FindBy(xpath="//input[@name='name']")
    private WebElement nameInput;
    @FindBy(xpath="//input[@name='balance']")
    private WebElement balanceInput;
    @FindBy(xpath = "//button[@id='save-entity']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@id='cancel-save']")
    private WebElement cancelButton;
    private WebDriver driver;

    public BankAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterBalance(String balance) {
        balanceInput.clear();
        balanceInput.sendKeys(balance);
    }

    public void clickSave() {
        saveButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }
    public void clickCreateButton(){
        createButton.click();
    }
    public boolean isViewPresent(){
        return viewButton.isDisplayed();
    }
    public boolean isDeletePresent(){
        return deleteButton.isDisplayed();
    }
    public boolean isEditPresent(){
        return editButton.isDisplayed();
    }
    public boolean isFormVisible() {
        return nameInput.isDisplayed() && balanceInput.isDisplayed();
    }
    public void clickDeleteButton(){
        deleteButton.click();
    }
}
