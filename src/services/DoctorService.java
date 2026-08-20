package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class DoctorService implements Manageable, Searchable {

    private ArrayList doctors;

    public DoctorService() {
        doctors = new ArrayList();
    }

    public Doctor add(Doctor doctor) {

        if (doctor == null) {
            throw new IllegalArgumentException(
                    "Doctor cannot be null."
            );
        }

        doctors.add(doctor);

        return doctor;
    }

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Doctor)) {
            throw new IllegalArgumentException(
                    "Only Doctor objects can be added."
            );
        }

        doctors.add(entity);
    }

    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor =
                    (Doctor) doctors.get(i);

            if (doctor.getId().equals(id)) {
                doctors.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] getAll() {
        return doctors.toArray();
    }

    @Override
    public Object[] search(String keyword) {

        ArrayList results =
                new ArrayList();

        if (keyword == null ||
                keyword.trim().isEmpty()) {

            return results.toArray();
        }

        String value =
                keyword.trim().toLowerCase();

        for (Object object : doctors) {

            Doctor doctor =
                    (Doctor) object;

            if (doctor.getId().toLowerCase().contains(value)
                    || doctor.getFirstName().toLowerCase().contains(value)
                    || doctor.getLastName().toLowerCase().contains(value)
                    || doctor.getFullName().toLowerCase().contains(value)
                    || doctor.getSpecialization().toLowerCase().contains(value)) {

                results.add(doctor);
            }
        }

        return results.toArray();
    }

    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Object object : doctors) {

            Doctor doctor =
                    (Doctor) object;

            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }

        return null;
    }

    public Surgeon addSurgeon(Surgeon surgeon) {

        if (surgeon == null) {
            throw new IllegalArgumentException(
                    "Surgeon cannot be null."
            );
        }

        doctors.add(surgeon);

        return surgeon;
    }

    public boolean assignPatient(
            String doctorId,
            String patientId) {

        Doctor doctor =
                (Doctor) searchById(doctorId);

        if (doctor == null) {
            return false;
        }

        doctor.assignPatient(patientId);

        return true;
    }

    public Object[] listBySpecialization(
            String specialization) {

        ArrayList results =
                new ArrayList();

        if (specialization == null ||
                specialization.trim().isEmpty()) {

            return results.toArray();
        }

        for (Object object : doctors) {

            Doctor doctor =
                    (Doctor) object;

            if (doctor.getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                results.add(doctor);
            }
        }

        return results.toArray();
    }

    public Object[] availableDoctors() {

        ArrayList results =
                new ArrayList();

        for (Object object : doctors) {

            Doctor doctor =
                    (Doctor) object;

            if (doctor.hasSlot("")) {
                results.add(doctor);
            }
        }

        return results.toArray();
    }
}