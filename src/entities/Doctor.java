package entities;

import java.util.ArrayList;
public class Doctor extends Person {

    // Task 1.3 - Doctor Attributes
    private String specialization;
    private int experienceYears;
    private double consultationFee;
    private ArrayList availableSlots;
    private ArrayList assignedPatientIds;
    private boolean isOnCall;

    public Doctor(String id, String firstName, String lastName,
                  String dateOfBirth, String gender, String phoneNumber,
                  String email, String address, String nationalId,
                  int age, boolean activeStatus,
                  String specialization, int experienceYears,
                  double consultationFee, boolean isOnCall) {

        super(id, firstName, lastName, dateOfBirth, gender,
                phoneNumber, email, address, nationalId,
                age, activeStatus);

        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.consultationFee = consultationFee;
        this.availableSlots = new ArrayList();
        this.assignedPatientIds = new ArrayList();
        this.isOnCall = isOnCall;
    }



























}
