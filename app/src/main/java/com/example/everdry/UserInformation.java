package com.example.everdry;

public class UserInformation {

    private String userName;
    private String userMobileNumber;
    private String userEmail;
    private String userPassword;
    private String count;

    public UserInformation(String userName, String userMobileNumber, String userEmail, String userPassword, String count) {
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.count = count;
    }

    public UserInformation() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

