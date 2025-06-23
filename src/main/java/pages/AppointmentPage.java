package pages;

import base.CommonToAll;
import org.openqa.selenium.By;

public class AppointmentPage extends CommonToAll {

    private final By facilityDropdown = By.id("combo_facility");
    private final By hospitalReadmissionCheckbox = By.id("chk_hospotal_readmission");
    private final By medicaidRadioBtn = By.id("radio_program_medicaid");
    private final By visitDate = By.id("txt_visit_date");
    private final By commentField = By.id("txt_comment");
    private final By bookAppointmentBtn = By.id("btn-book-appointment");

    public void bookAppointment(String date, String comment) {
        getElement(facilityDropdown).click(); // can add Select logic later
        clickElement(hospitalReadmissionCheckbox);
        clickElement(medicaidRadioBtn);
        enterInput(visitDate, date);
        enterInput(commentField, comment);
        clickElement(bookAppointmentBtn);
    }
}
