package com.zinabadinov.service.impl;

import com.zinabadinov.domain.OwnerSEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.OwnerSRepository;
import com.zinabadinov.service.OwnerSService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerSServiceImpl implements OwnerSService {

    @Autowired
    OwnerSRepository ownerSRepository;

    @Override
    public List<OwnerSEntity> findAll() {
        return ownerSRepository.findAll();
    }

    @Override
    public OwnerSEntity findById(Integer id) {
        return ownerSRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public OwnerSEntity create(OwnerSEntity entity) {
        ownerSRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, OwnerSEntity entity) {
        OwnerSEntity ownerSEntity = ownerSRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        ownerSEntity.setId(entity.getId());
        ownerSEntity.setName(entity.getName());
        ownerSEntity.setSurname(entity.getSurname());
        ownerSRepository.save(ownerSEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        OwnerSEntity ownerSEntity = ownerSRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        ownerSRepository.delete(ownerSEntity);
    }


    @Override
    public void insertIntoOwner(String name,String surname) {
        ownerSRepository.insertIntoOwner(name,surname);
    }

    @Override
    public void insertIntoOwner10Rows() {
        ownerSRepository.insertIntoOwner10Rows();
    }
}
