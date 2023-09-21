package com.veera.app.veeraspringmysqlapp.repository;

import com.veera.app.veeraspringmysqlapp.model.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
    Object getHospital(String s);
}
