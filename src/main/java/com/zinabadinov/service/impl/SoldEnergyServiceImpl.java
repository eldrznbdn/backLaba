package com.zinabadinov.service.impl;

import com.zinabadinov.domain.SoldEnergyEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.SoldEnergyRepository;
import com.zinabadinov.service.SoldEnergyService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldEnergyServiceImpl implements SoldEnergyService {

    @Autowired
    SoldEnergyRepository soldEnergyRepository;

    @Override
    public List<SoldEnergyEntity> findAll() {
        return soldEnergyRepository.findAll();
    }

    @Override
    public SoldEnergyEntity findById(Integer id) {
        return soldEnergyRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));

    }

    @Override
    @Transactional
    public SoldEnergyEntity create(SoldEnergyEntity entity) {
        soldEnergyRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, SoldEnergyEntity entity) {
        SoldEnergyEntity soldEnergyEntity = soldEnergyRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        soldEnergyEntity.setId(entity.getId());
        soldEnergyEntity.setAmountOfSoldEnergy(entity.getAmountOfSoldEnergy());
        soldEnergyEntity.setSolarStationBySolarStationId(entity.getSolarStationBySolarStationId());
        soldEnergyRepository.save(soldEnergyEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        SoldEnergyEntity soldEnergyEntity = soldEnergyRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        soldEnergyRepository.delete(soldEnergyEntity);
    }
}
