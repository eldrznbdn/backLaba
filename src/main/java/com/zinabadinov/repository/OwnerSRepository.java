package com.zinabadinov.repository;

import com.zinabadinov.domain.OwnerSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerSRepository extends JpaRepository<OwnerSEntity,Integer> {
}
