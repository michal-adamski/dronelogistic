package directdronedelivery.weather.openWeather;

import com.fasterxml.jackson.databind.ObjectMapper;
import directdronedelivery.weather.Weather;
import directdronedelivery.weather.WeatherService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Getting current weather conditions from openweathermap.org api.
 *
 * documentation: http://openweathermap.org/current
 * example: http://api.openweathermap.org/data/2.5/weather?q=Wroclaw,PL&lang=pl&units=metric
 */
@Stateless
@LocalBean
public class OpenWeatherService implements WeatherService {

    @Override
    public Weather getActualWeather(String location) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("api.openweathermap.org")
                .setPath("/data/2.5/weather")
                .setParameter("q", location)
                .setParameter("lang", "pl")
                .setParameter("units", "metric");


        HttpGet currentWeatherRequest = new HttpGet(tryBuildURI(uriBuilder));
        currentWeatherRequest.addHeader("accept", "application/json");
        HttpResponse response = tryExecuteRequest(httpClient, currentWeatherRequest);

        Weather weather = tryParseWeather(response);
        return weather;
    }

    private OpenWeather tryParseWeather(HttpResponse response){
        try {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }
            InputStreamReader responseReader = new InputStreamReader((response.getEntity().getContent()));
            return new ObjectMapper().readValue(responseReader, OpenWeather.class);
        } catch (IOException e) {
            throw new RuntimeException("IOException reading ");
        }
    }

    private HttpResponse tryExecuteRequest(HttpClient httpClient, HttpGet getRequest) {
        try {
            return httpClient.execute(getRequest);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't execute call to Weather API: %s", e);
        }
    }

    private URI tryBuildURI(URIBuilder uriBuilder) {
        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Couldn't build Weather API URI: %s", e);
        }
    }

}
