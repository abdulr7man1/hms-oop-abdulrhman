
package entities;

import interfaces.Displayable;

import java.util.Objects;

public class Person implements Displayable {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private int age;
    private boolean activeStatus;

    public Person(String id, String firstName, String lastName,
                  String dateOfBirth, String gender, String phoneNumber,
                  String email, String address, String nationalId,
                  int age, boolean activeStatus) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.nationalId = nationalId;
        this.age = age;
        this.activeStatus = activeStatus;
    }

    public Person(String id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = "";
        this.gender = "";
        this.phoneNumber = "";
        this.email = "";
        this.address = "";
        this.nationalId = "";
        this.age = 0;
        this.activeStatus = true;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public int getAge() {
        return age;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }









}





