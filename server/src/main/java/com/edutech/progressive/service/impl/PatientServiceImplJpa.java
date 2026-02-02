package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service
public class PatientServiceImplJpa implements PatientService {
    private final PatientRepository patientRepository;
    public PatientServiceImplJpa(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() throws Exception {
        return patientRepository.findAll();
    }

    @Override
    public Integer addPatient(Patient patient) throws Exception {
        Patient p = patientRepository.save(patient);
        return p.getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() throws Exception {
        List<Patient> patients = patientRepository.findAll();
        Collections.sort(patients);
        return patients;
    }
    

}