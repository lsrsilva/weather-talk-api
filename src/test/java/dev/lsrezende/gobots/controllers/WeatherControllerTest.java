package dev.lsrezende.gobots.controllers;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private final Logger LOG = LoggerFactory.getLogger(WeatherControllerTest.class);

    @Test
    void resetPassword() throws Exception {
        LOG.info("1. Get weather info test start:");
        mockMvc.perform(
                post("/weather")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("qual a temperatura no próximo domingo em Campinas?")
        ).andExpect(status().isOk()).andReturn();
        LOG.info("2. Get weather info test end!");
    }

}
