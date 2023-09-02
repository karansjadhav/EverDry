package com.example.everdry;

public class AdminProducts {
    private String c_id;
    private String c_pid;
    private String c_product_image;
    private String c_name;
    private String c_mobile;
    private String c_address;
    private String c_product;
    private String c_delivery;
    private String c_payment;
    private String c_price;

    public AdminProducts()  {

    }

    public AdminProducts(String c_id, String c_pid, String c_product_image, String c_name, String c_mobile, String c_address, String c_product, String c_delivery, String c_payment, String c_price) {
        this.c_id = c_id;
        this.c_pid = c_pid;
        this.c_product_image = c_product_image;
        this.c_name = c_name;
        this.c_mobile = c_mobile;
        this.c_address = c_address;
        this.c_product = c_product;
        this.c_delivery = c_delivery;
        this.c_payment = c_payment;
        this.c_price = c_price;
    }

    public String getC_id() {
        return c_id;
    }

    public String getC_pid() {
        return c_pid;
    }

    public String getC_product_image() {
        return c_product_image;
    }

    public String getC_name() {
        return c_name;
    }

    public String getC_mobile() {
        return c_mobile;
    }

    public String getC_address() {
        return c_address;
    }

    public String getC_product() {
        return c_product;
    }

    public String getC_delivery() {
        return c_delivery;
    }

    public String getC_payment() {
        return c_payment;
    }

    public String getC_price() {
        return c_price;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public void setC_pid(String c_pid) {
        this.c_pid = c_pid;
    }

    public void setC_product_image(String c_product_image) {
        this.c_product_image = c_product_image;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setC_mobile(String c_mobile) {
        this.c_mobile = c_mobile;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public void setC_product(String c_product) {
        this.c_product = c_product;
    }

    public void setC_delivery(String c_delivery) {
        this.c_delivery = c_delivery;
    }

    public void setC_payment(String c_payment) {
        this.c_payment = c_payment;
    }

    public void setC_price(String c_price) {
        this.c_price = c_price;
    }
}
