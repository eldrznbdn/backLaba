package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.domain.SoldEnergyEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.SolarStationDto;
import com.zinabadinov.dto.SoldEnergyDto;
import com.zinabadinov.dto.assembler.SolarStationDtoAssembler;
import com.zinabadinov.dto.assembler.SoldEnergyDtoAssembler;
import com.zinabadinov.service.SoldEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/SoldEnergy")
public class SoldEnergyController {

    @Autowired
    SoldEnergyService soldEnergyService;

    @Autowired
    SoldEnergyDtoAssembler soldEnergyDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<SoldEnergyDto>> getContent() {
        List<SoldEnergyEntity> content = soldEnergyService.findAll();
        CollectionModel<SoldEnergyDto> temp = soldEnergyDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SoldEnergyDto> addContent(@RequestBody SoldEnergyEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        SoldEnergyEntity item = soldEnergyService.create(entity);
        SoldEnergyDto temp = soldEnergyDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldEnergyDto> getById(@PathVariable Integer id) {
        SoldEnergyEntity content = soldEnergyService.findById(id);
        SoldEnergyDto temp = soldEnergyDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}
