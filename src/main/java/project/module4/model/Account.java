package project.module4.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    private Long userId;
    private String userName;
    private String email;
    private String fullName;
    private String password;
    private boolean roll;
    private String address;
    private String phoneNumber;
    private boolean status;
    private Date createAt;
    private Date updateAt;

    public Account() {
    }

    public Account(Long userId, String userName, String email, String fullName, String password, boolean roll, String address, String phoneNumber, boolean status, Date createAt, Date updateAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.roll = roll;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Account(String userName, String email, String password, String address, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRoll() {
        return roll;
    }

    public void setRoll(boolean roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return new Date();
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return new Date();
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
