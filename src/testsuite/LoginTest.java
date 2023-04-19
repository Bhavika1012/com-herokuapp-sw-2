package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Locating username field and entering username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //locate password field and entering password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //clicking on login button
        driver.findElement(By.tagName("i")).click();
        //verifying expected text
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Locating username field and entering username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //locate password field and entering password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //clicking on login button
        driver.findElement(By.tagName("i")).click();

        //verifying expected result
        String expectedText = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText().substring(0, 25);
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Locating username field and entering username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //locate password field and entering password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //clicking on login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //verifying text
        Assert.assertEquals(driver.findElement(By.id("flash")).getText(), "Your password is invalid!\n×");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
