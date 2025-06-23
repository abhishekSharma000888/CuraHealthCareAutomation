package base;

import driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception{

        DriverManagerTL.init();
        DriverManagerTL.getDriver().manage().window().maximize();
        DriverManagerTL.getDriver().get("https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown(){

        DriverManagerTL.down();
    }
}
