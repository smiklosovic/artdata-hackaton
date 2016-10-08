package art.data.hackaton.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

@Data
public class NasjonalMuseetResponse {

    @JsonProperty
    private String author;

    @JsonProperty
    private String title;

    @JsonProperty
    private String linkToImage;

    @JsonProperty
    private String linkToWebSite;
}
