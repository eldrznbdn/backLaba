package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.domain.PanelAngelsEntity;
import com.zinabadinov.domain.PanelEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.PanelDto;
import com.zinabadinov.dto.assembler.PanelDtoAssembler;
import com.zinabadinov.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/panel")
public class PanelController {

    @Autowired
    PanelService panelService;

    @Autowired
    PanelDtoAssembler panelDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<PanelDto>> getContent() {
        List<PanelEntity> content = panelService.findAll();
        CollectionModel<PanelDto> temp = panelDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<PanelDto> addContent(@RequestBody PanelEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        PanelEntity item = panelService.create(entity);
        PanelDto temp = panelDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanelDto> getById(@PathVariable Integer id) {
        PanelEntity content = panelService.findById(id);
        PanelDto temp = panelDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        panelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody PanelEntity item, @PathVariable Integer id) {
        panelService.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
