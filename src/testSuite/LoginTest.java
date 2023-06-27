package testSuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    //open the chrome browser with the given Url
    @Before
    public void setUp()
    {
        openBrowser();
    }
   @Test
   public void userSholdLoginSuccessfullyWithValidCredentials()
   {
       //Entering the text in Username field
       driver.findElement(By.id("username")).sendKeys("tomsmith");
       //Entering the text in password field
       driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       //Click on the Login Button
       driver.findElement(By.xpath("//button[@class='radius']")).click();

       String actualSecureAreaText=driver.findElement(By.tagName("h2")).getText();
       String expectedSecureAreaText="Secure Area";
       Assert.assertEquals("Text is not similar",actualSecureAreaText,expectedSecureAreaText);
   }
   @Test
   public void verifyTheUsernameErrorMessage()
   {
     //Entering the text in Username field
       driver.findElement(By.id("username")).sendKeys("tomsmith1");
       //Entering the text in password field
       driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       //Click on the Login Button
       driver.findElement(By.xpath("//button[@class='radius']")).click();
//Getting the actual error message 'Your username is invalid!'
       String actualerrorMessage=driver.findElement(By.xpath("//div[@class='flash error']")).getText();
       String expectedErrorMessage="Your username is invalid!\n" +
               "×";
       //Comparing both the message
       Assert.assertEquals("Not the same error message",expectedErrorMessage,actualerrorMessage);
   }
   @Test
   public void verifyThePasswordErrorMessage()
   {
       //Entering the text in Username field
       driver.findElement(By.id("username")).sendKeys("tomsmith");
       //Entering the text in password field
       driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
       //Click on the Login Button
       driver.findElement(By.xpath("//button[@class='radius']")).click();
//Getting the actual error message
       String actualerrorMessage=driver.findElement(By.xpath("//div[@class='flash error' and @id='flash']")).getText();
       String expectedErrorMessage="Your password is invalid!\n" +
               "×";
       //Comparing both the message
       Assert.assertEquals("Not the same error message",expectedErrorMessage,actualerrorMessage);
   }
    @After
    public void tearDown()
    {
       // closeBrowser();
    }
}
