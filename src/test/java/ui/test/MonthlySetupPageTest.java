package ui.test;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import ui.page.MonthlySetupPage;

@RunWith(SerenityRunner.class)
public class MonthlySetupPageTest extends TestSetup {
    @Test
    public void hasProfileMenu() {
        login();
        webDriver.get(MonthlySetupPage.SITE_LINK);
        MonthlySetupPage monthlySetupPage = PageFactory.initElements(webDriver, MonthlySetupPage.class);
        monthlySetupPage.accountMenuButton.click();
        assertTrue(monthlySetupPage.accountMenu.isDisplayed());
    }
}
