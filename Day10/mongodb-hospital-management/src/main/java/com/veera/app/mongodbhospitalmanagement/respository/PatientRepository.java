package com.veera.app.mongodbhospitalmanagement.respository;

import com.veera.app.mongodbhospitalmanagement.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    public Patient findBypatientname(String patientname);

    public Patient deleteBypatientname(String patientname);

    public Patient save(Patient patient);
}
