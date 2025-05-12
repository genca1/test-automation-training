package automation.glue;

import config.AutomationFrameworkConfiguration;
import drivers.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.SignInPage;
import util.ConfigurationProperties;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private SignInPage signInPage;

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects() {
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        signInPage = new SignInPage();
    }
    @Given("^I go to the Website")
    public void i_go_to_the_website() {
        driver = DriverSingleton.getDriver();
        driver.get("https://www.automationexercise.com/signup");
        System.out.println("Navigating to automation practice website..");
    }

    @When("^I click on Sign In button")
    public void i_click_on_sign_in_button() {
        signInPage.signIn(configurationProperties.getEmail(), configurationProperties.getName());
        System.out.println("Credentials entered..");
    }

    @Then("^I can open information details page")
    public void i_can_open_information_details_page() {
        System.out.println("Information page..");
    }
}
