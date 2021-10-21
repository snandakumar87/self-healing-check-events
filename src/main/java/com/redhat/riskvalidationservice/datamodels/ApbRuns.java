package com.redhat.riskvalidationservice.datamodels;

import java.util.ArrayList;
import java.util.List;

public class ApbRuns {

    private long runDate;
    private String checkName;
    private String hostName;
    private String apbName;

    public ApbRuns(){
        this.runningList = new ArrayList<>();
    }

    private List<ApbRuns> runningList;

    public List<ApbRuns> getRunningList() {
        return runningList;
    }

    public void setRunningList(List<ApbRuns> runningList) {
        this.runningList = runningList;
    }

    public long getRunDate() {
        return runDate;
    }

    public void setRunDate(long runDate) {
        this.runDate = runDate;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getApbName() {
        return apbName;
    }

    public void setApbName(String apbName) {
        this.apbName = apbName;
    }

    @Override
    public String toString() {
        return "ApbRuns{" +
                "runDate=" + runDate +
                ", checkName='" + checkName + '\'' +
                ", hostName='" + hostName + '\'' +
                ", apbName='" + apbName + '\'' +
                '}';
    }
}
