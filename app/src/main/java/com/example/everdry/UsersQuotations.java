package com.example.everdry;

public class UsersQuotations {

    private String userid;
    private String qid;
    private String name;
    private String mobile_number;
    private String email;
    private String construction;
    private String part;
    private String coat;
    private String location;
    private String area;
    private String quality;
    private String address;
    private String cost;

    public UsersQuotations(String userid, String qid, String name, String mobile_number, String email, String construction, String part, String coat, String location, String area, String quality, String address, String cost) {
        this.userid = userid;
        this.qid = qid;
        this.name = name;
        this.mobile_number = mobile_number;
        this.email = email;
        this.construction = construction;
        this.part = part;
        this.coat = coat;
        this.location = location;
        this.area = area;
        this.quality = quality;
        this.address = address;
        this.cost = cost;
    }

    public UsersQuotations() {
    }

    public void setUid(String userid) {
        this.userid = userid;
    }

    public void setUqid(String qid) {
        this.qid = qid;
    }

    public void setUName(String name) {
        this.name = name;
    }

    public void setUMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setUEmail(String email) {
        this.email = email;
    }

    public void setUConstruction(String construction) {
        this.construction = construction;
    }

    public void setUPart(String part) {
        this.part = part;
    }

    public void setUCoat(String coat) {
        this.coat = coat;
    }

    public void setULocation(String location) {
        this.location = location;
    }

    public void setUArea(String area) {
        this.area = area;
    }

    public void setUQuality(String quality) {
        this.quality = quality;
    }

    public void setUAddress(String address) {
        this.address = address;
    }

    public void setUCost(String cost) {
        this.cost = cost;
    }

    public String getUid() {
        return userid;
    }

    public String getUqid() {
        return qid;
    }

    public String getUName() {
        return name;
    }

    public String getUMobile_number() {
        return mobile_number;
    }

    public String getUEmail() {
        return email;
    }

    public String getUConstruction() {
        return construction;
    }

    public String getUPart() {
        return part;
    }

    public String getUCoat() {
        return coat;
    }

    public String getULocation() {
        return location;
    }

    public String getUArea() {
        return area;
    }

    public String getUQuality() {
        return quality;
    }

    public String getUAddress() {
        return address;
    }

    public String getUCost() {
        return cost;
    }

}

