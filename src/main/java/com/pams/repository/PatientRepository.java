package com.pams.repository;

import com.pams.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    List<Patient> findAll();
    Optional<Patient> findById(int id);
}
