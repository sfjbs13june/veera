package com.veera.app.mongodbhospitalmanagement.respository;

import com.veera.app.mongodbhospitalmanagement.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {

    public Hospital findByhospitalname(String hospitalname);

    public Hospital deleteByhospitalname(String hospitalname);

    public Hospital save(Hospital hospital);
}
