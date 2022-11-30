package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.ElectricityPriceController;
import com.zinabadinov.domain.ElectricityPriceEntity;
import com.zinabadinov.dto.ElectricityPriceDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ElectricityPriceDtoAssembler implements RepresentationModelAssembler<ElectricityPriceEntity, ElectricityPriceDto> {
    @Override
    public ElectricityPriceDto toModel(ElectricityPriceEntity entity) {
        ElectricityPriceDto electricityprice = ElectricityPriceDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .solarStationId(entity.getSolarStationBySolarStationId().getId())
                .build();
        Link selfLink = linkTo(methodOn(ElectricityPriceController.class).getById(electricityprice.getId())).withSelfRel();
        electricityprice.add(selfLink);
        return electricityprice;
    }

    @Override
    public CollectionModel<ElectricityPriceDto> toCollectionModel(Iterable<? extends ElectricityPriceEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ElectricityPriceController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
