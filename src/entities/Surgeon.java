package entities;

import java.util.ArrayList;

public class Surgeon extends Doctor {

    private int surgeriesPerformed;
    private boolean operationTheatreAccess;
    private ArrayList upcomingSurgeryDates;

    public Surgeon(String id, String firstName, String lastName,
                   String dateOfBirth, String gender, String phoneNumber,
                   String email, String address, String nationalId,
                   int age, boolean activeStatus,
                   String specialization, int experienceYears,
                   double consultationFee, boolean isOnCall,
                   int surgeriesPerformed,
                   boolean operationTheatreAccess) {

        super(id, firstName, lastName,
                dateOfBirth, gender, phoneNumber,
                email, address, nationalId,
                age, activeStatus,
                specialization, experienceYears,
                consultationFee, isOnCall);

        if (surgeriesPerformed < 0) {
            throw new IllegalArgumentException(
                    "Surgeries performed cannot be negative."
            );
        }

        this.surgeriesPerformed = surgeriesPerformed;
        this.operationTheatreAccess = operationTheatreAccess;
        this.upcomingSurgeryDates = new ArrayList();
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public boolean hasOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {

        if (surgeriesPerformed < 0) {
            throw new IllegalArgumentException(
                    "Surgeries performed cannot be negative."
            );
        }

        this.surgeriesPerformed = surgeriesPerformed;
    }

    public void setOperationTheatreAccess(
            boolean operationTheatreAccess) {

        this.operationTheatreAccess = operationTheatreAccess;
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("========================================");
        System.out.println("           SURGEON DETAILS              ");
        System.out.println("========================================");

        System.out.println("Surgeries Performed:     "
                + surgeriesPerformed);

        System.out.println("Operation Theatre Access: "
                + operationTheatreAccess);

        System.out.println("Upcoming Surgeries:      "
                + upcomingSurgeryDates);

        System.out.println("Upcoming Surgery Count:  "
                + getUpcomingCount());

        System.out.println("========================================");
    }

    public void performSurgery() {

        setSurgeriesPerformed(surgeriesPerformed + 1);
    }

    public void scheduleSurgery(String surgeryDate) {

        if (surgeryDate == null || surgeryDate.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Surgery date cannot be empty."
            );
        }

        upcomingSurgeryDates.add(surgeryDate);
    }

    public int getUpcomingCount() {

        return upcomingSurgeryDates.size();
    }
}