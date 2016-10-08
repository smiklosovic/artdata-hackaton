package art.data.hackaton.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchResponse {

    @JsonProperty
    private NasjonalMuseetResponse museet;

    @JsonProperty
    private WeatherResponse weather;
}
