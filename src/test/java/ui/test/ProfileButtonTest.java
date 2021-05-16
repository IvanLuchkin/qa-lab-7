package ui.test;

import static org.junit.Assert.assertNotNull;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ui.page.MonthlySetupPage;

@RunWith(SerenityRunner.class)
public class ProfileButtonTest extends TestSetup {
    @Test
    public void profileMenuHasSubscriptionLink() {
        login();
        webDriver.get(MonthlySetupPage.SITE_LINK);
        MonthlySetupPage monthlySetupPage = PageFactory.initElements(webDriver, MonthlySetupPage.class);
        monthlySetupPage.accountMenuButton.click();
        assertNotNull(webDriver.findElement(By.cssSelector("[href=\"https://socialmediacalendar.app/my-account/subscriptions/\"]")));
    }
}
