package com.zinabadinov.service.impl;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.AmountOfStationRepository;
import com.zinabadinov.service.AmountOfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AmountOfStationServiceImpl implements AmountOfStationService {

    @Autowired
    AmountOfStationRepository amountOfStationRepository;

    @Override
    public List<AmountOfStationEntity> findAll() {
        return amountOfStationRepository.findAll();
    }

    @Override
    public AmountOfStationEntity findById(Integer id) {
        return amountOfStationRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public AmountOfStationEntity create(AmountOfStationEntity entity) {
        amountOfStationRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, AmountOfStationEntity entity) {
        AmountOfStationEntity amountOfStationEntity = amountOfStationRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        amountOfStationEntity.setId(entity.getId());
        amountOfStationEntity.setAmount(entity.getAmount());
        amountOfStationEntity.setOwnerSByOwnerSId(entity.getOwnerSByOwnerSId());
        amountOfStationRepository.save(amountOfStationEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        AmountOfStationEntity amountOfStationEntity = amountOfStationRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        amountOfStationRepository.delete(amountOfStationEntity);
    }
}
