package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.domain.OwnerSEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.OwnerSDto;
import com.zinabadinov.dto.assembler.OwnerSDtoAssembler;
import com.zinabadinov.service.OwnerSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/OwnerS")
public class OwnerSController {

    @Autowired
    OwnerSService ownerSService;

    @Autowired
    OwnerSDtoAssembler ownerSDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<OwnerSDto>> getContent() {
        List<OwnerSEntity> content = ownerSService.findAll();
        CollectionModel<OwnerSDto> temp = ownerSDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<OwnerSDto> addContent(@RequestBody OwnerSEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        OwnerSEntity item = ownerSService.create(entity);
        OwnerSDto temp = ownerSDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerSDto> getById(@PathVariable Integer id) {
        OwnerSEntity content = ownerSService.findById(id);
        OwnerSDto temp = ownerSDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

}
