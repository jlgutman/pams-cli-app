package com.pams.service;

import com.pams.dto.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientDTO> getAllPatientsSortedByAgeDesc();
    Optional<PatientDTO> findById(int id);
}
