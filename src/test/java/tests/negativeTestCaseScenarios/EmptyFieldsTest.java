package tests.negativeTestCaseScenarios;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.model.FrameId;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyFieldsTest {

    @Description("Try to login with empty credentials")
    @Test
    public void emptyFieldsTest(){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]"));

        makeAppointment.click();


        // after login try to click on login without passing credentials

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));
        loginButton.click();

        //verify it is failed login attempt

        //added implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement verifyMessage = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]"));

        String actualMessageForFailedLogin = verifyMessage.getText().trim();

        String expectedFailedLoginMessage = "Login failed! Please ensure the username and password are valid.";

        Assert.assertTrue(verifyMessage.isDisplayed(), "Message failed to be displayed");
        Assert.assertEquals(actualMessageForFailedLogin, expectedFailedLoginMessage, "Error message mismatch was found!");


        driver.quit();
    }
}
