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
    public String getDepartmentId() {
        return departmentId;
    }

    public String getShift() {
        return shift;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }
    public void setDepartmentId(String departmentId) {

        if (departmentId == null || departmentId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Department ID cannot be empty."
            );
        }

        this.departmentId = departmentId;
    }
    public void setShift(String shift) {

        if (shift == null ||
                (!shift.equalsIgnoreCase("Morning")
                        && !shift.equalsIgnoreCase("Evening")
                        && !shift.equalsIgnoreCase("Night"))) {

            throw new IllegalArgumentException(
                    "Shift must be Morning, Evening, or Night."
            );
        }

        this.shift = shift;
    }
    public void setYearsOfService(int yearsOfService) {

        if (yearsOfService < 0) {
            throw new IllegalArgumentException(
                    "Years of service cannot be negative."
            );
        }

        this.yearsOfService = yearsOfService;
    }
    public void assignPatient(String patientId) {

        if (!assignedPatientIds.contains(patientId)) {
            assignedPatientIds.add(patientId);
        }
    }

    public void unassignPatient(String patientId) {

        assignedPatientIds.remove(patientId);
    }

    public int getPatientLoad() {

        return assignedPatientIds.size();
    }
    public boolean isNightShift() {

        return shift.equalsIgnoreCase("Night");
    }



























}