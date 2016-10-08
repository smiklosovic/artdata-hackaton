package art.data.hackaton.service;

import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.NasjonalMuseetResponse;
import art.data.hackaton.model.SearchRequest;
import art.data.hackaton.model.SearchResponse;
import art.data.hackaton.model.WeatherResponse;
import art.data.hackaton.service.museet.NasjonalMuseetRestRequestBuilder;
import art.data.hackaton.service.museet.NasjonalMuseetService;
import art.data.hackaton.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private NasjonalMuseetService nasjonalMuseetService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private NasjonalMuseetRestRequestBuilder nasjonalMuseetRestRequestBuilder;

    public Optional<SearchResponse> search() {

        NasjonalMuseetRequest nasjonalMuseetRequest = nasjonalMuseetRestRequestBuilder.buildQuery(new SearchRequest());

        Optional<NasjonalMuseetResponse> nasjonalMuseetResponse = nasjonalMuseetService.search(nasjonalMuseetRequest);

        Optional<WeatherResponse> weatherResponse = weatherService.search();

        SearchResponse searchResponse = new SearchResponse();

        if (nasjonalMuseetResponse.isPresent()) {
            searchResponse.setMuseet(nasjonalMuseetResponse.get());
        }

        if (weatherResponse.isPresent()) {
            searchResponse.setWeather(weatherResponse.get());
        }

        return Optional.of(searchResponse);
    }

}
