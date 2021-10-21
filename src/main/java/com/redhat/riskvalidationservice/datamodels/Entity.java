
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entity_class",
    "system",
    "subscriptions",
    "last_seen",
    "deregister",
    "deregistration",
    "user",
    "redact",
    "metadata",
    "sensu_agent_version"
})
public class Entity {

    @JsonProperty("entity_class")
    private String entityClass;
    @JsonProperty("system")
    private System system;
    @JsonProperty("subscriptions")
    private List<String> subscriptions = null;
    @JsonProperty("last_seen")
    private Integer lastSeen;
    @JsonProperty("deregister")
    private Boolean deregister;
    @JsonProperty("deregistration")
    private Deregistration deregistration;
    @JsonProperty("user")
    private String user;
    @JsonProperty("redact")
    private List<String> redact = null;
    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonProperty("sensu_agent_version")
    private String sensuAgentVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("entity_class")
    public String getEntityClass() {
        return entityClass;
    }

    @JsonProperty("entity_class")
    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    @JsonProperty("system")
    public System getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(System system) {
        this.system = system;
    }

    @JsonProperty("subscriptions")
    public List<String> getSubscriptions() {
        return subscriptions;
    }

    @JsonProperty("subscriptions")
    public void setSubscriptions(List<String> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @JsonProperty("last_seen")
    public Integer getLastSeen() {
        return lastSeen;
    }

    @JsonProperty("last_seen")
    public void setLastSeen(Integer lastSeen) {
        this.lastSeen = lastSeen;
    }

    @JsonProperty("deregister")
    public Boolean getDeregister() {
        return deregister;
    }

    @JsonProperty("deregister")
    public void setDeregister(Boolean deregister) {
        this.deregister = deregister;
    }

    @JsonProperty("deregistration")
    public Deregistration getDeregistration() {
        return deregistration;
    }

    @JsonProperty("deregistration")
    public void setDeregistration(Deregistration deregistration) {
        this.deregistration = deregistration;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("redact")
    public List<String> getRedact() {
        return redact;
    }

    @JsonProperty("redact")
    public void setRedact(List<String> redact) {
        this.redact = redact;
    }

    @JsonProperty("metadata")
    public Metadata_ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("sensu_agent_version")
    public String getSensuAgentVersion() {
        return sensuAgentVersion;
    }

    @JsonProperty("sensu_agent_version")
    public void setSensuAgentVersion(String sensuAgentVersion) {
        this.sensuAgentVersion = sensuAgentVersion;
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
