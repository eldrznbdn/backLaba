package com.zinabadinov.service.impl;

import com.zinabadinov.domain.SolarStationEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.SolarStationRepository;
import com.zinabadinov.service.SolarStationService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarStationServiceImpl implements SolarStationService {

    @Autowired
    SolarStationRepository solarStationRepository;

    @Override
    public List<SolarStationEntity> findAll() {
        return solarStationRepository.findAll();
    }

    @Override
    public SolarStationEntity findById(Integer id) {
        return solarStationRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));

    }

    @Override
    @Transactional
    public SolarStationEntity create(SolarStationEntity entity) {
        solarStationRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, SolarStationEntity entity) {
        SolarStationEntity solarStationEntity = solarStationRepository.findById(id)
                .orElseThrow(()-> new ItemNotFound(id));
        solarStationEntity.setId(entity.getId());
        solarStationEntity.setCapacity(entity.getCapacity());
        solarStationEntity.setCountry(entity.getCountry());
        solarStationEntity.setTypeStation(entity.getTypeStation());
        solarStationRepository.save(solarStationEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        SolarStationEntity solarStationEntity = solarStationRepository.findById(id)
                .orElseThrow(()-> new ItemNotFound(id));
        solarStationRepository.delete(solarStationEntity);
    }
}
