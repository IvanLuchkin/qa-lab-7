package api.entity;

import api.serialization.ZonedDateTimeDeserializer;
import api.serialization.ZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class Page {
    private Long id;
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime createdAt;
    private String name;
    private String pageUrl;
}
