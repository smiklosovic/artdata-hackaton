package art.data.hackaton.service;

import art.data.hackaton.configuration.DefaultTestAnnotations;
import art.data.hackaton.service.weather.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultTestAnnotations
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testWeatherService() {

    }
}
