package com.zinabadinov.repository;

import com.zinabadinov.domain.BattaryChargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattaryChargeRepository extends JpaRepository<BattaryChargeEntity,Integer> {
}
