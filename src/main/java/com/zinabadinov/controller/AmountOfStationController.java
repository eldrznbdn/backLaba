package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.assembler.AmountOfStationDtoAssembler;
import com.zinabadinov.service.AmountOfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/amountOfStation")
public class AmountOfStationController {

    @Autowired
    AmountOfStationService amountOfStationService;

    @Autowired
    AmountOfStationDtoAssembler amountOfStationDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<AmountOfStationDto>> getAllAmountOfStation() {
        List<AmountOfStationEntity> content = amountOfStationService.findAll();
        CollectionModel<AmountOfStationDto> temp = amountOfStationDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<AmountOfStationDto> addAmountOfStation(@RequestBody AmountOfStationEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        AmountOfStationEntity item = amountOfStationService.create(entity);
        AmountOfStationDto temp = amountOfStationDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmountOfStationDto> getById(@PathVariable Integer id) {
        AmountOfStationEntity content = amountOfStationService.findById(id);
        AmountOfStationDto temp = amountOfStationDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

}
