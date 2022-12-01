package com.zinabadinov.service.impl;

import com.zinabadinov.domain.BattaryChargeEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.BattaryChargeRepository;
import com.zinabadinov.service.BattaryChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BattaryChargeServiceImpl implements BattaryChargeService {

    @Autowired
    BattaryChargeRepository battaryChargeRepository;

    @Override
    public List<BattaryChargeEntity> findAll() {
        return battaryChargeRepository.findAll();
    }

    @Override
    public BattaryChargeEntity findById(Integer id) {
        return battaryChargeRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public BattaryChargeEntity create(BattaryChargeEntity entity) {
        battaryChargeRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, BattaryChargeEntity entity) {
        BattaryChargeEntity battaryChargeEntity = battaryChargeRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        battaryChargeEntity.setId(entity.getId());
        battaryChargeEntity.setTypeOfCharge(entity.getTypeOfCharge());
        battaryChargeEntity.setSolarStationBySolarStationId(entity.getSolarStationBySolarStationId());
        battaryChargeRepository.save(battaryChargeEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        BattaryChargeEntity battaryChargeEntity = battaryChargeRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        battaryChargeRepository.delete(battaryChargeEntity);
    }
}
