package art.data.hackaton.service;

import static art.data.hackaton.Utils.dayUri;
import static art.data.hackaton.Utils.getHttpHeadersEntity;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;

import art.data.hackaton.Utils;
import art.data.hackaton.configuration.DefaultTestAnnotations;
import art.data.hackaton.model.SearchResponse;
import art.data.hackaton.model.WeatherResponse;
import art.data.hackaton.service.weather.WeatherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultTestAnnotations
public class WeatherServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testWeatherServiceController() throws Exception {
        final ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(dayUri(port), GET, getHttpHeadersEntity(), SearchResponse.class);

        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());

        SearchResponse searchResponse = responseEntity.getBody();
        assertNotNull(searchResponse);

        WeatherResponse weatherResponse = searchResponse.getWeather();

        assertNotNull(weatherResponse);
    }

    @Test
    public void testWeatherService() {
        final Optional<WeatherResponse> weatherResponse = weatherService.search("Oslo");

        assertTrue(weatherResponse.isPresent());
        assertNotNull(weatherResponse.get().getCondition());
        assertFalse(weatherResponse.get().getCondition().isEmpty());
        assertFalse(weatherResponse.get().getTemperature().isEmpty());
    }
}
