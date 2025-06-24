package tests.positiveTestCaseScenarios;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookAppointmentAllOptions {

    @Description("Book appointment with all options selected!")
    @Test
    public void allOptionsSelected() {

        WebDriver driver = new FirefoxDriver();

        // Step 1: Open Homepage
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Step 2: Click Make Appointment
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();

        // Step 3: Login
        WebElement userName = driver.findElement(By.id("txt-username"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        // Step 4: Fill Appointment Details
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement facilitySelection = driver.findElement(By.id("combo_facility"));
        facilitySelection.sendKeys("Seoul CURA Healthcare Center");

        WebElement applyForHospitalReadmission = driver.findElement(By.name("hospital_readmission"));
        applyForHospitalReadmission.click();

        WebElement healthcareProgram = driver.findElement(By.id("radio_program_medicaid"));
        healthcareProgram.click();

        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys("11/11/2025");

        WebElement comments = driver.findElement(By.id("txt_comment"));
        comments.sendKeys("I need this appointment for the treatment");

        WebElement bookAppointment = driver.findElement(By.id("btn-book-appointment"));
        bookAppointment.click();

        // Step 5: Verify Confirmation Message
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement appointmentConfirmation = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/p"));
        String actualMessage = appointmentConfirmation.getText().trim();
        String expectedMessage = "Please be informed that your appointment has been booked as following:";

        Assert.assertEquals(actualMessage, expectedMessage, "Error Message text mismatch!");
        Assert.assertTrue(appointmentConfirmation.isDisplayed(), "Error message is not displayed!");

        driver.quit();
    }
}
