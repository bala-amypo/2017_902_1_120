package com.example.demo.dto;

public class ApiKeyUsageSummaryDto {

    private Long apiKeyId;
    private int totalRequestsToday;
    private int dailyLimit;
    private boolean limitExceeded;

    public ApiKeyUsageSummaryDto() {
    }

    public ApiKeyUsageSummaryDto(Long apiKeyId,
                                 int totalRequestsToday,
                                 int dailyLimit,
                                 boolean limitExceeded) {
        this.apiKeyId = apiKeyId;
        this.totalRequestsToday = totalRequestsToday;
        this.dailyLimit = dailyLimit;
        this.limitExceeded = limitExceeded;
    }

    public Long getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(Long apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public int getTotalRequestsToday() {
        return totalRequestsToday;
    }

    public void setTotalRequestsToday(int totalRequestsToday) {
        this.totalRequestsToday = totalRequestsToday;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public boolean isLimitExceeded() {
        return limitExceeded;
    }

    public void setLimitExceeded(boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
    }
}
