package dev.lsrezende.gobots.apis.weather_talk.json;

public class WTIntentJson {
    private String name;
    private Double confidence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
