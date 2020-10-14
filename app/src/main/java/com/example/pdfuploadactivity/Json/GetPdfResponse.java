package com.example.pdfuploadactivity.Json;

import java.util.List;

public class GetPdfResponse {
    private  String status;
    private GetPdfData item;

    public GetPdfResponse(String status, GetPdfData item) {
        this.status = status;
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public GetPdfData getItem() {
        return item;
    }
}
