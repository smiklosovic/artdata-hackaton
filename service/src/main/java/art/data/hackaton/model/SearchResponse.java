package art.data.hackaton.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    @JsonProperty
    private List<NasjonalMuseetResponse> museet;

    @JsonProperty
    private WeatherResponse weather;
}
