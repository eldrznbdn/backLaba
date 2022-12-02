package com.zinabadinov.repository;

import com.zinabadinov.domain.ElectricityPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityPriceRepository extends JpaRepository<ElectricityPriceEntity,Integer> {
    @Query(value = "CALL select_sum_electricity_price();", nativeQuery = true)
    Integer sumMoney();

}
