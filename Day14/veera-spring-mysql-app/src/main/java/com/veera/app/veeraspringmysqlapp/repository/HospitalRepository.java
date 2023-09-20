package com.veera.app.veeraspringmysqlapp.repository;

import com.veera.app.veeraspringmysqlapp.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
}
