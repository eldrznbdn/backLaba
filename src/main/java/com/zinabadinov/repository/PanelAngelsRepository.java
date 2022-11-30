package com.zinabadinov.repository;

import com.zinabadinov.domain.PanelAngelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelAngelsRepository extends JpaRepository<PanelAngelsEntity,Integer> {
}
