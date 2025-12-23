package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class AssetStatusUpdateRequest {

    @NotBlank(message = "Status is required")
    private String status;

    public AssetStatusUpdateRequest() {
    }

    public AssetStatusUpdateRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
