package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.controller.SoldEnergyController;
import com.zinabadinov.domain.SoldEnergyEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.SoldEnergyDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SoldEnergyDtoAssembler implements RepresentationModelAssembler<SoldEnergyEntity, SoldEnergyDto> {
    @Override
    public SoldEnergyDto toModel(SoldEnergyEntity entity) {
        SoldEnergyDto soldEnergyDto = SoldEnergyDto.builder()
                .id(entity.getId())
                .amountOfSoldEnergy(entity.getAmountOfSoldEnergy())
                .solarStationId(entity.getSolarStationBySolarStationId().getId())
                .build();
        Link selfLink = linkTo(methodOn(SoldEnergyController.class).getById(soldEnergyDto.getId())).withSelfRel();
        soldEnergyDto.add(selfLink);
        return soldEnergyDto;
    }

    @Override
    public CollectionModel<SoldEnergyDto> toCollectionModel(Iterable<? extends SoldEnergyEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SoldEnergyController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }

}
