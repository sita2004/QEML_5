package ui.pages;


import ui.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static ui.utils.DriverFactory.getDriver;


public abstract class BasePage {
    protected WebDriver driver;
    //protected WebDriverWait wait;

    //    public BasePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        PageFactory.initElements(getDriver(), this);
//    }
    public BasePage() {
        this.driver = DriverFactory.getDriver(); // centralizes driver access
        PageFactory.initElements(driver, this);  // initializes page elements
    }


}

