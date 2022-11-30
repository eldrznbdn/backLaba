package com.zinabadinov.service.impl;

import com.zinabadinov.domain.InstalationDateEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.InstalationDateRepository;
import com.zinabadinov.service.InstalationDateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalationDateServiceImpl implements InstalationDateService {

    @Autowired
    InstalationDateRepository instalationDateRepository;

    @Override
    public List<InstalationDateEntity> findAll() {
        return instalationDateRepository.findAll();
    }

    @Override
    public InstalationDateEntity findById(Integer id) {
        return instalationDateRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public InstalationDateEntity create(InstalationDateEntity entity) {
        instalationDateRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, InstalationDateEntity entity) {
        InstalationDateEntity instalationDateEntity = instalationDateRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        instalationDateEntity.setId(entity.getId());
        instalationDateEntity.setInsDate(entity.getInsDate());
        instalationDateEntity.setSolarStationBySolarStationId(entity.getSolarStationBySolarStationId());
        instalationDateRepository.save(instalationDateEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        InstalationDateEntity instalationDateEntity = instalationDateRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        instalationDateRepository.delete(instalationDateEntity);
    }
}
