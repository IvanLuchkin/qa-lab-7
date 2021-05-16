package ui.test;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import ui.page.CalendarPage;
import ui.page.LoginPage;

@RunWith(SerenityRunner.class)
public class LoginTest extends TestSetup {
    @Test
    public void successfulLoginRedirectsToCalendar() {
        login();
        assertEquals(CalendarPage.SITE_LINK, webDriver.getCurrentUrl());
    }

    @Test
    public void failedLoginStaysOnPage() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        webDriver.get(LoginPage.SITE_LINK);
        loginPage.setValueToEmail("");
        loginPage.setValueToPassword("");
        loginPage.confirmForm();
        Thread.sleep(200);
        assertEquals(webDriver.getCurrentUrl(), LoginPage.SITE_LINK);
    }

}