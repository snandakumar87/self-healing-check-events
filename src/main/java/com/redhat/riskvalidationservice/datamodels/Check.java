
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "command",
    "handlers",
    "high_flap_threshold",
    "interval",
    "low_flap_threshold",
    "publish",
    "runtime_assets",
    "subscriptions",
    "proxy_entity_name",
    "check_hooks",
    "stdin",
    "subdue",
    "ttl",
    "timeout",
    "round_robin",
    "duration",
    "executed",
    "history",
    "issued",
    "output",
    "state",
    "status",
    "total_state_change",
    "last_ok",
    "occurrences",
    "occurrences_watermark",
    "output_metric_format",
    "output_metric_handlers",
    "env_vars",
    "metadata",
    "secrets"
})
public class Check {

    @JsonProperty("command")
    private String command;
    @JsonProperty("handlers")
    private List<String> handlers = null;
    @JsonProperty("high_flap_threshold")
    private Integer highFlapThreshold;
    @JsonProperty("interval")
    private Integer interval;
    @JsonProperty("low_flap_threshold")
    private Integer lowFlapThreshold;
    @JsonProperty("publish")
    private Boolean publish;
    @JsonProperty("runtime_assets")
    private List<String> runtimeAssets = null;
    @JsonProperty("subscriptions")
    private List<String> subscriptions = null;
    @JsonProperty("proxy_entity_name")
    private String proxyEntityName;
    @JsonProperty("check_hooks")
    private Object checkHooks;
    @JsonProperty("stdin")
    private Boolean stdin;
    @JsonProperty("subdue")
    private Object subdue;
    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("timeout")
    private Integer timeout;
    @JsonProperty("round_robin")
    private Boolean roundRobin;
    @JsonProperty("duration")
    private Double duration;
    @JsonProperty("executed")
    private Long executed;
    @JsonProperty("history")
    private List<History> history = null;
    @JsonProperty("issued")
    private Integer issued;
    @JsonProperty("output")
    private String output;
    @JsonProperty("state")
    private String state;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("total_state_change")
    private Integer totalStateChange;
    @JsonProperty("last_ok")
    private Integer lastOk;
    @JsonProperty("occurrences")
    private Integer occurrences;
    @JsonProperty("occurrences_watermark")
    private Integer occurrencesWatermark;
    @JsonProperty("output_metric_format")
    private String outputMetricFormat;
    @JsonProperty("output_metric_handlers")
    private Object outputMetricHandlers;
    @JsonProperty("env_vars")
    private Object envVars;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("secrets")
    private Object secrets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("command")
    public String getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(String command) {
        this.command = command;
    }

    @JsonProperty("handlers")
    public List<String> getHandlers() {
        return handlers;
    }

    @JsonProperty("handlers")
    public void setHandlers(List<String> handlers) {
        this.handlers = handlers;
    }

    @JsonProperty("high_flap_threshold")
    public Integer getHighFlapThreshold() {
        return highFlapThreshold;
    }

    @JsonProperty("high_flap_threshold")
    public void setHighFlapThreshold(Integer highFlapThreshold) {
        this.highFlapThreshold = highFlapThreshold;
    }

    @JsonProperty("interval")
    public Integer getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @JsonProperty("low_flap_threshold")
    public Integer getLowFlapThreshold() {
        return lowFlapThreshold;
    }

    @JsonProperty("low_flap_threshold")
    public void setLowFlapThreshold(Integer lowFlapThreshold) {
        this.lowFlapThreshold = lowFlapThreshold;
    }

    @JsonProperty("publish")
    public Boolean getPublish() {
        return publish;
    }

    @JsonProperty("publish")
    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    @JsonProperty("runtime_assets")
    public List<String> getRuntimeAssets() {
        return runtimeAssets;
    }

    @JsonProperty("runtime_assets")
    public void setRuntimeAssets(List<String> runtimeAssets) {
        this.runtimeAssets = runtimeAssets;
    }

    @JsonProperty("subscriptions")
    public List<String> getSubscriptions() {
        return subscriptions;
    }

