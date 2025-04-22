package ui.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperationPage extends BasePage {

    @FindBy(xpath = "//button[@id='save-entity']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@id='cancel-save']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountInput;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//div[contains(@class, 'success-message')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(@class, 'form-container')]")
    private WebElement formContainer;
@FindBy(xpath="//button[@id='jh-create-entity']")
private WebElement createButton;
   @FindBy(xpath="//a/span[text()='View']")
private WebElement viewButton;
   @FindBy(xpath="//span[text()='Delete']/parent::button")
   private WebElement deleteButton;
   @FindBy(xpath="//a/span[text()='Edit']")
   private WebElement editButton;
    private WebDriver driver;

    public OperationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void enterDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void clickSave() {
        saveButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }

    public boolean isFormCleared() {
        return amountInput.getAttribute("value").isEmpty() &&
                descriptionInput.getAttribute("value").isEmpty();
    }

    public boolean isFormVisible() {
        return formContainer.isDisplayed();
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
}

