
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












}





