package com.zinabadinov.repository;

import com.zinabadinov.domain.PanelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<PanelEntity,Integer> {
}
