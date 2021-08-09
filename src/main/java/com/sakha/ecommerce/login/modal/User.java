package com.sakha.ecommerce.login.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User {
//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
//https://jasonwatmore.com/post/2018/05/23/angular-6-jwt-authentication-example-tutorial#authentication-service-ts
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="email_id")
    private String emailId;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    public User() {}
    public User(int id, String emailId, String userName, String password) {
        super();
        this.id = id;
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
    @Override
    public String toString() {
        return "User [id=" + id + ", emailId=" + emailId + ", userName=" + userName + ", password=" + password + "]";
    }
    
    
    
}
