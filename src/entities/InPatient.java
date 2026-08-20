package entities;

public class InPatient extends Patient {

    private String admissionDate;
    private String roomNumber;
    private double dailyCharges;
    private int daysAdmitted;
    private boolean admitted;

    public InPatient(String id, String firstName, String lastName,
                     String dateOfBirth, String gender, String phoneNumber,
                     String email, String address, String nationalId,
                     int age, boolean activeStatus,
                     String bloodGroup, String emergencyContact,
                     String registrationDate, double outstandingBalance,
                     boolean isInsured,
                     String admissionDate, String roomNumber,
                     double dailyCharges, int daysAdmitted) {

        super(id, firstName, lastName,
                dateOfBirth, gender, phoneNumber,
                email, address, nationalId,
                age, activeStatus,
                bloodGroup, emergencyContact,
                registrationDate, outstandingBalance,
                isInsured);

        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;

        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);

        this.admitted = false;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public void setAdmissionDate(String admissionDate) {

        if (admissionDate == null || admissionDate.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Admission date cannot be empty."
            );
        }

        this.admissionDate = admissionDate;
    }

    public void setRoomNumber(String roomNumber) {

        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Room number cannot be empty."
            );
        }

        this.roomNumber = roomNumber;
    }

    public void setDailyCharges(double dailyCharges) {

        if (dailyCharges < 0) {
            throw new IllegalArgumentException(
                    "Daily charges cannot be negative."
            );
        }

        this.dailyCharges = dailyCharges;
    }

    public void setDaysAdmitted(int daysAdmitted) {

        if (daysAdmitted < 0) {
            throw new IllegalArgumentException(
                    "Days admitted cannot be negative."
            );
        }

        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("========================================");
        System.out.println("           INPATIENT DETAILS            ");
        System.out.println("========================================");

        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Room Number:    " + roomNumber);
        System.out.println("Daily Charges:  " + dailyCharges);
        System.out.println("Days Admitted:  " + daysAdmitted);
        System.out.println("Admitted:       " + admitted);
        System.out.println("Total Room Cost: " + totalRoomCost());

        System.out.println("========================================");
    }

    public void admit(String admissionDate, String roomNumber) {

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);

        admitted = true;
        daysAdmitted = 0;
    }

    public void discharge() {

        admitted = false;
        daysAdmitted = 0;
        admissionDate = "";
        roomNumber = "";
    }

    public double totalRoomCost() {

        return dailyCharges * daysAdmitted;
    }
}