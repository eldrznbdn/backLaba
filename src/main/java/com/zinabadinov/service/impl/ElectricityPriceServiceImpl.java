package com.zinabadinov.service.impl;

import com.zinabadinov.domain.ElectricityPriceEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.ElectricityPriceRepository;
import com.zinabadinov.service.ElectricityPriceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricityPriceServiceImpl implements ElectricityPriceService {

    @Autowired
    ElectricityPriceRepository electricityPriceRepository;

    @Override
    public List<ElectricityPriceEntity> findAll() {
        return electricityPriceRepository.findAll();
    }

    @Override
    public ElectricityPriceEntity findById(Integer id) {
        return electricityPriceRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public ElectricityPriceEntity create(ElectricityPriceEntity entity) {
        electricityPriceRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, ElectricityPriceEntity entity) {
        ElectricityPriceEntity electricityPriceEntity = electricityPriceRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        electricityPriceEntity.setId(entity.getId());
        electricityPriceEntity.setPrice(entity.getPrice());
        electricityPriceEntity.setSolarStationBySolarStationId(entity.getSolarStationBySolarStationId());
        electricityPriceRepository.save(electricityPriceEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ElectricityPriceEntity electricityPriceEntity = electricityPriceRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        electricityPriceRepository.delete(electricityPriceEntity);
    }
}
