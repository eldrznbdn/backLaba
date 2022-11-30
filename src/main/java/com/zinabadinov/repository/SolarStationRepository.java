package com.zinabadinov.repository;

import com.zinabadinov.domain.SolarStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarStationRepository extends JpaRepository<SolarStationEntity,Integer> {
}
