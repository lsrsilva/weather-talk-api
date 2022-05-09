package dev.lsrezende.gobots.apis.weather_talk.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherTalkJson {

    private WTIntentJson intent;
    private List<WTEntityJson> entities;

    public WTIntentJson getIntent() {
        return intent;
    }

    public void setIntent(WTIntentJson intent) {
        this.intent = intent;
    }

    public List<WTEntityJson> getEntities() {
        return entities;
    }

    public void setEntities(List<WTEntityJson> entities) {
        this.entities = entities;
    }
}
