package dev.lsrezende.gobots.apis.weather_talk.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.lsrezende.gobots.apis.weather_talk.enums.WTEntityType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WTEntityJson {
    private String text;
    private WTEntityType entity;
    private Object value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WTEntityType getEntity() {
        return entity;
    }

    public void setEntity(WTEntityType entity) {
        this.entity = entity;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
