package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.domain.PanelEntity;
import com.zinabadinov.domain.SolarStationEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.SolarStationDto;
import com.zinabadinov.dto.assembler.SolarStationDtoAssembler;
import com.zinabadinov.service.SolarStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/SolarStation")
public class SolarStationController {

    @Autowired
    SolarStationService solarStationService;

    @Autowired
    SolarStationDtoAssembler solarStationDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<SolarStationDto>> getContent() {
        List<SolarStationEntity> content = solarStationService.findAll();
        CollectionModel<SolarStationDto> temp = solarStationDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SolarStationDto> addContent(@RequestBody SolarStationEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        SolarStationEntity item = solarStationService.create(entity);
        SolarStationDto temp = solarStationDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolarStationDto> getById(@PathVariable Integer id) {
        SolarStationEntity content = solarStationService.findById(id);
        SolarStationDto temp = solarStationDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        solarStationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody SolarStationEntity item, @PathVariable Integer id) {
        solarStationService.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
