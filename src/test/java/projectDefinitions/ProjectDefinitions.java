package projectDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectDefinitions {
    private WebDriver driver;

    @Given("I have entered my {string}")
    public void i_have_entered_my_email(String string) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(string);
    }

    @Given("I have also entered a {string}")
    public void i_have_also_entered_a_username(String string) throws InterruptedException {
        WebElement username = driver.findElement(By.id("new_username"));
        username.sendKeys(string);

    }

    @Given("I have also selected a {string}")
    public void i_have_also_selected_a_password(String string) throws InterruptedException {
        WebElement password = driver.findElement(By.id("new_password"));
        password.sendKeys(string);
        Thread.sleep(5000);
    }

    @When("I press sign up")
    public void i_press_sign_up() throws InterruptedException {
        WebElement signUp = driver.findElement(By.cssSelector("#create-account"));
        signUp.click();
        Thread.sleep(3000);


    }

    @Then("the <result> should be on the screen")
    public void the_result_should_be_on_the_screen() throws InterruptedException {
        driver.quit();

    }

    private void sendKeys(WebDriver driver, By by, String keys) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(keys);
    }

    private void click(WebDriver driver, By by) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
}
