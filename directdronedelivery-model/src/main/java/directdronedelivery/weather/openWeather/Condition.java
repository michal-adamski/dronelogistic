package directdronedelivery.weather.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * See http://openweathermap.org/weather-conditions for weather codes
 */
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {

    @JsonProperty
    @Getter protected Integer id;

    @JsonProperty
    @Getter protected String main;

    @JsonProperty
    @Getter protected String description;

    public boolean canLighten(){
        return id != null && idInRange(200, 299);
    }

    public boolean canRain() {
        return id != null && (idInRange(200, 399) || idInRange(500, 699));
    }

    private boolean idInRange(int from, int to) {
        return id >= from && id <= to;
    }
}
