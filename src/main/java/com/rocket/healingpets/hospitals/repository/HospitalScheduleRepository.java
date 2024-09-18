package com.rocket.healingpets.hospitals.repository;

import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.model.entity.HospitalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalScheduleRepository extends JpaRepository<HospitalSchedule, Integer>{
    List<HospitalSchedule> findHospitalSchedulesByHosId(Hospital foundHospital);
}
