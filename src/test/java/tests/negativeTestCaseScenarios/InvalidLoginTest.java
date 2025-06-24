package tests.negativeTestCaseScenarios;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidLoginTest {

    @Description("Negative credentials to login into the Cura Healthcare Services!")
    @Test
    public void negativeLoginAndBookTheAppointment02(){

        //open the web browser
        WebDriver driver = new FirefoxDriver();

        //maximize the window for the browser
        driver.manage().window().maximize();

        //navigate to the web app.
        driver.get("https://katalon-demo-cura.herokuapp.com");

        //click on the makeAppointment button
        WebElement clickOnMakeAppointment = driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]"));
        clickOnMakeAppointment.click();

        //now we will enter the username and password

        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"txt-username\"]"));
        usernameInput.sendKeys("JohnDoe");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"txt-password\"]"));
        passwordInput.sendKeys("word");

        // click on the login
        WebElement clickOnLogin = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));
        clickOnLogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        //locating the error message
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='lead text-danger']")).getText().trim(),
                "Login failed! Please ensure the username and password are valid.", "Error message text is incorrect");

    }
}
