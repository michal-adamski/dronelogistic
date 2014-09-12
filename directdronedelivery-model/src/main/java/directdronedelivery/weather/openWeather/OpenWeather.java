package directdronedelivery.weather.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import directdronedelivery.weather.Weather;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeather extends Weather {

    protected OpenWeather() {
    }

    @Override
    @JsonProperty("temp")
    public int getTemperatureInCelsius() {
        return super.getTemperatureInCelsius();
    }

    @Override
    @JsonProperty("humidity")
    public int getHumidityInPercent() {
        return super.getHumidityInPercent();
    }

    @JsonSetter("weather")
    private void setLightningAndRainPossibilities(List<Condition> conditions) {
        for (Condition condition : conditions) {
            if(condition.canLighten()){
                lightningsPossible = true;
            }
            if(condition.canRain()){
                precipitationPossible = true;
            }
        }
    }

    @JsonSetter("wind")
    private void setWindConditions(Wind wind) {
        this.windInPMS = wind.getSpeed();
    }

    @JsonSetter("main")
    private void setMainConditions(OpenWeather weather) {
        this.temperatureInCelsius = weather.temperatureInCelsius;
        this.humidityInPercent = weather.humidityInPercent;
    }
}
