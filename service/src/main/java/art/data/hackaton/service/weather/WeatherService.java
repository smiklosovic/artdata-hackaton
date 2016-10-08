package art.data.hackaton.service.weather;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import art.data.hackaton.model.WeatherResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {

    // api.openweathermap.org/data/2.5/weather?q=London&APPID=b6415eebc7e170a2dc19d668c2f24349

    private static String WEATHER_API_URL_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=%s";

    @Value("${weatherKey}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public Optional<WeatherResponse> search(String city) {

        final ResponseEntity<String> responseEntity = restTemplate.exchange(getWeatherApiUrl(city), GET, getHeaders(), String.class);

        return Optional.ofNullable(parseWeatherResponse(responseEntity));
    }

    private String getWeatherApiUrl(String city) {
        return String.format(WEATHER_API_URL_TEMPLATE, city, API_KEY);
    }

    private HttpEntity<String> getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(singletonList(APPLICATION_JSON));

        return new HttpEntity<>(httpHeaders);
    }

    private WeatherResponse parseWeatherResponse(ResponseEntity<String> responseEntity) {
        WeatherResponse weatherResponse = new WeatherResponse();

        JSONObject jsonObject = new JSONObject(responseEntity.getBody());

        String condition = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        weatherResponse.setCondition(condition);

        String temperature = Double.toString(jsonObject.getJSONObject("main").getDouble("temp"));
        weatherResponse.setTemperature(temperature);

        return weatherResponse;
    }
}
