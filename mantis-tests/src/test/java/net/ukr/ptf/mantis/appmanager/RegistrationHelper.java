package net.ukr.ptf.mantis.appmanager;

import org.openqa.selenium.WebDriver;

public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();
    }

    public void start(String userName, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    }
}
