package com.example.everdry;

public class Quotation {

    private String construction;
    private String part;
    private String coat;
    private String location;
    private String area;
    private String quality;
    private String address;
    private String cost;
    private String qid;

    public Quotation() {

    }

    public Quotation(String construction, String part, String coat, String location, String area, String quality, String address, String cost, String qid) {
        this.construction = construction;
        this.part = part;
        this.coat = coat;
        this.location = location;
        this.area = area;
        this.quality = quality;
        this.address = address;
        this.cost = cost;
        this.qid = qid;
    }

    public String getConstruction() {
        return construction;
    }

    public String getPart() {
        return part;
    }

    public String getCoat() {
        return coat;
    }

    public String getLocation() {
        return location;
    }

    public String getArea() {
        return area;
    }

    public String getQuality() {
        return quality;
    }

    public String getAddress() {
        return address;
    }

    public String getCost() {
        return cost;
    }

    public String getQId() {
        return qid;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setQId(String qid) {
        this.qid = qid;
    }
}
