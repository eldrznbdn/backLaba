package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.BattaryChargeController;
import com.zinabadinov.domain.BattaryChargeEntity;
import com.zinabadinov.dto.BattaryChargeDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BattaryChargeDtoAssembler implements RepresentationModelAssembler<BattaryChargeEntity, BattaryChargeDto> {
    @Override
    public BattaryChargeDto toModel(BattaryChargeEntity entity) {
        BattaryChargeDto battaryCharge = BattaryChargeDto.builder()
                .id(entity.getId())
                .typeOfCharge(entity.getTypeOfCharge())
                .solarStationId(entity.getSolarStationBySolarStationId().getId())
                .build();
        Link selfLink = linkTo(methodOn(BattaryChargeController.class).getById(battaryCharge.getId())).withSelfRel();
        battaryCharge.add(selfLink);
        return battaryCharge;
    }

    @Override
    public CollectionModel<BattaryChargeDto> toCollectionModel(Iterable<? extends BattaryChargeEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(BattaryChargeController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }

}
