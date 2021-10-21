package com.redhat.riskvalidationservice.datamodels;

import java.util.List;

public class LogAggregator {
    private List<String> logs;

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }
}
