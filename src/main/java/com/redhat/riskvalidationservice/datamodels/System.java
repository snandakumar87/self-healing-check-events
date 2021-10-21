
package com.redhat.riskvalidationservice.datamodels;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostname",
    "os",
    "platform",
    "platform_family",
    "platform_version",
    "network",
    "arch",
    "libc_type",
    "vm_system",
    "vm_role",
    "cloud_provider",
    "processes"
})
public class System {

    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("os")
    private String os;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("platform_family")
    private String platformFamily;
    @JsonProperty("platform_version")
    private String platformVersion;
    @JsonProperty("network")
    private Network network;
    @JsonProperty("arch")
    private String arch;
    @JsonProperty("libc_type")
    private String libcType;
    @JsonProperty("vm_system")
    private String vmSystem;
    @JsonProperty("vm_role")
    private String vmRole;
    @JsonProperty("cloud_provider")
    private String cloudProvider;
    @JsonProperty("processes")
    private Object processes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("os")
    public String getOs() {
        return os;
    }

    @JsonProperty("os")
    public void setOs(String os) {
        this.os = os;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("platform_family")
    public String getPlatformFamily() {
        return platformFamily;
    }

    @JsonProperty("platform_family")
    public void setPlatformFamily(String platformFamily) {
        this.platformFamily = platformFamily;
    }

    @JsonProperty("platform_version")
    public String getPlatformVersion() {
        return platformVersion;
    }

    @JsonProperty("platform_version")
    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    @JsonProperty("network")
    public Network getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(Network network) {
        this.network = network;
    }

    @JsonProperty("arch")
    public String getArch() {
        return arch;
    }

    @JsonProperty("arch")
    public void setArch(String arch) {
        this.arch = arch;
    }

    @JsonProperty("libc_type")
    public String getLibcType() {
        return libcType;
    }

    @JsonProperty("libc_type")
    public void setLibcType(String libcType) {
        this.libcType = libcType;
    }

    @JsonProperty("vm_system")
    public String getVmSystem() {
        return vmSystem;
    }

    @JsonProperty("vm_system")
    public void setVmSystem(String vmSystem) {
        this.vmSystem = vmSystem;
    }

    @JsonProperty("vm_role")
    public String getVmRole() {
        return vmRole;
    }

    @JsonProperty("vm_role")
    public void setVmRole(String vmRole) {
        this.vmRole = vmRole;
    }

    @JsonProperty("cloud_provider")
    public String getCloudProvider() {
        return cloudProvider;
    }

    @JsonProperty("cloud_provider")
    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    @JsonProperty("processes")
    public Object getProcesses() {
        return processes;
    }

    @JsonProperty("processes")
    public void setProcesses(Object processes) {
        this.processes = processes;
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
