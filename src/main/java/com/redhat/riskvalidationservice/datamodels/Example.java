
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "check",
    "entity",
    "id",
    "metadata",
    "timestamp"
})
public class Example {

    Example(){

    }

    @JsonProperty("check")
    private Check check;
    @JsonProperty("entity")
    private Entity entity;
    @JsonProperty("id")
    private String id;
    @JsonProperty("metadata")
    private Metadata__ metadata;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("check")
    public Check getCheck() {
        return check;
    }

    @JsonProperty("check")
    public void setCheck(Check check) {
        this.check = check;
    }

    @JsonProperty("entity")
    public Entity getEntity() {
        return entity;
    }

    @JsonProperty("entity")
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("metadata")
    public Metadata__ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__ metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
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
