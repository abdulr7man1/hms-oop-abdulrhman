package services;

import entities.Patient;
import entities.InPatient;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;



public class PatientService implements Manageable, Searchable {

    private ArrayList patients;

    public PatientService() {
        patients = new ArrayList();
    }
    public Patient addPatient(
            String id,
            String firstName,
            String lastName) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName
        );

        add(patient);

        return patient;
    }

    public Patient addPatient(
            String id,
            String firstName,
            String lastName,
            String bloodGroup) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName
        );

        patient.setBloodGroup(bloodGroup);

        add(patient);

        return patient;
    }

    public Patient addPatient(Patient patient) {

        if (patient == null) {
            throw new IllegalArgumentException(
                    "Patient cannot be null."
            );
        }

        add(patient);

        return patient;
    }

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Patient)) {
            throw new IllegalArgumentException(
                    "Only Patient objects can be added."
            );
        }

        patients.add(entity);
    }


    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < patients.size(); i++) {

            Patient patient =
                    (Patient) patients.get(i);

            if (patient.getId().equals(id)) {
                patients.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] getAll() {

        return patients.toArray();
    }


    @Override
    public Object[] search(String keyword) {

        ArrayList results = new ArrayList();

        if (keyword == null ||
                keyword.trim().isEmpty()) {

            return results.toArray();
        }

        String value =
                keyword.trim().toLowerCase();

        for (Object object : patients) {

            Patient patient =
                    (Patient) object;

            if (patient.getId().toLowerCase().contains(value)
                    || patient.getFirstName().toLowerCase().contains(value)
                    || patient.getLastName().toLowerCase().contains(value)
                    || patient.getFullName().toLowerCase().contains(value)) {

                results.add(patient);
            }
        }

        return results.toArray();
    }

    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Object object : patients) {

            Patient patient =
                    (Patient) object;

            if (patient.getId().equals(id)) {
                return patient;
            }
        }

        return null;
    }

    public boolean updateContact(
            String patientId,
            String phoneNumber) {

        Patient patient =
                (Patient) searchById(patientId);

        if (patient == null) {
            return false;
        }

        patient.setPhoneNumber(phoneNumber);

        return true;
    }

    public boolean updateContact(
            String patientId,
            String phoneNumber,
            String email) {

        Patient patient =
                (Patient) searchById(patientId);

        if (patient == null) {
            return false;
        }

        patient.setPhoneNumber(phoneNumber);
        patient.setEmail(email);

        return true;
    }

    public Object[] listInPatients() {

        ArrayList results =
                new ArrayList();

        for (Object object : patients) {

            Patient patient =
                    (Patient) object;

            if (patient instanceof InPatient) {
                results.add(patient);
            }
        }

        return results.toArray();
    }


    public double totalOutstanding() {

        double total = 0.0;

        for (Object object : patients) {

            Patient patient =
                    (Patient) object;

            total += patient.getOutstandingBalance();
        }

        return total;
    }
}