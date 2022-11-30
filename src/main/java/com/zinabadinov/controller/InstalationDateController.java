package com.zinabadinov.controller;

import com.zinabadinov.domain.InstalationDateEntity;
import com.zinabadinov.dto.assembler.InstalationDateDtoAssembler;
import com.zinabadinov.dto.InstalationDateDto;
import com.zinabadinov.service.InstalationDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/instalationDate")
public class InstalationDateController {

    @Autowired
    InstalationDateService instalationDateService;

    @Autowired
    InstalationDateDtoAssembler instalationDateDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<InstalationDateDto>> getContent() {
        List<InstalationDateEntity> content = instalationDateService.findAll();
        CollectionModel<InstalationDateDto> temp = instalationDateDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<InstalationDateDto> addContent(@RequestBody InstalationDateEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        InstalationDateEntity item = instalationDateService.create(entity);
        InstalationDateDto temp = instalationDateDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstalationDateDto> getById(@PathVariable Integer id) {
        InstalationDateEntity content = instalationDateService.findById(id);
        InstalationDateDto temp = instalationDateDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}
