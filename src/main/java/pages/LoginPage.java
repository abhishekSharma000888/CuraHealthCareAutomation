package pages;

import base.CommonToAll;
import org.openqa.selenium.By;

public class LoginPage extends CommonToAll {

    private final By username = By.id("txt-username");
    private final By password = By.id("txt-password");
    private final By loginBtn = By.id("btn-login");

    public void login(String user, String pass) {
        enterInput(username, user);
        enterInput(password, pass);
        clickElement(loginBtn);
    }
}
