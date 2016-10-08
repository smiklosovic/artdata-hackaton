package art.data.hackaton.controller;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import art.data.hackaton.configuration.DefaultTestAnnotations;
import art.data.hackaton.model.SearchResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultTestAnnotations
public class SearchControllerTest {

    @LocalServerPort
    private int port;

    private URL endpoint;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setUp() throws Exception {
        this.endpoint = new URL("http://localhost:" + port + "/api/search");
    }

    @Test
    public void testSearchController() throws Exception {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(singletonList(APPLICATION_JSON_UTF8));

        HttpEntity<String> getSearchEntity = new HttpEntity<>(httpHeaders);

        final ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(endpoint.toURI(), GET, getSearchEntity, SearchResponse.class);

        final SearchResponse searchResponse = responseEntity.getBody();

        assertNotNull(searchResponse);
    }
}