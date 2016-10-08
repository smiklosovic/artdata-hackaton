package art.data.hackaton.controller;

import static art.data.hackaton.Utils.dayUri;
import static art.data.hackaton.Utils.eveningUri;
import static art.data.hackaton.Utils.getHttpHeadersEntity;
import static art.data.hackaton.Utils.morningUri;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;

import art.data.hackaton.configuration.DefaultTestAnnotations;
import art.data.hackaton.model.SearchResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultTestAnnotations
public class SearchControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    private URI morningURI;

    private URI dayURI;

    private URI eveningURI;

    @Before
    public void setUp() throws Exception {
        this.eveningURI = eveningUri(port);
        this.morningURI = morningUri(port);
        this.dayURI = dayUri(port);
    }

    @Test
    public void testMorningURIInSearchController() throws Exception {

        final ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(morningURI, GET, getHttpHeadersEntity(), SearchResponse.class);

        final SearchResponse searchResponse = responseEntity.getBody();

        assertNotNull(searchResponse);
    }

    @Test
    public void testDayURIInSearchController() throws Exception {

        final ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(dayURI, GET, getHttpHeadersEntity(), SearchResponse.class);

        final SearchResponse searchResponse = responseEntity.getBody();

        assertNotNull(searchResponse);
    }

    @Test
    public void testEveningURIInSearchController() throws Exception {

        final ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(eveningURI, GET, getHttpHeadersEntity(), SearchResponse.class);

        final SearchResponse searchResponse = responseEntity.getBody();

        assertNotNull(searchResponse);
    }
}