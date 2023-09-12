package com.veera.app.veerahospitalsystem.repository;

import com.veera.app.veerahospitalsystem.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
