package art.data.hackaton.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherResponse {

    @JsonProperty
    private String temperature;
}
