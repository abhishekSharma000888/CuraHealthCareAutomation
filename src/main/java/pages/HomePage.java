package pages;

import base.CommonToAll;
import org.openqa.selenium.By;

public class HomePage extends CommonToAll {

    private final By makeAppointmentBtn = By.id("btn-make-appointment");
    public void clickMakeAppointment() {
        clickElement(makeAppointmentBtn);
    }
}
