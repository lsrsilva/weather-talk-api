package dev.lsrezende.gobots.apis.open_weather.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OWCurrentResponse {
    private OWCoordCurrent coord;
    private List<OWWeather> weather;
    private String base;
    private OWMain main;
    private Long visibility;
    private OWWind wind;
    private OWClouds clouds;
    private Long dt;
    private Long timezone;

    public OWCoordCurrent getCoord() {
        return coord;
    }

    public void setCoord(OWCoordCurrent coord) {
        this.coord = coord;
    }

    public List<OWWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<OWWeather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public OWMain getMain() {
        return main;
    }

    public void setMain(OWMain main) {
        this.main = main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public OWWind getWind() {
        return wind;
    }

    public void setWind(OWWind wind) {
        this.wind = wind;
    }

    public OWClouds getClouds() {
        return clouds;
    }

    public void setClouds(OWClouds clouds) {
        this.clouds = clouds;
    }

    public LocalDateTime getDt() {
        return Instant.ofEpochSecond(dt).atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OWCoordCurrent {
        private Double lon;
        private Double lat;

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OWWeather {
        private String main;
        private String description;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OWMain {
        private Double temp;

        @JsonAlias("feels_like")
        @JsonProperty("feelsLike")
        private Double feelsLike;
        @JsonAlias("temp_min")
        @JsonProperty("tempMin")
        private Double tempMin;
        @JsonAlias("temp_max")
        @JsonProperty("tempMax")
        private Double tempMax;
        private Double pressure;
        private Double humidity;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(Double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OWWind {
        private Double speed;
        private Integer deg;

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Integer getDeg() {
            return deg;
        }

        public void setDeg(Integer deg) {
            this.deg = deg;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OWClouds {
        private Integer all;

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }
    }
}
