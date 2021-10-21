
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fatigue_check/interval",
    "wiki",
    "summary",
    "fatigue_check/occurrences"
})
public class Annotations {

    @JsonProperty("fatigue_check/interval")
    private String fatigueCheckInterval;
    @JsonProperty("wiki")
    private String wiki;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("fatigue_check/occurrences")
    private String fatigueCheckOccurrences;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fatigue_check/interval")
    public String getFatigueCheckInterval() {
        return fatigueCheckInterval;
    }

    @JsonProperty("fatigue_check/interval")
    public void setFatigueCheckInterval(String fatigueCheckInterval) {
        this.fatigueCheckInterval = fatigueCheckInterval;
    }

    @JsonProperty("wiki")
    public String getWiki() {
        return wiki;
    }

    @JsonProperty("wiki")
    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("fatigue_check/occurrences")
    public String getFatigueCheckOccurrences() {
        return fatigueCheckOccurrences;
    }

    @JsonProperty("fatigue_check/occurrences")
    public void setFatigueCheckOccurrences(String fatigueCheckOccurrences) {
        this.fatigueCheckOccurrences = fatigueCheckOccurrences;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
