package com.example.pdfuploadactivity.Json;

import com.example.pdfuploadactivity.Json.GetPdf;

import java.util.List;

public class GetPdfData {
    private List<GetPdf> data;
    private String business_name;
    private String business_address;
    private String user_mobile;
    private String user_email;
    private String user_gst;

    public String getUser_gst() {
        return user_gst;
    }

    public GetPdfData(String user_gst) {

        this.user_gst = user_gst;
    }

    private String customer_name;
    private String cutomer_mobile;
    private String cutomer_email;
    private String customer_address;
    private String customer_gst;

    public GetPdfData(List<GetPdf> data, String business_name, String business_address, String user_mobile, String user_email, String customer_name,
                      String cutomer_mobile, String cutomer_email, String customer_address, String customer_gst) {
        this.data = data;
        this.business_name = business_name;
        this.business_address = business_address;
        this.user_mobile = user_mobile;
        this.user_email = user_email;
        this.customer_name = customer_name;
        this.cutomer_mobile = cutomer_mobile;
        this.cutomer_email = cutomer_email;
        this.customer_address = customer_address;
        this.customer_gst = customer_gst;
    }

    public List<GetPdf> getData() {
        return data;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public String getBusiness_address() {
        return business_address;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCutomer_mobile() {
        return cutomer_mobile;
    }

    public String getCutomer_email() {
        return cutomer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public String getCustomer_gst() {
        return customer_gst;
    }
}
