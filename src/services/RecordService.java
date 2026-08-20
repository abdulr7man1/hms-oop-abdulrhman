package services;

import entities.MedicalRecord;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class RecordService
        implements Manageable, Searchable {

    private ArrayList records;

    public RecordService() {
        records = new ArrayList();
    }

    public MedicalRecord add(
            MedicalRecord record) {

        if (record == null) {
            throw new IllegalArgumentException(
                    "Medical record cannot be null."
            );
        }

        records.add(record);

        return record;
    }

    @Override
    public void add(Object entity) {

        if (!(entity instanceof MedicalRecord)) {
            throw new IllegalArgumentException(
                    "Only MedicalRecord objects can be added."
            );
        }

        records.add(entity);
    }

    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0;
             i < records.size();
             i++) {

            MedicalRecord record =
                    (MedicalRecord) records.get(i);

            if (record.getRecordId()
                    .equals(id)) {

                records.remove(i);

                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] getAll() {

        return records.toArray();
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

        for (Object object : records) {

            MedicalRecord record =
                    (MedicalRecord) object;

            if (record.getRecordId()
                    .toLowerCase().contains(value)
                    || record.getPatientId()
                    .toLowerCase().contains(value)
                    || record.getDoctorId()
                    .toLowerCase().contains(value)
                    || record.getDiagnosis()
                    .toLowerCase().contains(value)
                    || record.getPrescription()
                    .toLowerCase().contains(value)
                    || record.getNotes()
                    .toLowerCase().contains(value)) {

                results.add(record);
            }
        }

        return results.toArray();
    }

    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Object object : records) {

            MedicalRecord record =
                    (MedicalRecord) object;

            if (record.getRecordId()
                    .equals(id)) {

                return record;
            }
        }

        return null;
    }

    public Object[] listByPatient(
            String patientId) {

        ArrayList results =
                new ArrayList();

        if (patientId == null ||
                patientId.trim().isEmpty()) {

            return results.toArray();
        }

        for (Object object : records) {

            MedicalRecord record =
                    (MedicalRecord) object;

            if (record.getPatientId()
                    .equals(patientId)) {

                results.add(record);
            }
        }

        return results.toArray();
    }

    public int countConfidential() {

        int count = 0;

        for (Object object : records) {

            MedicalRecord record =
                    (MedicalRecord) object;

            if (record.isConfidential()) {
                count++;
            }
        }

        return count;
    }
}