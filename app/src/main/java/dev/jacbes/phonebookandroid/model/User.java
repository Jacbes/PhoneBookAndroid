package dev.jacbes.phonebookandroid.model;

public class User {

    private static Long iterator = 1L;

    private final Long id;
    private String phone;
    private String address;

    public User(String phone, String address) {
        this.id = iterator++;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
