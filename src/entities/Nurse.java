package entities;

import java.util.ArrayList;

public class Nurse extends Person {

    private String departmentId;
    private String shift;
    private ArrayList assignedPatientIds;
    private int yearsOfService;
    public Nurse(String id, String firstName, String lastName,
                 String dateOfBirth, String gender, String phoneNumber,
                 String email, String address, String nationalId,
                 int age, boolean activeStatus,
                 String departmentId, String shift,
                 int yearsOfService) {

        super(id, firstName, lastName, dateOfBirth, gender,
                phoneNumber, email, address, nationalId,
                age, activeStatus);

        this.departmentId = departmentId;
        this.shift = shift;
        this.assignedPatientIds = new ArrayList();
        this.yearsOfService = yearsOfService;
    }
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("========================================");
        System.out.println("             NURSE DETAILS              ");
        System.out.println("========================================");

        System.out.println("Department ID:     " + departmentId);
        System.out.println("Shift:             " + shift);
        System.out.println("Assigned Patients: " + assignedPatientIds);
        System.out.println("Years of Service:  " + yearsOfService);

        System.out.println("========================================");
    }



























}