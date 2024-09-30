package com.rocket.healingpets.hospitals.repository;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicTypeRepository extends JpaRepository<ClinicType, Integer> {
    List<ClinicType> findClinicTypesByHosId(int hosId);

    ClinicType findClinicTypeByHosIdAndClinicName(int hosId, String clinicName);
}
