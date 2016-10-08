package art.data.hackaton.solr;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import art.data.hackaton.model.NasjonalMuseetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SolrQueryExecutor {

    private static final String NASJONAL_MUSEET_ROOT_URL = "http://api.dimu.org/api/solr/select";

    @Autowired
    private RestTemplate restTemplate;

    public List<NasjonalMuseetResponse> execute(List<String> searchQueries) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(singletonList(APPLICATION_JSON));

        HttpEntity<String> headers = new HttpEntity<>(httpHeaders);

        List<HttpEntity> nasjonalMuseetSearchQueryResponses = new ArrayList<>();

        for (String searchQuery : searchQueries) {
            try {
                nasjonalMuseetSearchQueryResponses.add(restTemplate.exchange(NASJONAL_MUSEET_ROOT_URL + searchQuery, GET, headers, String.class));
            } catch (RestClientException e) {
                log.info("Unable to make a query", e);
            }
        }

        return deriveResponse(nasjonalMuseetSearchQueryResponses);
    }

    private List<NasjonalMuseetResponse> deriveResponse(List<HttpEntity> httpEntities) {

        List<NasjonalMuseetResponse> nasjonalMuseetResponses = new ArrayList<>();

        for (HttpEntity httpEntity : httpEntities) {
            NasjonalMuseetResponse nasjonalMuseetResponse = new NasjonalMuseetResponse();


            // todo
        }

        return nasjonalMuseetResponses;
    }
}
