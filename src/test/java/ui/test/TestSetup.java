package ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import ui.page.LoginPage;

public class TestSetup {
    public WebDriver webDriver;

    @Before
    public void setup() {
        FirefoxOptions driverOptions = new FirefoxOptions();
        driverOptions.addArguments("--headless");
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver(driverOptions);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void login() {
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        webDriver.get(LoginPage.SITE_LINK);
        loginPage.setValueToEmail("ivan@producement.com");
        loginPage.setValueToPassword("056824Qq");
        loginPage.confirmForm();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}