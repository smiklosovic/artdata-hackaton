package art.data.hackaton.service.weather;

import art.data.hackaton.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate defaultRestTemplate;

    public Optional<WeatherResponse> search() {
        return Optional.ofNullable(new WeatherResponse());
    }
}
