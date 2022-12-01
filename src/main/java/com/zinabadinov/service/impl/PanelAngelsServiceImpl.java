package com.zinabadinov.service.impl;

import com.zinabadinov.domain.PanelAngelsEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.PanelAngelsRepository;
import com.zinabadinov.service.PanelAngelsService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelAngelsServiceImpl implements PanelAngelsService {

    @Autowired
    PanelAngelsRepository panelAngelsRepository;

    @Override
    public List<PanelAngelsEntity> findAll() {
        return panelAngelsRepository.findAll();
    }

    @Override
    public PanelAngelsEntity findById(Integer id) {
        return panelAngelsRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public PanelAngelsEntity create(PanelAngelsEntity entity) {
        panelAngelsRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, PanelAngelsEntity entity) {
        PanelAngelsEntity panelAngelsEntity = panelAngelsRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        panelAngelsEntity.setId(entity.getId());
        panelAngelsEntity.setTilt(entity.getTilt());
        panelAngelsEntity.setPanelByPanelId(entity.getPanelByPanelId());
        panelAngelsRepository.save(panelAngelsEntity);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        PanelAngelsEntity panelAngelsEntity = panelAngelsRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        panelAngelsRepository.delete(panelAngelsEntity);
    }
}
