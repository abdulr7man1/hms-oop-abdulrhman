
import entities.*;
import services.*;
import utils.HelperUtils;
import utils.InputHandler;

import java.util.ArrayList;

public class HospitalApp {

    private PatientService patientService;
    private DoctorService doctorService;
    private NurseService nurseService;
    private AppointmentService appointmentService;
    private RecordService recordService;

    private InputHandler input;

    private ArrayList people;
    public HospitalApp() {

        patientService = new PatientService();
        doctorService = new DoctorService();
        nurseService = new NurseService();
        appointmentService = new AppointmentService();
        recordService = new RecordService();

        input = new InputHandler();

        people = new ArrayList();
    }

    public static void main(String[] args) {

        HospitalApp app = new HospitalApp();

        app.start();
    }

    public void start() {

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = input.readInt(
                    "Choose an option: ",
                    1,
                    7
            );

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    nurseMenu();
                    break;

                case 4:
                    appointmentMenu();
                    break;

                case 5:
                    recordMenu();
                    break;

                case 6:
                    reportsMenu();
                    break;

                case 7:
                    running = false;
                    System.out.println(
                            "Thank you for using the Hospital System."
                    );
                    break;
            }
        }

        input.close();
    }
    private void displayMainMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       HOSPITAL MANAGEMENT SYSTEM       ");
        System.out.println("========================================");
        System.out.println("1. Patients");
        System.out.println("2. Doctors");
        System.out.println("3. Nurses");
        System.out.println("4. Appointments");
        System.out.println("5. Medical Records");
        System.out.println("6. Reports");
        System.out.println("7. Exit");
        System.out.println("========================================");
    }

    private void patientMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("             PATIENT MENU               ");
            System.out.println("========================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Contact");
            System.out.println("5. Remove Patient");
            System.out.println("6. List InPatients");
            System.out.println("7. Total Outstanding");
            System.out.println("8. Back");
            System.out.println("========================================");

            int choice = input.readInt(
                    "Choose an option: ",
                    1,
                    8
            );

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewAllPatients();
                    break;

                case 3:
                    searchPatients();
                    break;

                case 4:
                    updatePatientContact();
                    break;

                case 5:
                    removePatient();
                    break;

                case 6:
                    listInPatients();
                    break;

                case 7:
                    showOutstanding();
                    break;

                case 8:
                    back = true;
                    break;
            }
        }
    }

    private void addPatient() {

        System.out.println();
        System.out.println("--- Add Patient ---");

        String id = input.readText("ID: ");
        String firstName = input.readText("First name: ");
        String lastName = input.readText("Last name: ");

        String bloodGroup = input.readText(
                "Blood group: "
        );

        Patient patient =
                patientService.addPatient(
                        id,
                        firstName,
                        lastName,
                        bloodGroup
                );

        people.add(patient);

        System.out.println(
                "Patient added successfully."
        );
    }
    private void viewAllPatients() {

        Object[] patients =
                patientService.getAll();

        if (patients.length == 0) {

            System.out.println(
                    "No patients found."
            );

            return;
        }

        for (Object object : patients) {

            Patient patient =
                    (Patient) object;

            patient.displayInfo();
        }
    }

    private void searchPatients() {

        String keyword =
                input.readText("Search keyword: ");

        Object[] results =
                patientService.search(keyword);

        if (results.length == 0) {

            System.out.println(
                    "No patients found."
            );

            return;
        }

        for (Object object : results) {

            Patient patient =
                    (Patient) object;

            patient.displaySummary();
        }
    }
    private void updatePatientContact() {

        String id =
                input.readText("Patient ID: ");

        String phone =
                input.readText("New phone number: ");

        boolean updateEmail =
                input.readConfirmation(
                        "Do you want to update email?"
                );

        boolean success;

        if (updateEmail) {

            String email =
                    input.readText("New email: ");

            success =
                    patientService.updateContact(
                            id,
                            phone,
                            email
                    );

        } else {

            success =
                    patientService.updateContact(
                            id,
                            phone
                    );
        }

        if (success) {

            System.out.println(
                    "Contact updated successfully."
            );

        } else {

            System.out.println(
                    "Patient not found."
            );
        }
    }

    private void removePatient() {

        String id =
                input.readText("Patient ID: ");

        boolean removed =
                patientService.removeById(id);

        if (removed) {

            removePersonById(id);

            System.out.println(
                    "Patient removed successfully."
            );

        } else {

            System.out.println(
                    "Patient not found."
            );
        }
    }
    private void listInPatients() {

        Object[] results =
                patientService.listInPatients();

        if (results.length == 0) {

            System.out.println(
                    "No InPatients found."
            );

            return;
        }

        for (Object object : results) {

            InPatient patient =
                    (InPatient) object;

            patient.displayInfo();
        }
    }
    private void showOutstanding() {

        double total =
                patientService.totalOutstanding();

        System.out.println(
                "Total outstanding balance: "
                        + total
        );
    }
    private void doctorMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("              DOCTOR MENU               ");
            System.out.println("========================================");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Remove Doctor");
            System.out.println("5. Add Surgeon");
            System.out.println("6. Assign Patient");
            System.out.println("7. List By Specialization");
            System.out.println("8. Available Doctors");
            System.out.println("9. Back");
            System.out.println("========================================");

            int choice =
                    input.readInt(
                            "Choose an option: ",
                            1,
                            9
                    );

            switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    viewAllDoctors();
                    break;

                case 3:
                    searchDoctors();
                    break;

                case 4:
                    removeDoctor();
                    break;

                case 5:
                    addSurgeon();
                    break;

                case 6:
                    assignDoctorPatient();
                    break;

                case 7:
                    listDoctorsBySpecialization();
                    break;

                case 8:
                    listAvailableDoctors();
                    break;

                case 9:
                    back = true;
                    break;
            }
        }
    }

    private void addDoctor() {

        String id =
                input.readText("ID: ");

        String firstName =
                input.readText("First name: ");

        String lastName =
                input.readText("Last name: ");

        String specialization =
                input.readText("Specialization: ");

        int experience =
                input.readInt(
                        "Experience years: ",
                        0,
                        120
                );

        double fee =
                input.readDouble(
                        "Consultation fee: "
                );

        Doctor doctor =
                new Doctor(
                        id,
                        firstName,
                        lastName,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        0,
                        true,
                        specialization,
                        experience,
                        fee,
                        false
                );

        doctorService.add(doctor);

        people.add(doctor);

        System.out.println(
                "Doctor added successfully."
        );
    }

    private void viewAllDoctors() {

        Object[] doctors =
                doctorService.getAll();

        if (doctors.length == 0) {

            System.out.println(
                    "No doctors found."
            );

            return;
        }

        for (Object object : doctors) {

            Doctor doctor =
                    (Doctor) object;

            doctor.displayInfo();
        }
    }
    private void searchDoctors() {

        String keyword =
                input.readText("Search keyword: ");

        Object[] results =
                doctorService.search(keyword);

        for (Object object : results) {

            Doctor doctor =
                    (Doctor) object;

            doctor.displaySummary();
        }

        if (results.length == 0) {
            System.out.println(
                    "No doctors found."
            );
        }
    }
    private void removeDoctor() {

        String id =
                input.readText("Doctor ID: ");

        boolean removed =
                doctorService.removeById(id);

        if (removed) {

            removePersonById(id);

            System.out.println(
                    "Doctor removed successfully."
            );

        } else {

            System.out.println(
                    "Doctor not found."
            );
        }
    }
    private void addSurgeon() {

        String id =
                input.readText("Surgeon ID: ");

        String firstName =
                input.readText("First name: ");

        String lastName =
                input.readText("Last name: ");

        String specialization =
                input.readText("Specialization: ");

        int experience =
                input.readInt(
                        "Experience years: ",
                        0,
                        120
                );

        double fee =
                input.readDouble(
                        "Consultation fee: "
                );

        Surgeon surgeon =
                new Surgeon(
                        id,
                        firstName,
                        lastName,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        0,
                        true,
                        specialization,
                        experience,
                        fee,
                        false,
                        0,
                        false
                );

        doctorService.addSurgeon(surgeon);

        people.add(surgeon);

        System.out.println(
                "Surgeon added successfully."
        );
    }
    private void assignDoctorPatient() {

        String doctorId =
                input.readText("Doctor ID: ");

        String patientId =
                input.readText("Patient ID: ");

        boolean success =
                doctorService.assignPatient(
                        doctorId,
                        patientId
                );

        if (success) {

            System.out.println(
                    "Patient assigned successfully."
            );

        } else {

            System.out.println(
                    "Doctor not found."
            );
        }
    }
    private void listDoctorsBySpecialization() {

        String specialization =
                input.readText(
                        "Specialization: "
                );

        Object[] results =
                doctorService.listBySpecialization(
                        specialization
                );

        for (Object object : results) {

            Doctor doctor =
                    (Doctor) object;

            doctor.displaySummary();
        }

        if (results.length == 0) {

            System.out.println(
                    "No doctors found."
            );
        }
    }

    private void listAvailableDoctors() {

        Object[] results =
                doctorService.availableDoctors();

        for (Object object : results) {

            Doctor doctor =
                    (Doctor) object;

            doctor.displaySummary();
        }

        if (results.length == 0) {

            System.out.println(
                    "No available doctors found."
            );
        }
    }
    private void nurseMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("               NURSE MENU               ");
            System.out.println("========================================");
            System.out.println("1. Add Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. Search Nurse");
            System.out.println("4. Remove Nurse");
            System.out.println("5. List By Shift");
            System.out.println("6. Reassign Patient");
            System.out.println("7. Back");
            System.out.println("========================================");

            int choice =
                    input.readInt(
                            "Choose an option: ",
                            1,
                            7
                    );

            switch (choice) {

                case 1:
                    addNurse();
                    break;

                case 2:
                    viewAllNurses();
                    break;

                case 3:
                    searchNurses();
                    break;

                case 4:
                    removeNurse();
                    break;

                case 5:
                    listNursesByShift();
                    break;

                case 6:
                    reassignNursePatient();
                    break;

                case 7:
                    back = true;
                    break;
            }
        }
    }

    private void addNurse() {

        String id =
                input.readText("ID: ");

        String firstName =
                input.readText("First name: ");

        String lastName =
                input.readText("Last name: ");

        String departmentId =
                input.readText("Department ID: ");

        String shift =
                input.readOneOf(
                        "Shift: ",
                        new Object[]{
                                "Morning",
                                "Evening",
                                "Night"
                        }
                );

        int years =
                input.readInt(
                        "Years of service: ",
                        0,
                        120
                );

        Nurse nurse =
                new Nurse(
                        id,
                        firstName,
                        lastName,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        0,
                        true,
                        departmentId,
                        shift,
                        years
                );

        nurseService.add(nurse);

        people.add(nurse);

        System.out.println(
                "Nurse added successfully."
        );
    }

    private void viewAllNurses() {

        Object[] nurses =
                nurseService.getAll();

        if (nurses.length == 0) {

            System.out.println(
                    "No nurses found."
            );

            return;
        }

        for (Object object : nurses) {

            Nurse nurse =
                    (Nurse) object;

            nurse.displayInfo();
        }
    }

    private void searchNurses() {

        String keyword =
                input.readText("Search keyword: ");

        Object[] results =
                nurseService.search(keyword);

        for (Object object : results) {

            Nurse nurse =
                    (Nurse) object;

            nurse.displaySummary();
        }

        if (results.length == 0) {

            System.out.println(
                    "No nurses found."
            );
        }
    }

    private void removeNurse() {

        String id =
                input.readText("Nurse ID: ");

        boolean removed =
                nurseService.removeById(id);

        if (removed) {

            removePersonById(id);

            System.out.println(
                    "Nurse removed successfully."
            );

        } else {

            System.out.println(
                    "Nurse not found."
            );
        }
    }

    private void listNursesByShift() {

        String shift =
                input.readOneOf(
                        "Shift: ",
                        new Object[]{
                                "Morning",
                                "Evening",
                                "Night"
                        }
                );

        Object[] results =
                nurseService.listByShift(shift);

        for (Object object : results) {

            Nurse nurse =
                    (Nurse) object;

            nurse.displaySummary();
        }

        if (results.length == 0) {

            System.out.println(
                    "No nurses found."
            );
        }
    }

    private void reassignNursePatient() {

        String oldNurse =
                input.readText(
                        "Current nurse ID: "
                );

        String newNurse =
                input.readText(
                        "New nurse ID: "
                );

        String patientId =
                input.readText(
                        "Patient ID: "
                );

        boolean success =
                nurseService.reassign(
                        oldNurse,
                        newNurse,
                        patientId
                );

        if (success) {

            System.out.println(
                    "Patient reassigned successfully."
            );

        } else {

            System.out.println(
                    "Could not reassign patient."
            );
        }
    }


    private void appointmentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("           APPOINTMENT MENU             ");
            System.out.println("========================================");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Search Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Complete Appointment");
            System.out.println("6. Reschedule Appointment");
            System.out.println("7. List By Status");
            System.out.println("8. List By Patient");
            System.out.println("9. Back");
            System.out.println("========================================");

            int choice =
                    input.readInt(
                            "Choose an option: ",
                            1,
                            9
                    );

            switch (choice) {

                case 1:
                    scheduleAppointment();
                    break;

                case 2:
                    viewAllAppointments();
                    break;

                case 3:
                    searchAppointments();
                    break;

                case 4:
                    cancelAppointment();
                    break;

                case 5:
                    completeAppointment();
                    break;

                case 6:
                    rescheduleAppointment();
                    break;

                case 7:
                    listAppointmentsByStatus();
                    break;

                case 8:
                    listAppointmentsByPatient();
                    break;

                case 9:
                    back = true;
                    break;
            }
        }
    }


    private void scheduleAppointment() {

        String appointmentId =
                input.readText("Appointment ID: ");

        String patientId =
                input.readText("Patient ID: ");

        String doctorId =
                input.readText("Doctor ID: ");

        String date =
                input.readText("Appointment date: ");

        String time =
                input.readText("Appointment time: ");

        Appointment appointment =
                appointmentService.schedule(
                        appointmentId,
                        patientId,
                        doctorId,
                        date,
                        time
                );

        System.out.println(
                "Appointment scheduled successfully."
        );
    }

    private void viewAllAppointments() {

        Object[] appointments =
                appointmentService.getAll();

        if (appointments.length == 0) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (Object object : appointments) {

            Appointment appointment =
                    (Appointment) object;

            appointment.displayInfo();
        }
    }
    private void searchAppointments() {

        String keyword =
                input.readText("Search keyword: ");

        Object[] results =
                appointmentService.search(keyword);

        for (Object object : results) {

            Appointment appointment =
                    (Appointment) object;

            appointment.displayInfo();
        }

        if (results.length == 0) {

            System.out.println(
                    "No appointments found."
            );
        }
    }
    private void cancelAppointment() {

        String id =
                input.readText(
                        "Appointment ID: "
                );

        boolean success =
                appointmentService.cancel(id);

        System.out.println(
                success
                        ? "Appointment cancelled."
                        : "Appointment not found."
        );
    }
    private void completeAppointment() {

        String id =
                input.readText(
                        "Appointment ID: "
                );

        boolean success =
                appointmentService.complete(id);

        System.out.println(
                success
                        ? "Appointment completed."
                        : "Appointment not found."
        );
    }

    private void rescheduleAppointment() {

        String id =
                input.readText(
                        "Appointment ID: "
                );

        String date =
                input.readText(
                        "New date: "
                );

        String time =
                input.readText(
                        "New time: "
                );

        boolean success =
                appointmentService.reschedule(
                        id,
                        date,
                        time
                );

        System.out.println(
                success
                        ? "Appointment rescheduled."
                        : "Appointment not found."
        );
    }

    private void listAppointmentsByStatus() {

        String status =
                input.readOneOf(
                        "Status: ",
                        new Object[]{
                                "Scheduled",
                                "Cancelled",
                                "Completed",
                                "Rescheduled"
                        }
                );

        Object[] results =
                appointmentService.listByStatus(status);

        for (Object object : results) {

            Appointment appointment =
                    (Appointment) object;

            appointment.displayInfo();
        }

        if (results.length == 0) {

            System.out.println(
                    "No appointments found."
            );
        }
    }

    private void listAppointmentsByPatient() {

        String patientId =
                input.readText(
                        "Patient ID: "
                );

        Object[] results =
                appointmentService.listByPatient(
                        patientId
                );

        for (Object object : results) {

            Appointment appointment =
                    (Appointment) object;

            appointment.displayInfo();
        }

        if (results.length == 0) {

            System.out.println(
                    "No appointments found."
            );
        }
    }

    private void recordMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("         MEDICAL RECORD MENU             ");
            System.out.println("========================================");
            System.out.println("1. Add Medical Record");
            System.out.println("2. View All Records");
            System.out.println("3. Search Record");
            System.out.println("4. Remove Record");
            System.out.println("5. List By Patient");
            System.out.println("6. Count Confidential");
            System.out.println("7. Back");
            System.out.println("========================================");

            int choice =
                    input.readInt(
                            "Choose an option: ",
                            1,
                            7
                    );

            switch (choice) {

                case 1:
                    addMedicalRecord();
                    break;

                case 2:
                    viewAllRecords();
                    break;

                case 3:
                    searchRecords();
                    break;

                case 4:
                    removeRecord();
                    break;

                case 5:
                    listRecordsByPatient();
                    break;

                case 6:
                    countConfidential();
                    break;

                case 7:
                    back = true;
                    break;
            }
        }
    }

    private void addMedicalRecord() {

        String recordId =
                input.readText("Record ID: ");

        String patientId =
                input.readText("Patient ID: ");

        String doctorId =
                input.readText("Doctor ID: ");

        String visitDate =
                input.readText("Visit date: ");

        String diagnosis =
                input.readText("Diagnosis: ");

        String prescription =
                input.readText("Prescription: ");

        String notes =
                input.readText("Notes: ");

        MedicalRecord record =
                new MedicalRecord(
                        recordId,
                        patientId,
                        doctorId,
                        visitDate,
                        diagnosis,
                        prescription,
                        notes,
                        false
                );

        recordService.add(record);

        System.out.println(
                "Medical record added successfully."
        );
    }
    private void viewAllRecords() {

        Object[] records =
                recordService.getAll();

        if (records.length == 0) {

            System.out.println(
                    "No medical records found."
            );

            return;
        }

        for (Object object : records) {

            MedicalRecord record =
                    (MedicalRecord) object;

            record.displayInfo();
        }
    }

    private void searchRecords() {

        String keyword =
                input.readText("Search keyword: ");

        Object[] results =
                recordService.search(keyword);

        for (Object object : results) {

            MedicalRecord record =
                    (MedicalRecord) object;

            record.displayInfo();
        }

        if (results.length == 0) {

            System.out.println(
                    "No records found."
            );
        }
    }

    private void removeRecord() {

        String id =
                input.readText("Record ID: ");

        boolean removed =
                recordService.removeById(id);

        System.out.println(
                removed
                        ? "Medical record removed."
                        : "Medical record not found."
        );
    }


    private void listRecordsByPatient() {

        String patientId =
                input.readText("Patient ID: ");

        Object[] results =
                recordService.listByPatient(
                        patientId
                );

        for (Object object : results) {

            MedicalRecord record =
                    (MedicalRecord) object;

            record.displayInfo();
        }

        if (results.length == 0) {

            System.out.println(
                    "No records found."
            );
        }
    }

    private void countConfidential() {

        int count =
                recordService.countConfidential();

        System.out.println(
                "Confidential records: " + count
        );
    }


    private void reportsMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("               REPORTS                  ");
        System.out.println("========================================");

        countByType();

        System.out.println(
                "Total patients: "
                        + patientService.getAll().length
        );

        System.out.println(
                "Total doctors: "
                        + doctorService.getAll().length
        );

        System.out.println(
                "Total nurses: "
                        + nurseService.getAll().length
        );

        System.out.println(
                "Total appointments: "
                        + appointmentService.getAll().length
        );

        System.out.println(
                "Total medical records: "
                        + recordService.getAll().length
        );

        System.out.println(
                "Total outstanding balance: "
                        + patientService.totalOutstanding()
        );

        System.out.println(
                "Confidential records: "
                        + recordService.countConfidential()
        );

        System.out.println(
                "Oldest person age: "
                        + findOldest()
        );

        System.out.println("========================================");
    }


    public void printAll() {

        for (Object object : people) {

            Person person =
                    (Person) object;

            person.displayInfo();
        }
    }

    public void countByType() {

        int patientCount = 0;
        int doctorCount = 0;
        int nurseCount = 0;

        int inPatientCount = 0;
        int surgeonCount = 0;

        for (Object object : people) {

            Person person =
                    (Person) object;

            if (person instanceof InPatient) {

                inPatientCount++;

            } else if (person instanceof Surgeon) {

                surgeonCount++;

            } else if (person instanceof Patient) {

                patientCount++;

            } else if (person instanceof Doctor) {

                doctorCount++;

            } else if (person instanceof Nurse) {

                nurseCount++;
            }
        }

        System.out.println(
                "Patients: " + patientCount
        );

        System.out.println(
                "Doctors: " + doctorCount
        );

        System.out.println(
                "Nurses: " + nurseCount
        );

        System.out.println(
                "InPatients: " + inPatientCount
        );

        System.out.println(
                "Surgeons: " + surgeonCount
        );
    }


    public int findOldest() {

        int oldestAge = 0;

        for (Object object : people) {

            Person person =
                    (Person) object;

            if (person.getAge() > oldestAge) {

                oldestAge =
                        person.getAge();
            }
        }

        return oldestAge;
    }

    private void removePersonById(String id) {

        for (int i = 0; i < people.size(); i++) {

            Person person =
                    (Person) people.get(i);

            if (person.getId().equals(id)) {

                people.remove(i);

                return;
            }
        }
    }
}