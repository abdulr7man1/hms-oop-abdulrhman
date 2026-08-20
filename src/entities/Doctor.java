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
    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public boolean isOnCall() {
        return isOnCall;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setExperienceYears(int experienceYears) {

        if (experienceYears < 0) {
            throw new IllegalArgumentException(
                    "Experience years cannot be negative."
            );
        }

        this.experienceYears = experienceYears;
    }

    public void setConsultationFee(double consultationFee) {

        if (consultationFee < 0) {
            throw new IllegalArgumentException(
                    "Consultation fee cannot be negative."
            );
        }

        this.consultationFee = consultationFee;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("========================================");
        System.out.println("              DOCTOR DETAILS            ");
        System.out.println("========================================");

        System.out.println("Specialization:      " + specialization);
        System.out.println("Experience Years:    " + experienceYears);
        System.out.println("Consultation Fee:    " + consultationFee);
        System.out.println("Available Slots:     " + availableSlots);
        System.out.println("Assigned Patients:   " + assignedPatientIds);
        System.out.println("On Call:             " + isOnCall);

        System.out.println("========================================");
    }
    public void addSlot(String slot) {

        if (!availableSlots.contains(slot)) {
            availableSlots.add(slot);
        }
    }

    public void removeSlot(String slot) {

        availableSlots.remove(slot);
    }

    public boolean hasSlot(String slot) {

        return availableSlots.contains(slot);
    }
    public void assignPatient(String patientId) {

        if (!assignedPatientIds.contains(patientId)) {
            assignedPatientIds.add(patientId);
        }
    }

    public int getPatientLoad() {

        return assignedPatientIds.size();
    }
    public void raiseFee(double amount) {

        if (amount > 0) {
            consultationFee = consultationFee + amount;
        }
    }
    public void updateFee(double fee) {

        setConsultationFee(fee);
    }

    public void updateFee(double fee, String reason) {

        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Reason cannot be empty."
            );
        }

        setConsultationFee(fee);

        System.out.println("Consultation fee updated.");
        System.out.println("Reason: " + reason);
    }




























}
