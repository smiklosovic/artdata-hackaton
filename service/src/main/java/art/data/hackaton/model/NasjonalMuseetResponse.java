package art.data.hackaton.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NasjonalMuseetResponse {

    @JsonProperty
    private String author;

    @JsonProperty
    private String title;
}
