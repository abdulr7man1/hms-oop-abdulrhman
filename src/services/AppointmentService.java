package services;

import entities.Appointment;
import entities.Patient;
import entities.Doctor;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class AppointmentService
        implements Manageable, Searchable {

    private ArrayList appointments;

    public AppointmentService() {
        appointments = new ArrayList();
    }

    public Appointment schedule(
            String appointmentId,
            String patientId,
            String doctorId,
            String appointmentDate) {

        Appointment appointment =
                new Appointment(
                        appointmentId,
                        patientId,
                        doctorId,
                        appointmentDate,
                        "",
                        "Scheduled",
                        "",
                        false
                );

        add(appointment);

        return appointment;
    }

    public Appointment schedule(
            String appointmentId,
            String patientId,
            String doctorId,
            String appointmentDate,
            String appointmentTime) {

        Appointment appointment =
                new Appointment(
                        appointmentId,
                        patientId,
                        doctorId,
                        appointmentDate,
                        appointmentTime,
                        "Scheduled",
                        "",
                        false
                );

        add(appointment);

        return appointment;
    }

    public Appointment schedule(
            String appointmentId,
            Patient patient,
            Doctor doctor,
            String appointmentDate,
            String appointmentTime,
            String reason) {

        Appointment appointment =
                new Appointment(
                        appointmentId,
                        patient.getId(),
                        doctor.getId(),
                        appointmentDate,
                        appointmentTime,
                        "Scheduled",
                        reason,
                        false
                );

        add(appointment);

        return appointment;
    }

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Appointment)) {
            throw new IllegalArgumentException(
                    "Only Appointment objects can be added."
            );
        }

        appointments.add(entity);
    }

    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0;
             i < appointments.size();
             i++) {

            Appointment appointment =
                    (Appointment) appointments.get(i);

            if (appointment.getAppointmentId()
                    .equals(id)) {

                appointments.remove(i);

                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] getAll() {
        return appointments.toArray();
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

        for (Object object : appointments) {

            Appointment appointment =
                    (Appointment) object;

            if (appointment.getAppointmentId()
                    .toLowerCase().contains(value)
                    || appointment.getPatientId()
                    .toLowerCase().contains(value)
                    || appointment.getDoctorId()
                    .toLowerCase().contains(value)
                    || appointment.getStatus()
                    .toLowerCase().contains(value)
                    || appointment.getReason()
                    .toLowerCase().contains(value)) {

                results.add(appointment);
            }
        }

        return results.toArray();
    }

    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Object object : appointments) {

            Appointment appointment =
                    (Appointment) object;

            if (appointment.getAppointmentId()
                    .equals(id)) {

                return appointment;
            }
        }

        return null;
    }

    public boolean cancel(String appointmentId) {

        Appointment appointment =
                (Appointment) searchById(appointmentId);

        if (appointment == null) {
            return false;
        }

        appointment.cancel();

        return true;
    }

    public boolean complete(String appointmentId) {

        Appointment appointment =
                (Appointment) searchById(appointmentId);

        if (appointment == null) {
            return false;
        }

        appointment.complete();

        return true;
    }

    public boolean reschedule(
            String appointmentId,
            String newDate,
            String newTime) {

        Appointment appointment =
                (Appointment) searchById(appointmentId);

        if (appointment == null) {
            return false;
        }

        appointment.reschedule(
                newDate,
                newTime
        );

        return true;
    }

    public Object[] listByStatus(String status) {

        ArrayList results =
                new ArrayList();

        if (status == null ||
                status.trim().isEmpty()) {

            return results.toArray();
        }

        for (Object object : appointments) {

            Appointment appointment =
                    (Appointment) object;

            if (appointment.getStatus()
                    .equalsIgnoreCase(status)) {

                results.add(appointment);
            }
        }

        return results.toArray();
    }

    public Object[] listByPatient(String patientId) {

        ArrayList results =
                new ArrayList();

        if (patientId == null ||
                patientId.trim().isEmpty()) {

            return results.toArray();
        }

        for (Object object : appointments) {

            Appointment appointment =
                    (Appointment) object;

            if (appointment.getPatientId()
                    .equals(patientId)) {

                results.add(appointment);
            }
        }

        return results.toArray();
    }
}