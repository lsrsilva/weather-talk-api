package dev.lsrezende.gobots.apis.weather_talk;

import dev.lsrezende.gobots.apis.weather_talk.json.WeatherTalkJson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class WeatherTalkApiServiceTest {

    @Autowired
    private WeatherTalkApi weatherTalkApi;

    @Test
    public void getDataByMessage() {
        WeatherTalkJson weatherTalkJson = weatherTalkApi.getDataByMessage("Qual o clima de anápolis para hoje?");
    }

}
