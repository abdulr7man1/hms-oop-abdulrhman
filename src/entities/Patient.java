package entities;

import java.util.ArrayList;

public class Patient extends Person {

    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;

    private ArrayList allergies;
    private ArrayList recordIds;

    private double outstandingBalance;
    private boolean isInsured;

    public Patient(String id, String firstName, String lastName,
                   String dateOfBirth, String gender, String phoneNumber,
                   String email, String address, String nationalId,
                   int age, boolean activeStatus,
                   String bloodGroup, String emergencyContact,
                   String registrationDate, double outstandingBalance,
                   boolean isInsured) {

        super(id, firstName, lastName, dateOfBirth, gender,
                phoneNumber, email, address, nationalId,
                age, activeStatus);

        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.allergies = new ArrayList();
        this.recordIds = new ArrayList();
        this.outstandingBalance = outstandingBalance;
        this.isInsured = isInsured;
    }

    public Patient(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public boolean isInsured() {
        return isInsured;
    }















}