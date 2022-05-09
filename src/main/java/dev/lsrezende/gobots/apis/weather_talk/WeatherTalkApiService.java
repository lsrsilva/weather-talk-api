package dev.lsrezende.gobots.apis.weather_talk;

import dev.lsrezende.gobots.apis.weather_talk.json.WTModelParseBody;
import dev.lsrezende.gobots.apis.weather_talk.json.WeatherTalkJson;
import dev.lsrezende.gobots.exceptions.HttpStatusException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherTalkApiService implements WeatherTalkApi {

    public WeatherTalkJson getDataByMessage(String text) {
        WTModelParseBody modelParseBody = new WTModelParseBody(text);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<WTModelParseBody> body = new HttpEntity<>(modelParseBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherTalkJson> responseEntity = restTemplate.postForEntity(
                "https://weathertalk.gobots.com.br/model/parse",
                body,
                WeatherTalkJson.class
        );
        if (!responseEntity.getStatusCode().is2xxSuccessful())
            throw new HttpStatusException("Não foi possível se conectar a api de PNL!", HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity.getBody();
    }

}
