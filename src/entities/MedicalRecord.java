package entities;

import interfaces.Displayable;

public class MedicalRecord implements Displayable {
    private String recordId;
    private String patientId;
    private String doctorId;
    private String visitDate;
    private String diagnosis;
    private String prescription;
    private String notes;
    private boolean isConfidential;

    public MedicalRecord(String recordId, String patientId,
                         String doctorId, String visitDate,
                         String diagnosis, String prescription,
                         String notes, boolean isConfidential) {

        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
        this.isConfidential = isConfidential;
    }
    public String getRecordId() {
        return recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isConfidential() {
        return isConfidential;
    }
    public void setRecordId(String recordId) {

        if (recordId == null || recordId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Record ID cannot be empty."
            );
        }

        this.recordId = recordId;
    }
    public void setPatientId(String patientId) {

        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Patient ID cannot be empty."
            );
        }

        this.patientId = patientId;
    }
    public void setDoctorId(String doctorId) {

        if (doctorId == null || doctorId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Doctor ID cannot be empty."
            );
        }

        this.doctorId = doctorId;
    }
    public void setVisitDate(String visitDate) {

        if (visitDate == null || visitDate.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Visit date cannot be empty."
            );
        }

        this.visitDate = visitDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setConfidential(boolean confidential) {
        isConfidential = confidential;
    }
    public void displayInfo() {

        System.out.println("========================================");
        System.out.println("           MEDICAL RECORD               ");
        System.out.println("========================================");

        System.out.println("Record ID:      " + recordId);
        System.out.println("Patient ID:     " + patientId);
        System.out.println("Doctor ID:      " + doctorId);
        System.out.println("Visit Date:     " + visitDate);
        System.out.println("Diagnosis:      " + diagnosis);
        System.out.println("Prescription:   " + prescription);
        System.out.println("Notes:          " + notes);
        System.out.println("Confidential:   " + isConfidential);

        System.out.println("========================================");
    }
    @Override
    public void displaySummary() {

        System.out.println(
                "Record ID: " + recordId +
                        " | Patient ID: " + patientId +
                        " | Visit Date: " + visitDate +
                        " | Diagnosis: " + diagnosis
        );
    }
    public void appendNote(String extraNote) {

        if (notes == null || notes.isEmpty()) {
            notes = extraNote;
        } else {
            notes = notes + " " + extraNote;
        }
    }








































}
