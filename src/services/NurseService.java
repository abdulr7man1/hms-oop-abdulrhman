package services;

import entities.Nurse;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class NurseService implements Manageable, Searchable {

    private ArrayList nurses;

    public NurseService() {
        nurses = new ArrayList();
    }

    public Nurse add(Nurse nurse) {

        if (nurse == null) {
            throw new IllegalArgumentException(
                    "Nurse cannot be null."
            );
        }

        nurses.add(nurse);

        return nurse;
    }

    @Override
    public void add(Object entity) {

        if (!(entity instanceof Nurse)) {
            throw new IllegalArgumentException(
                    "Only Nurse objects can be added."
            );
        }

        nurses.add(entity);
    }

    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < nurses.size(); i++) {

            Nurse nurse =
                    (Nurse) nurses.get(i);

            if (nurse.getId().equals(id)) {

                nurses.remove(i);

                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] getAll() {

        return nurses.toArray();
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

        for (Object object : nurses) {

            Nurse nurse =
                    (Nurse) object;

            if (nurse.getId().toLowerCase().contains(value)
                    || nurse.getFirstName().toLowerCase().contains(value)
                    || nurse.getLastName().toLowerCase().contains(value)
                    || nurse.getFullName().toLowerCase().contains(value)
                    || nurse.getDepartmentId().toLowerCase().contains(value)
                    || nurse.getShift().toLowerCase().contains(value)) {

                results.add(nurse);
            }
        }

        return results.toArray();
    }

    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Object object : nurses) {

            Nurse nurse =
                    (Nurse) object;

            if (nurse.getId().equals(id)) {
                return nurse;
            }
        }

        return null;
    }

    public Object[] listByShift(String shift) {

        ArrayList results =
                new ArrayList();

        if (shift == null ||
                shift.trim().isEmpty()) {

            return results.toArray();
        }

        for (Object object : nurses) {

            Nurse nurse =
                    (Nurse) object;

            if (nurse.getShift()
                    .equalsIgnoreCase(shift)) {

                results.add(nurse);
            }
        }

        return results.toArray();
    }

    public boolean reassign(
            String oldNurseId,
            String newNurseId,
            String patientId) {

        Nurse oldNurse =
                (Nurse) searchById(oldNurseId);

        Nurse newNurse =
                (Nurse) searchById(newNurseId);

        if (oldNurse == null || newNurse == null) {
            return false;
        }

        oldNurse.unassignPatient(patientId);
        newNurse.assignPatient(patientId);

        return true;
    }
}