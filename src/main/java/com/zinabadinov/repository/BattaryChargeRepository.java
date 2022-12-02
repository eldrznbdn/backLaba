package com.zinabadinov.repository;

import com.zinabadinov.domain.BattaryChargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BattaryChargeRepository extends JpaRepository<BattaryChargeEntity,Integer> {
    @Query(value = "CALL insert_battary_charge(:type_of_charge,:solar_station_id);", nativeQuery = true)
    void insertUsingProcedure(@Param("type_of_charge") String name,@Param("solar_station_id") Integer id);

}
