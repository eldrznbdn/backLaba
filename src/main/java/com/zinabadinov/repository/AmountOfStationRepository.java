package com.zinabadinov.repository;

import com.zinabadinov.domain.AmountOfStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountOfStationRepository extends JpaRepository<AmountOfStationEntity,Integer> {
}
