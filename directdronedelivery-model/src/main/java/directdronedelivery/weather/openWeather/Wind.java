package directdronedelivery.weather.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Wind {

    @JsonProperty
    @Getter protected double speed;

    @JsonProperty
    @Getter protected int deg;

}
