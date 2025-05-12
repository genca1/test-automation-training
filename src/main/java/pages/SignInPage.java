package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    public SignInPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
    private WebElement signInEmail;

    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)")
    private WebElement signInName;

    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > button")
    private WebElement signInButton;

    public void signIn(String email, String password) {
        signInEmail.sendKeys(email);
        signInName.sendKeys(password);
        signInButton.click();
    }
}
