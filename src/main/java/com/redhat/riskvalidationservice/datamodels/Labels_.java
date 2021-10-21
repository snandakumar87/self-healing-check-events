
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app_subtier",
    "app_tier",
    "appid",
    "cluster",
    "datacenter",
    "environment",
    "region",
    "sensuenv"
})
public class Labels_ {

    @JsonProperty("app_subtier")
    private String appSubtier;
    @JsonProperty("app_tier")
    private String appTier;
    @JsonProperty("appid")
    private String appid;
    @JsonProperty("cluster")
    private String cluster;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("environment")
    private String environment;
    @JsonProperty("region")
    private String region;
    @JsonProperty("sensuenv")
    private String sensuenv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("app_subtier")
    public String getAppSubtier() {
        return appSubtier;
    }

    @JsonProperty("app_subtier")
    public void setAppSubtier(String appSubtier) {
        this.appSubtier = appSubtier;
    }

    @JsonProperty("app_tier")
    public String getAppTier() {
        return appTier;
    }

    @JsonProperty("app_tier")
    public void setAppTier(String appTier) {
        this.appTier = appTier;
    }

    @JsonProperty("appid")
    public String getAppid() {
        return appid;
    }

    @JsonProperty("appid")
    public void setAppid(String appid) {
        this.appid = appid;
    }

    @JsonProperty("cluster")
    public String getCluster() {
        return cluster;
    }

    @JsonProperty("cluster")
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    @JsonProperty("environment")
    public String getEnvironment() {
        return environment;
    }

    @JsonProperty("environment")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("sensuenv")
    public String getSensuenv() {
        return sensuenv;
    }

    @JsonProperty("sensuenv")
    public void setSensuenv(String sensuenv) {
        this.sensuenv = sensuenv;
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
