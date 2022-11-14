package dev.jacbes.phonebookandroid.model;

public class Person extends User {

    private String firstName;
    private String secondName;

    public Person(String firstName, String secondName, String phone, String address) {
        super(phone, address);
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", secondName='" + getSecondName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    public void call() {
        System.out.println("Calling to person " + getFirstName() + " " + getSecondName() + " brr brr...");
    }
}
