package com.udea.Grupo8.repository;

import com.udea.Grupo8.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByCedula(String cedula);
}
