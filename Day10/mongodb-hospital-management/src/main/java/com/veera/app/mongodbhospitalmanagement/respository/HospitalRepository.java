package com.veera.app.mongodbhospitalmanagement.respository;

import com.veera.app.mongodbhospitalmanagement.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {


    public Hospital findByHospitalName(String hospitalname);

    public Hospital findByHospitalId(String hospitalid);

    public Hospital findByAddress(String address);

    public Hospital deleteByAddress(String address);

    public Hospital deleteByHospitalName(String hospitalname);




}
