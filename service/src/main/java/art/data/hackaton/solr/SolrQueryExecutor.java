package art.data.hackaton.solr;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import art.data.hackaton.model.NasjonalMuseetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SolrQueryExecutor {

    private static final String NASJONAL_MUSEET_ROOT_URL = "http://api.dimu.org/api/solr/select";

    @Autowired
    private RestTemplate restTemplate;

    public NasjonalMuseetResponse execute(String searchQuery) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(singletonList(APPLICATION_JSON));

        HttpEntity<String> headers = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> getEntity;

        try {
            getEntity = restTemplate.exchange(NASJONAL_MUSEET_ROOT_URL + searchQuery, GET, headers, String.class);
        } catch (RestClientException e) {
            return new NasjonalMuseetResponse();
        }

        NasjonalMuseetResponse nasjonalMuseetResponse = parseResponse(getEntity);

        return nasjonalMuseetResponse;
    }

    private NasjonalMuseetResponse parseResponse(ResponseEntity<String> getEntity) {
        return new NasjonalMuseetResponse();
    }

}
