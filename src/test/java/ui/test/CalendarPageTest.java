package ui.test;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import ui.page.CalendarPage;

@RunWith(SerenityRunner.class)
public class CalendarPageTest extends TestSetup {
    @Test
    public void hasTitle() {
        login();
        CalendarPage calendarPage = PageFactory.initElements(webDriver, CalendarPage.class);
        assertTrue(calendarPage.calendarTitle.isDisplayed());
    }
}
