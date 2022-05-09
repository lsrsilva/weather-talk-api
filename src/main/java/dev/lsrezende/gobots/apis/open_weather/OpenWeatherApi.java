package dev.lsrezende.gobots.apis.open_weather;

import dev.lsrezende.gobots.apis.open_weather.json.OWCurrentResponse;
import dev.lsrezende.gobots.apis.open_weather.json.OWGeocodingResponse;

public interface OpenWeatherApi {
    OWGeocodingResponse latLongByCityName(String cityName);

    OWCurrentResponse getCurrentWeatherData(OWGeocodingResponse owGeocodingResponse);
}
