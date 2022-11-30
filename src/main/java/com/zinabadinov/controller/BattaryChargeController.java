package com.zinabadinov.controller;

import com.zinabadinov.domain.BattaryChargeEntity;
import com.zinabadinov.dto.assembler.BattaryChargeDtoAssembler;
import com.zinabadinov.dto.BattaryChargeDto;
import com.zinabadinov.service.BattaryChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/battaryCharge")
public class BattaryChargeController {

    @Autowired
    BattaryChargeService battaryChargeService;

    @Autowired
    BattaryChargeDtoAssembler battaryChargeDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<BattaryChargeDto>> getContent() {
        List<BattaryChargeEntity> content = battaryChargeService.findAll();
        CollectionModel<BattaryChargeDto> temp = battaryChargeDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<BattaryChargeDto> addContent(@RequestBody BattaryChargeEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        BattaryChargeEntity item = battaryChargeService.create(entity);
        BattaryChargeDto temp = battaryChargeDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BattaryChargeDto> getById(@PathVariable Integer id) {
        BattaryChargeEntity content = battaryChargeService.findById(id);
        BattaryChargeDto temp = battaryChargeDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }


}
