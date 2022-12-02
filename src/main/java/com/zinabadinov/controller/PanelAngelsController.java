package com.zinabadinov.controller;

import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.domain.OwnerSEntity;
import com.zinabadinov.domain.PanelAngelsEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.PanelAngelsDto;
import com.zinabadinov.dto.assembler.PanelAngelsDtoAssembler;
import com.zinabadinov.service.PanelAngelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/PanelAngels")
public class PanelAngelsController {

    @Autowired
    PanelAngelsService panelAngelsService;

    @Autowired
    PanelAngelsDtoAssembler panelAngelsDtoAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<PanelAngelsDto>> getContent() {
        List<PanelAngelsEntity> content = panelAngelsService.findAll();
        CollectionModel<PanelAngelsDto> temp = panelAngelsDtoAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<PanelAngelsDto> addContent(@RequestBody PanelAngelsEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        PanelAngelsEntity item = panelAngelsService.create(entity);
        PanelAngelsDto temp = panelAngelsDtoAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanelAngelsDto> getById(@PathVariable Integer id) {
        PanelAngelsEntity content = panelAngelsService.findById(id);
        PanelAngelsDto temp = panelAngelsDtoAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        panelAngelsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody PanelAngelsEntity item, @PathVariable Integer id) {
        panelAngelsService.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
