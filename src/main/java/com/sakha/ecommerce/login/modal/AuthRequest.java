package com.sakha.ecommerce.login.modal;

public class AuthRequest {

    private String userName;
    private String password;
    
    public AuthRequest() {
     
    }
    
    public AuthRequest(String userName, String password) {
        super();
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
