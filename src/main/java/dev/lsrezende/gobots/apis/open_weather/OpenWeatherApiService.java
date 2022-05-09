package dev.lsrezende.gobots.apis.open_weather;

import dev.lsrezende.gobots.apis.open_weather.json.OWCurrentResponse;
import dev.lsrezende.gobots.apis.open_weather.json.OWGeocodingResponse;
import dev.lsrezende.gobots.exceptions.HttpStatusException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Service
public class OpenWeatherApiService implements OpenWeatherApi {

    @Value("${open-api-token}")
    private String apiKey;

    public OpenWeatherApiService() {
    }

    @PostConstruct
    private void postConstruct() {
        Assert.notNull(apiKey, "There is no api key to use with open weather api!");
    }

    public OWGeocodingResponse latLongByCityName(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OWGeocodingResponse[]> responseEntity = restTemplate
                .getForEntity(
                        "https://api.openweathermap.org/geo/1.0/direct?q={city-name}&appid={api-token}&lang=pt_br&units=metric",
                        OWGeocodingResponse[].class,
                        cityName,
                        apiKey
                );
        if (!responseEntity.getStatusCode().is2xxSuccessful())
            throw new HttpStatusException("Não foi possível se conectar a api de geolocalização!", HttpStatus.INTERNAL_SERVER_ERROR);
        return Objects.requireNonNull(responseEntity.getBody())[0];
    }

    public OWCurrentResponse getCurrentWeatherData(OWGeocodingResponse owGeocodingResponse) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OWCurrentResponse> responseEntity = restTemplate
                .getForEntity(
                        "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&lang=pt_br&units=metric&appid={api-token}",
                        OWCurrentResponse.class,
                        owGeocodingResponse.getLat(),
                        owGeocodingResponse.getLon(),
                        apiKey
                );
        if (!responseEntity.getStatusCode().is2xxSuccessful())
            throw new HttpStatusException("Não foi possível se conectar a api de clima!", HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity.getBody();
    }
}
