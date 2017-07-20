
package fr.app.geolocalisation;


import com.google.api.client.util.Key;

import java.util.HashMap;
import java.util.Map;

public class Sys {

    @Key private String pod;

    @Key
    private String country;
    @Key
    private Integer sunrise;
    @Key
    private Integer sunset;
    @Key
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
