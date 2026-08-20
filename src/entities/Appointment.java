package entities;

import interfaces.Displayable;

public class Appointment implements Displayable {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private boolean isFollowUp;
    private String notes;
    public Appointment(String appointmentId, String patientId,
                       String doctorId, String appointmentDate,
                       String appointmentTime, String status,
                       String reason, boolean isFollowUp) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.isFollowUp = isFollowUp;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public boolean isFollowUp() {
        return isFollowUp;
    }

    public void setAppointmentId(String appointmentId) {

        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Appointment ID cannot be empty."
            );
        }

        this.appointmentId = appointmentId;
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

    public void setAppointmentDate(String appointmentDate) {

        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Appointment date cannot be empty."
            );
        }

        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setStatus(String status) {

        if (status == null ||
                (!status.equalsIgnoreCase("Scheduled")
                        && !status.equalsIgnoreCase("Cancelled")
                        && !status.equalsIgnoreCase("Completed")
                        && !status.equalsIgnoreCase("Rescheduled"))) {

            throw new IllegalArgumentException(
                    "Status must be Scheduled, Cancelled, Completed, or Rescheduled."
            );
        }

        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setFollowUp(boolean followUp) {
        isFollowUp = followUp;
    }

    public void displayInfo() {

        System.out.println("========================================");
        System.out.println("            APPOINTMENT DETAILS         ");
        System.out.println("========================================");

        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID:     " + patientId);
        System.out.println("Doctor ID:      " + doctorId);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Status:         " + status);
        System.out.println("Reason:         " + reason);
        System.out.println("Follow Up:      " + isFollowUp);

        System.out.println("========================================");
    }

    @Override
    public void displaySummary() {

    }

    public void cancel() {

        status = "Cancelled";
    }

    public void complete() {

        status = "Completed";
    }


    public void reschedule(String newDate, String newTime) {

        appointmentDate = newDate;
        appointmentTime = newTime;
        status = "Rescheduled";
    }


    public boolean isPast(String givenDate) {

        return appointmentDate.compareTo(givenDate) < 0;
    }


    public void addNotes(String notes) {

        if (notes == null || notes.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Notes cannot be empty."
            );
        }

        if (this.notes.isEmpty()) {
            this.notes = notes;
        } else {
            this.notes = this.notes + "\n" + notes;
        }
    }

    public void addNotes(String notes, String author) {

        if (notes == null || notes.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Notes cannot be empty."
            );
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Author cannot be empty."
            );
        }

        String newNote = author + ": " + notes;

        if (this.notes.isEmpty()) {
            this.notes = newNote;
        } else {
            this.notes = this.notes + "\n" + newNote;
        }
    }
}