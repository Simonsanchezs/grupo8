package com.udea.Grupo8.service;

import com.udea.Grupo8.model.Patient;
import com.udea.Grupo8.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientByCedula(String cedula) {
        return patientRepository.findByCedula(cedula);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
