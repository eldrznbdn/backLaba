package com.zinabadinov.controller;


import com.zinabadinov.domain.BattaryChargeEntity;
import com.zinabadinov.domain.ElectricityPriceEntity;
import com.zinabadinov.dto.assembler.ElectricityPriceDtoAssembler;
import com.zinabadinov.dto.ElectricityPriceDto;
import com.zinabadinov.service.ElectricityPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/electricityPrice")
public class ElectricityPriceController {
    @Autowired
    ElectricityPriceService electricityPriceService;

    @Autowired
    ElectricityPriceDtoAssembler electricityPriceDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<ElectricityPriceDto>> getContent() {
        List<ElectricityPriceEntity> content = electricityPriceService.findAll();
        CollectionModel<ElectricityPriceDto> temp = electricityPriceDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ElectricityPriceDto> addContent(@RequestBody ElectricityPriceEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        ElectricityPriceEntity item = electricityPriceService.create(entity);
        ElectricityPriceDto temp = electricityPriceDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectricityPriceDto> getById(@PathVariable Integer id) {
        ElectricityPriceEntity content = electricityPriceService.findById(id);
        ElectricityPriceDto temp = electricityPriceDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        electricityPriceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody ElectricityPriceEntity item, @PathVariable Integer id) {
        electricityPriceService.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sum-money")
    public ResponseEntity<Integer> sumMoney() {
        var content = electricityPriceService.sumMoney();
        return new ResponseEntity<>(content, HttpStatus.OK);
    }


}
