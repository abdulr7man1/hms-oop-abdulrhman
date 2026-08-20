
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

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) {
            throw new IllegalArgumentException("Date of birth cannot be empty.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException(
                    "Age must be between 0 and 120."
            );
        }
        this.age = age;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void displayInfo() {

        System.out.println("========================================");
        System.out.println("            PERSON INFORMATION          ");
        System.out.println("========================================");

        System.out.println("ID:            " + id);
        System.out.println("First Name:    " + firstName);
        System.out.println("Last Name:     " + lastName);
        System.out.println("Full Name:     " + getFullName());
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender:        " + gender);
        System.out.println("Phone Number:  " + phoneNumber);
        System.out.println("Email:         " + email);
        System.out.println("Address:       " + address);
        System.out.println("National ID:   " + nationalId);
        System.out.println("Age:           " + age);
        System.out.println("Active Status: " + activeStatus);

        System.out.println("========================================");
    }










}





