package com.zinabadinov.service.impl;

import com.zinabadinov.domain.PanelEntity;
import com.zinabadinov.exception.ItemNotFound;
import com.zinabadinov.repository.PanelRepository;
import com.zinabadinov.service.PanelService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelServiceImpl implements PanelService {

    @Autowired
    PanelRepository panelRepository;

    @Override
    public List<PanelEntity> findAll() {
        return panelRepository.findAll();
    }

    @Override
    public PanelEntity findById(Integer id) {
        return panelRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    @Override
    @Transactional
    public PanelEntity create(PanelEntity entity) {
        panelRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer id, PanelEntity entity) {
        PanelEntity panelEntity = panelRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        panelEntity.setId(entity.getId());
        panelEntity.setAmountOfPanel(entity.getAmountOfPanel());
        panelEntity.setSolarStationBySolarStationId(entity.getSolarStationBySolarStationId());
        panelRepository.save(panelEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        PanelEntity panelEntity = panelRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id));
        panelRepository.delete(panelEntity);
    }
}
