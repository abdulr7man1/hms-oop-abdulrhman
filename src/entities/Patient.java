
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

        this.allergies = new ArrayList();
        this.recordIds = new ArrayList();
        this.outstandingBalance = 0.0;
        this.isInsured = false;
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
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setRegistrationDate(String registrationDate) {

        if (registrationDate == null || registrationDate.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Registration date cannot be empty."
            );
        }

        this.registrationDate = registrationDate;
    }

    public void setOutstandingBalance(double outstandingBalance) {

        if (outstandingBalance < 0) {
            throw new IllegalArgumentException(
                    "Outstanding balance cannot be negative."
            );
        }

        this.outstandingBalance = outstandingBalance;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("========================================");
        System.out.println("             PATIENT DETAILS            ");
        System.out.println("========================================");

        System.out.println("Blood Group:         " + bloodGroup);
        System.out.println("Emergency Contact:   " + emergencyContact);
        System.out.println("Registration Date:   " + registrationDate);
        System.out.println("Outstanding Balance: " + outstandingBalance);
        System.out.println("Insured:             " + isInsured);

        System.out.println("========================================");
    }
    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    public boolean hasAllergy(String allergy) {
        return allergies.contains(allergy);
    }

    public void listAllergies() {

        System.out.println("Allergies:");

        if (allergies.isEmpty()) {
            System.out.println("No allergies recorded.");
        } else {

            for (Object allergy : allergies) {
                System.out.println("- " + allergy);
            }
        }
    }
    public void addRecordId(String recordId) {
        recordIds.add(recordId);
    }

    public int getRecordCount() {
        return recordIds.size();
    }




























}


