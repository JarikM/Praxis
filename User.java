package utils;

import org.apache.commons.lang3.RandomStringUtils;

import javax.jws.soap.SOAPBinding;

public class User {
    private String email;
    private String password;

    private String gender = "Mr.";
    private String firstName = "John";
    private String lastName = "Connor";
    private String address = "Unknown str.";
    private String houseNumber = "21";
    private String street = "Unknown";
    private String postCode = "1234AB";

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /* (1) alternative to setters
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
    */
}
