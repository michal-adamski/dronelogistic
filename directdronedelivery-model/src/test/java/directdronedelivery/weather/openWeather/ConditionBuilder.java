package directdronedelivery.weather.openWeather;

import directdronedelivery.weather.Weather;
import directdronedelivery.weather.WeatherBuilder;

/**
 * Created by michal on 9/12/14.
 */
public class ConditionBuilder {

    private Condition underConstruction = null;

    public static ConditionBuilder aCondition() {
        ConditionBuilder builder = new ConditionBuilder();
        builder.underConstruction = new Condition();
        return builder;
    }

    public ConditionBuilder likeThunderstormConditions() {
        underConstruction.id = 211;
        underConstruction.description = "thunderstorm";
        underConstruction.main = "thunderstorm";
        return this;
    }

    public ConditionBuilder likeRainConditions() {
        underConstruction.id = 521;
        underConstruction.description = "shower rain";
        underConstruction.main = "shower rain";
        return this;
    }

    public ConditionBuilder but() {
        return this;
    }

    public ConditionBuilder withConditionId(int conditionId) {
        underConstruction.id = conditionId;
        return this;
    }

    public Condition build() {
        Condition builded = underConstruction;
        underConstruction = new Condition();
        return builded;
    }


}
