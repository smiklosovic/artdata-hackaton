package art.data.hackaton.service;

import static java.util.Optional.of;

import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.NasjonalMuseetResponse;
import art.data.hackaton.model.SearchResponse;
import art.data.hackaton.model.WeatherResponse;
import art.data.hackaton.service.museet.NasjonalMuseetRestRequestBuilder;
import art.data.hackaton.service.museet.NasjonalMuseetService;
import art.data.hackaton.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private NasjonalMuseetService nasjonalMuseetService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private NasjonalMuseetRestRequestBuilder nasjonalMuseetRestRequestBuilder;

    public Optional<SearchResponse> search(int timeInHours, String city) {

        SearchResponse searchResponse = new SearchResponse();

        Optional<WeatherResponse> weatherResponse = weatherService.search(city);

        if (weatherResponse.isPresent()) {
            searchResponse.setWeather(weatherResponse.get());
        }

        NasjonalMuseetRequest nasjonalMuseetRequest = nasjonalMuseetRestRequestBuilder.buildQuery(timeInHours, weatherResponse);

        final Optional<List<NasjonalMuseetResponse>> nasjonalMuseetResponse = nasjonalMuseetService.search(nasjonalMuseetRequest);

        if (nasjonalMuseetResponse.isPresent()) {
            searchResponse.setMuseet(nasjonalMuseetResponse.get());
        }

        return of(searchResponse);
    }

}
