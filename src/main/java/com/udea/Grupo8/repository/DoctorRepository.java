package com.udea.Grupo8.repository;

import com.udea.Grupo8.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DoctorRepository extends JpaRepository<Doctor, Long> { }
