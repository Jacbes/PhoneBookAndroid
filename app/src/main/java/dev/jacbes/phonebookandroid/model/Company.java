package dev.jacbes.phonebookandroid.model;

public class Company extends User {

    private String organization;

    public Company(String organization, String phone, String address) {
        super(phone, address);
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + getId() + '\'' +
                ", organization='" + getOrganization() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    public void call() {
        System.out.println("Calling to organization " + organization + " brr brr...");
    }
}
