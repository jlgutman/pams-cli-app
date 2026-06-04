package com.pams.repository;

import com.pams.model.Address;
import com.pams.model.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PatientRepositoryImpl implements PatientRepository {

    private static PatientRepositoryImpl instance;

    private final List<Patient> patients;

    private PatientRepositoryImpl() {
        patients = new ArrayList<>();
        patients.add(new Patient(1, "Daniel", "Agar",
                "(641) 123-0009", "dagar@m.as",
                new Address("1 N Street", "Des Moines", "IA", "50309"),
                LocalDate.of(1987, 1, 19)));
        patients.add(new Patient(2, "Ana", "Smith",
                null, "amsith@te.edu",
                null,
                LocalDate.of(1948, 12, 5)));
        patients.add(new Patient(3, "Marcus", "Garvey",
                "(123) 292-0018", null,
                new Address("4 East Ave", "Chicago", "IL", "60601"),
                LocalDate.of(2001, 9, 18)));
        patients.add(new Patient(4, "Jeff", "Goldbloom",
                "(999) 165-1192", "jgold@es.co.za",
                null,
                LocalDate.of(1995, 2, 28)));
        patients.add(new Patient(5, "Mary", "Washington",
                null, null,
                new Address("30 W Burlington", "Iowa City", "IA", "52240"),
                LocalDate.of(1932, 5, 31)));
    }

    public static synchronized PatientRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PatientRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<Patient> findAll() {
        return Collections.unmodifiableList(patients);
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst();
    }
}
