package dev.lsrezende.gobots.apis.weather_talk.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

public enum WTEntityType {
    CITY("city"),
    TIME("time");

    private final String code;

    WTEntityType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public WTEntityType getByCode(String code) throws Exception {
        boolean founded = Arrays.stream(WTEntityType.values())
                .anyMatch(wtEntityType -> Objects.equals(wtEntityType.code, code));
        if (!founded) {
            throw new Exception("Invalid code: " + code + " for enum WTEntityType");
        }
        return valueOf(code);
    }


}
