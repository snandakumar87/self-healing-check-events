
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "addresses",
    "mac"
})
public class Interface {

    @JsonProperty("name")
    private String name;
    @JsonProperty("addresses")
    private List<String> addresses = null;
    @JsonProperty("mac")
    private String mac;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("addresses")
    public List<String> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
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
