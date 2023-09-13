package com.veera.app.mongodbhospitalmanagement.respository;

import com.veera.app.mongodbhospitalmanagement.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    public Patient findByPatientName(String patientname);

    public Patient findByPatientId(String patientid);

    public Patient findByHospitalName(String hospitalname);

    public Patient findByDisease(String disease);

    public Patient deleteByPatientName(String patientname);

    public Patient save(Patient patient);
}
