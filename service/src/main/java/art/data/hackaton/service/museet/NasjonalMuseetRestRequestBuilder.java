package art.data.hackaton.service.museet;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NasjonalMuseetRestRequestBuilder {

    /**
     * If it is morning or evening in hours, I ask for that otherwise I ask based on weather condition
     */
    public NasjonalMuseetRequest buildQuery(int hour, Optional<WeatherResponse> weatherResponse) {

        NasjonalMuseetRequest nasjonalMuseetRequest = new NasjonalMuseetRequest();

        List<String> terms = new ArrayList<>();

        terms.addAll(addPhasesOfDay(hour));

        if (terms.isEmpty()) {
            terms.addAll(getWeatherConditions(weatherResponse.get()));
        }

        nasjonalMuseetRequest.setValues(terms);

        return nasjonalMuseetRequest;
    }

    private List<String> getWeatherConditions(WeatherResponse weatherResponse) {
        String condition = weatherResponse.getCondition();

        // todo parse english weather conditions to norwegian synonyms

        List<String> searchTermConditions = new ArrayList<>();

        return searchTermConditions;
    }

    private List<String> addPhasesOfDay(int hour) {
        if (hour <= 9) {
            return asList("morgen", "soloppgang");
        } else if (hour >= 18) {
            return asList("kveld", "solnedgang");
        }

        return emptyList();
    }
}
