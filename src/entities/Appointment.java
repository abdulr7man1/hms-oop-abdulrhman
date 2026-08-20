package entities;
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
}
