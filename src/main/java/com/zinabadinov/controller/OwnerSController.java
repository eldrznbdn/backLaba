package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.domain.InstalationDateEntity;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        ownerSService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody OwnerSEntity item, @PathVariable Integer id) {
        ownerSService.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new-procedure/{name}")
    public ResponseEntity<?> insertUsingProcedure(@PathVariable String name,@PathVariable String surname) {
        ownerSService.insertIntoOwner(name,surname);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/procedure")
    public ResponseEntity<?> insert10Rows() {
        ownerSService.insertIntoOwner10Rows();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
