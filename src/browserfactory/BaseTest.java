package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    //parameterised method
    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        //Launch URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit(); //closing all selenium browsers
    }

}
