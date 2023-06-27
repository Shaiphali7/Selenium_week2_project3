package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser()
    {
         String baseUrl = "http://the-internet.herokuapp.com/login";
        //Launch the chrome browser
        driver = new ChromeDriver();

        //Open the Url into Browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();


        // giving Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser()
    {
        driver.quit();
    }
}

