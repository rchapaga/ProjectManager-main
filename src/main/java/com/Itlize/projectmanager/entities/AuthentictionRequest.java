package com.Itlize.projectmanager.entities;

public class AuthentictionRequest {

    private String userName;
    private String password;

    public AuthentictionRequest() {
    }

    public AuthentictionRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
