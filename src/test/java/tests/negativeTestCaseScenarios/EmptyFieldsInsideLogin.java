package tests.negativeTestCaseScenarios;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyFieldsInsideLogin {


    @Description("Putting empty fields into the login email and verifying whether the login failed or verified!")
    @Test

    public void emptyUsernameLogin(){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //find and add values to the username for the user.

        WebElement loginCredetentials = driver.findElement(By.xpath("//*[@id=\"txt-username\"]"));

        loginCredetentials.sendKeys("badUsername");

        //find the Login tab and click it

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));

        loginButton.click();


        //we will wait for 3 seconds so that we can validate the message appears for the invalid login
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement verifyMessage = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]"));

        //using asserts
        Assert.assertTrue(verifyMessage.isDisplayed(), "Error message is not displayed");

        String expectedErrorMessage = "Login failed! Please ensure the username and password are valid.";
        String actualErrorMessage = verifyMessage.getText().trim();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message text!");


        driver.quit();




    }
}
