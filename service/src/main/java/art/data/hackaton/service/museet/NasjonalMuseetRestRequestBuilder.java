package art.data.hackaton.service.museet;

import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.SearchRequest;
import org.springframework.stereotype.Component;

@Component
public class NasjonalMuseetRestRequestBuilder {

    public NasjonalMuseetRequest buildQuery(SearchRequest searchRequest) {
        return NasjonalMuseetRequest.build(searchRequest);
    }
}
