package tests.positiveTestCaseScenarios;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveLoginTest {

    @Description("Positive credentials to login into the Cura Healthcare Services!")
    @Test
    public void loginAndBookTheAppointment01(){

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
        usernameInput.sendKeys("John Doe");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"txt-password\"]"));
                passwordInput.sendKeys("ThisIsNotAPassword");

                // click on the login
        WebElement clickOnLogin = driver.findElement(By.xpath("//*[@id=\"btn-login\"]"));

        clickOnLogin.click();

        //Select the facility
        WebElement facilityDropdown = driver.findElement(By.xpath("//*[@id=\"combo_facility\"]"));
        facilityDropdown.sendKeys("Seoul CURA Healthcare Center");

        //apply for hospital readmission

        WebElement hospitalReadmission = driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]"));
        hospitalReadmission.click();

        //HealthCareProgram
        WebElement healthcareProgramSelect = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div/label[1]"));
        healthcareProgramSelect.click();


        //VisitDate
        WebElement visitDateSelector = driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        visitDateSelector.sendKeys("02/08/2025");

        //now we will add the comments
        WebElement comments = driver.findElement(By.xpath("//*[@id=\"txt_comment\"]"));
        comments.sendKeys("Added mock appointment!!");

        WebElement bookAppointment = driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]"));
        bookAppointment.click();

        // Let's wait and confirm the appointment has been booked successfully!
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2"));

        Assert.assertTrue(confirmationMessage.isDisplayed(), "Appointment confirmation is not displayed");


        //added implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.quit();

    }

}
