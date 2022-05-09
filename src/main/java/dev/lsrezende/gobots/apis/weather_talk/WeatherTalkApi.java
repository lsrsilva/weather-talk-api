package dev.lsrezende.gobots.apis.weather_talk;

import dev.lsrezende.gobots.apis.weather_talk.json.WeatherTalkJson;

public interface WeatherTalkApi {
    WeatherTalkJson getDataByMessage(String text);
}
