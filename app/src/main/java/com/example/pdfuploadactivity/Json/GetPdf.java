package com.example.pdfuploadactivity.Json;

public class GetPdf {
    private String invoice_id;
    private String item_name;
    private String quantity;
    private String price;

    public GetPdf(String invoice_id, String item_name, String quantity, String price) {
        this.invoice_id = invoice_id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }
}
