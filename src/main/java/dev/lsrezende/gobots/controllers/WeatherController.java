package dev.lsrezende.gobots.controllers;

import dev.lsrezende.gobots.apis.open_weather.json.OWCurrentResponse;
import dev.lsrezende.gobots.dto.JsonResponseDTO;
import dev.lsrezende.gobots.services.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping
    public ResponseEntity<JsonResponseDTO> weatherInfo(@RequestBody String message) {
        return new ResponseEntity<>(JsonResponseDTO.ok(weatherService.getWeatherInfo(message)), HttpStatus.OK);
    }
}
