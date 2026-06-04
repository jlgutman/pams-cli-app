package com.pams.service;

import com.pams.dto.AddressDTO;
import com.pams.dto.PatientDTO;
import com.pams.model.Address;
import com.pams.model.Patient;
import com.pams.repository.PatientRepository;
import com.pams.repository.PatientRepositoryImpl;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {

    private static final DateTimeFormatter DOB_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final PatientRepository repository;

    public PatientServiceImpl() {
        this.repository = PatientRepositoryImpl.getInstance();
    }

    @Override
    public List<PatientDTO> getAllPatientsSortedByAgeDesc() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingInt(Patient::getAge).reversed())
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PatientDTO> findById(int id) {
        return repository.findById(id).map(this::toDTO);
    }

    private PatientDTO toDTO(Patient p) {
        AddressDTO addressDTO = p.getMailingAddress() != null ? toAddressDTO(p.getMailingAddress()) : null;
        return new PatientDTO(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getPhoneNumber(),
                p.getEmail(),
                addressDTO,
                p.getDateOfBirth().format(DOB_FORMATTER),
                p.getAge());
    }

    private AddressDTO toAddressDTO(Address a) {
        return new AddressDTO(a.getStreet(), a.getCity(), a.getState(), a.getZip());
    }
}
