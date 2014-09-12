package directdronedelivery.weather.openWeather;

import directdronedelivery.weather.Weather;
import directdronedelivery.weather.WeatherService;
import directdronedelivery.weather.openWeather.OpenWeatherService;
import junit.framework.TestCase;
import org.junit.Test;

public class OpenWeatherServiceTest extends TestCase {

    WeatherService weatherService;

    @Override
    public void setUp() throws Exception {
        weatherService = new OpenWeatherService();
    }

    @Test
    public void testGetActualWeather() throws Exception {
        //given
        String location = "Wroclaw, PL";

        //when
        Weather weather = weatherService.getActualWeather(location);

        //then
        System.out.println(weather);
    }
}