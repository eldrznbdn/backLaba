package com.zinabadinov.repository;

import com.zinabadinov.domain.ElectricityPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityPriceRepository extends JpaRepository<ElectricityPriceEntity,Integer> {
}
