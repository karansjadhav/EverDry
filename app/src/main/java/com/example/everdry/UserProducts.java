package com.example.everdry;

public class UserProducts {
    private String p_id;
    private String p_name;
    private String p_offer;
    private String p_delivery;
    private String p_payment;
    private String p_address;
    private String p_price;
    private String P_image;

    public UserProducts() {

    }

    public UserProducts(String p_id, String p_name, String p_offer, String p_delivery, String p_payment, String p_address, String p_price, String p_image) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_offer = p_offer;
        this.p_delivery = p_delivery;
        this.p_payment = p_payment;
        this.p_address = p_address;
        this.p_price = p_price;
        this.P_image = p_image;
    }

    public String getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_offer() {
        return p_offer;
    }

    public String getP_delivery() {
        return p_delivery;
    }

    public String getP_payment() {
        return p_payment;
    }

    public String getP_address() {
        return p_address;
    }

    public String getP_price() {
        return p_price;
    }

    public String getP_image() {
        return P_image;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setP_offer(String p_offer) {
        this.p_offer = p_offer;
    }

    public void setP_delivery(String p_delivery) {
        this.p_delivery = p_delivery;
    }

    public void setP_payment(String p_payment) {
        this.p_payment = p_payment;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public void setP_image(String p_image) {
        P_image = p_image;
    }
}
