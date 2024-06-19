package com.example.projekt.api.model;

public class Meta {
    private String createdAt;
    private  String updatedAt;
    private String barcode;
    private String qrCode;

    public Meta(){

    }

    public Meta(String createdAt, String updatedAt, String barcode, String qrCode) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.barcode = barcode;
        this.qrCode = qrCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", barcode='" + barcode + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