    @JsonProperty("subscriptions")
    public void setSubscriptions(List<String> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @JsonProperty("proxy_entity_name")
    public String getProxyEntityName() {
        return proxyEntityName;
    }

    @JsonProperty("proxy_entity_name")
    public void setProxyEntityName(String proxyEntityName) {
        this.proxyEntityName = proxyEntityName;
    }

    @JsonProperty("check_hooks")
    public Object getCheckHooks() {
        return checkHooks;
    }

    @JsonProperty("check_hooks")
    public void setCheckHooks(Object checkHooks) {
        this.checkHooks = checkHooks;
    }

    @JsonProperty("stdin")
    public Boolean getStdin() {
        return stdin;
    }

    @JsonProperty("stdin")
    public void setStdin(Boolean stdin) {
        this.stdin = stdin;
    }

    @JsonProperty("subdue")
    public Object getSubdue() {
        return subdue;
    }

    @JsonProperty("subdue")
    public void setSubdue(Object subdue) {
        this.subdue = subdue;
    }

    @JsonProperty("ttl")
    public Integer getTtl() {
        return ttl;
    }

    @JsonProperty("ttl")
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    @JsonProperty("timeout")
    public Integer getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("round_robin")
    public Boolean getRoundRobin() {
        return roundRobin;
    }

    @JsonProperty("round_robin")
    public void setRoundRobin(Boolean roundRobin) {
        this.roundRobin = roundRobin;
    }

    @JsonProperty("duration")
    public Double getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @JsonProperty("executed")
    public Long getExecuted() {
        return executed;
    }

    @JsonProperty("executed")
    public void setExecuted(Long executed) {
        this.executed = executed;
    }

    @JsonProperty("history")
    public List<History> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<History> history) {
        this.history = history;
    }

    @JsonProperty("issued")
    public Integer getIssued() {
        return issued;
    }

    @JsonProperty("issued")
    public void setIssued(Integer issued) {
        this.issued = issued;
    }

    @JsonProperty("output")
    public String getOutput() {
        return output;
    }

    @JsonProperty("output")
    public void setOutput(String output) {
        this.output = output;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("total_state_change")
    public Integer getTotalStateChange() {
        return totalStateChange;
    }

    @JsonProperty("total_state_change")
    public void setTotalStateChange(Integer totalStateChange) {
        this.totalStateChange = totalStateChange;
    }

    @JsonProperty("last_ok")
    public Integer getLastOk() {
        return lastOk;
    }

    @JsonProperty("last_ok")
    public void setLastOk(Integer lastOk) {
        this.lastOk = lastOk;
    }

    @JsonProperty("occurrences")
    public Integer getOccurrences() {
        return occurrences;
    }

    @JsonProperty("occurrences")
    public void setOccurrences(Integer occurrences) {
        this.occurrences = occurrences;
    }

    @JsonProperty("occurrences_watermark")
    public Integer getOccurrencesWatermark() {
        return occurrencesWatermark;
    }

    @JsonProperty("occurrences_watermark")
    public void setOccurrencesWatermark(Integer occurrencesWatermark) {
        this.occurrencesWatermark = occurrencesWatermark;
    }

    @JsonProperty("output_metric_format")
    public String getOutputMetricFormat() {
        return outputMetricFormat;
    }

    @JsonProperty("output_metric_format")
    public void setOutputMetricFormat(String outputMetricFormat) {
        this.outputMetricFormat = outputMetricFormat;
    }

    @JsonProperty("output_metric_handlers")
    public Object getOutputMetricHandlers() {
        return outputMetricHandlers;
    }

    @JsonProperty("output_metric_handlers")
    public void setOutputMetricHandlers(Object outputMetricHandlers) {
        this.outputMetricHandlers = outputMetricHandlers;
    }

    @JsonProperty("env_vars")
    public Object getEnvVars() {
        return envVars;
    }

    @JsonProperty("env_vars")
    public void setEnvVars(Object envVars) {
        this.envVars = envVars;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("secrets")
    public Object getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(Object secrets) {
        this.secrets = secrets;
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
