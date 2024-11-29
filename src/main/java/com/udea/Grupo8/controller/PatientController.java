package com.udea.Grupo8.controller;

import com.udea.Grupo8.model.Patient;
import com.udea.Grupo8.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/patients")
@Tag(name = "Patients", description = "Gestión de pacientes")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Operation(summary = "Obtener paciente por cédula", description = "Devuelve un paciente dado su número de cédula")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Patient.class))),
            @ApiResponse(responseCode = "404", description = "Paciente no encontrado",
                    content = @Content)
    })
    @GetMapping("/{cedula}")
    public ResponseEntity<Patient> getPatientByCedula(@PathVariable String cedula) {
        return patientService.getPatientByCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo paciente", description = "Registra un nuevo paciente en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente creado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Patient.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.savePatient(patient));
    }
}

