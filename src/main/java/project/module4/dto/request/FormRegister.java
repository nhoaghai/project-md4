package project.module4.dto.request;

public class FormRegister {
    private String userName;
    private String password;
    private String rePassword;
    private String address;
    private String email;
    private String fullName;
    private String phoneNumber;

    public FormRegister() {
    }

    public FormRegister(String userName, String password, String rePassword, String email, String fullName) {
        this.userName = userName;
        this.password = password;
        this.rePassword = rePassword;
        this.email = email;
        this.fullName = fullName;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
