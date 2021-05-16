package api.test;

import static org.hamcrest.Matchers.notNullValue;

import api.config.ApiEndpointTemplateConfig;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ContactEndpointTest {
    private final ApiEndpointTemplateConfig apiTemplate = new ApiEndpointTemplateConfig();

    @Test
    public void testGetAllUserContacts() {
        apiTemplate.getAllUserContacts(1L)
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }
}
