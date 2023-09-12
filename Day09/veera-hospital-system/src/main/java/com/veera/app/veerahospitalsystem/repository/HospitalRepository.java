package com.veera.app.veerahospitalsystem.repository;

import com.veera.app.veerahospitalsystem.model.Hospital;
import com.veera.app.veerahospitalsystem.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}
