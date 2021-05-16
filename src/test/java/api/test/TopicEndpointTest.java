package api.test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

import api.config.ApiEndpointTemplateConfig;
import api.entity.Topic;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TopicEndpointTest {
    private final ApiEndpointTemplateConfig apiTemplate = new ApiEndpointTemplateConfig();

    @Test
    public void testGetAllTopics() {
        apiTemplate.getAllTopics()
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    public void testUpdateTopic() {
        Topic topic = apiTemplate.getTopicById(1L).as(Topic.class);
        String newDescription = topic.getDescription() + " -- ";
        topic.setDescription(newDescription);

        apiTemplate.updateTopic(topic).then().assertThat().statusCode(200);

        assertEquals(newDescription, apiTemplate.getTopicById(1L).as(Topic.class).getDescription());
    }
}
