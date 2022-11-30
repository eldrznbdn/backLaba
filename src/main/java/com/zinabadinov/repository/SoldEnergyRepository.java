package com.zinabadinov.repository;

import com.zinabadinov.domain.SoldEnergyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldEnergyRepository extends JpaRepository<SoldEnergyEntity,Integer> {
}
