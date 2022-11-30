package com.zinabadinov.repository;

import com.zinabadinov.domain.InstalationDateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalationDateRepository extends JpaRepository<InstalationDateEntity,Integer> {
}
