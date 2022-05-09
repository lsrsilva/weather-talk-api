package dev.lsrezende.gobots.services;

import dev.lsrezende.gobots.apis.open_weather.OpenWeatherApi;
import dev.lsrezende.gobots.apis.open_weather.json.OWCurrentResponse;
import dev.lsrezende.gobots.apis.open_weather.json.OWGeocodingResponse;
import dev.lsrezende.gobots.apis.weather_talk.WeatherTalkApi;
import dev.lsrezende.gobots.apis.weather_talk.enums.WTEntityType;
import dev.lsrezende.gobots.apis.weather_talk.json.WTEntityJson;
import dev.lsrezende.gobots.apis.weather_talk.json.WeatherTalkJson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Objects;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherTalkApi weatherTalkApiService;
    private final OpenWeatherApi openWeatherApiService;

    public WeatherService(WeatherTalkApi weatherTalkApiService, OpenWeatherApi openWeatherApiService) {
        this.weatherTalkApiService = weatherTalkApiService;
        this.openWeatherApiService = openWeatherApiService;
    }

    public OWCurrentResponse getWeatherInfo(String message) {
        WeatherTalkJson weatherTalkJson = weatherTalkApiService.getDataByMessage(message);
        Optional<WTEntityJson> wtEntityJson = Objects.requireNonNull(weatherTalkJson).getEntities()
                .stream().filter(wtEj -> wtEj.getEntity().equals(WTEntityType.CITY)).findAny();
        if (wtEntityJson.isPresent()) {
            String cityName = (String) wtEntityJson.get().getValue();
            OWGeocodingResponse owGeocodingResponse = openWeatherApiService.latLongByCityName(cityName);
            OWCurrentResponse owCurrentResponse = openWeatherApiService.getCurrentWeatherData(owGeocodingResponse);
            return owCurrentResponse;
        }
        throw HttpServerErrorException.create(HttpStatus.NOT_FOUND, "", new HttpHeaders(), null, null);
    }

}
