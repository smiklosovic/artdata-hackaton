package art.data.hackaton.solr;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toSet;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import art.data.hackaton.model.NasjonalMuseetResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        List<NasjonalMuseetResponse> responseList = deriveResponse(nasjonalMuseetSearchQueryResponses);

        return removeDuplicates(responseList);
    }

    private List<NasjonalMuseetResponse> removeDuplicates(List<NasjonalMuseetResponse> responseList) {
        return new ArrayList<>(responseList.stream().collect(toSet()));
    }

    private List<NasjonalMuseetResponse> deriveResponse(List<HttpEntity> httpEntities) {

        List<NasjonalMuseetResponse> nasjonalMuseetResponses = new ArrayList<>();

        for (HttpEntity httpEntity : httpEntities) {

            JSONObject jsonObject = new JSONObject(httpEntity.getBody().toString());

            for (String field : jsonObject.keySet()) {
                String f = field;
                System.out.println(field);
            }

            JSONArray docsArray = jsonObject.getJSONObject("response").getJSONArray("docs");

            for (int i = 0; i < docsArray.length(); i++) {
                NasjonalMuseetResponse nasjonalMuseetResponse = new NasjonalMuseetResponse();

                JSONObject docsRecord = docsArray.getJSONObject(i);

                nasjonalMuseetResponse.setAuthor(getAuthor(docsRecord));
                nasjonalMuseetResponse.setTitle(getTitle(docsRecord));
                nasjonalMuseetResponse.setLinkToImage(getImageUrl(docsRecord));
                nasjonalMuseetResponse.setLinkToWebSite(getWebUrl(docsRecord));

                nasjonalMuseetResponses.add(nasjonalMuseetResponse);
            }
        }

        return nasjonalMuseetResponses;
    }

    private String getImageUrl(JSONObject jsonObject) {
        String id = jsonObject.getString("artifact.defaultMediaIdentifier");
        return String.format("http://dms01.dimu.org/image/%s?dimension=600x600", id);
    }

    private String getAuthor(JSONObject jsonObject) {
        return jsonObject.getString("artifact.ingress.producer");
    }

    private String getTitle(JSONObject jsonObject) {
        return jsonObject.getString("artifact.ingress.title");
    }

    private String getWebUrl(JSONObject jsonObject) {
        return null;
    }
}
